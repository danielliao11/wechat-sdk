package com.saintdan.util.wechat.tools;

import com.saintdan.util.wechat.component.ByteGroup;
import com.saintdan.util.wechat.constant.CommonConstant;
import com.saintdan.util.wechat.enums.ErrorType;
import com.saintdan.util.wechat.exception.EncryptException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Encrypt util.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/1/16
 * @since JDK1.8
 */
public class WeChatEncryptUtil {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * SHA1
     *
     * @param src       source string
     * @return          encrypted string by SHA1
     * @throws EncryptException
     */
    public static String SHA1(String src) throws EncryptException {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(src.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // Transform to hex
            for (byte aMessageDigest : messageDigest) {
                String shaHex = Integer.toHexString(aMessageDigest & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new EncryptException(ErrorType.ENC0010);
        }
    }

    /**
     * AES encrypt
     *
     * @param text      source text
     * @param appId     app id of WeChat
     * @param aesKey    AES key
     * @return          AES encrypted string
     * @throws EncryptException
     */
    public static String AESEncrypt(String text, String appId, byte[] aesKey) throws EncryptException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(aesKey, 0, 16);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            // Encrypt
            byte[] encrypted = cipher.doFinal(getContentBytes(text, appId));
            // Base64 encode
            return new Base64().encodeToString(encrypted);
        } catch (Exception e) {
            throw new EncryptException(ErrorType.ENC0011);
        }
    }

    /**
     * AES decrypt
     *
     * @param encryptedText     encrypted text
     * @param appId             app id of WeChat
     * @param aesKey            AES key
     * @return                  AES decrypted string
     * @throws EncryptException
     */
    public static String AESDecrypt(String encryptedText, String appId, byte[] aesKey) throws EncryptException {
        byte[] original;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            // Base64 decode
            original = cipher.doFinal(Base64.decodeBase64(encryptedText));
        } catch (Exception e) {
            throw new EncryptException(ErrorType.ENC0020);
        }
        byte[] bytes = PKCS7Encrypt.decrypt(original);
        byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
        int xmlLength = recoverBigEndian(networkOrder);
        String fromAppId = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length), CommonConstant.UTF8);
        if (!appId.equals(fromAppId)) {
            throw new EncryptException(ErrorType.ENC0020);
        }
        return new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CommonConstant.UTF8);
    }

    // --------------------------
    // PRIVATE METHODS
    // --------------------------

    /**
     * Generate big endian.
     *
     * @param sourceNumber      source
     * @return                  big endian.
     */
    private static byte[] getBigEndian(int sourceNumber) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte) (sourceNumber & 0xFF);
        orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
        orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
        orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
        return orderBytes;
    }

    /**
     * Recover big endian
     *
     * @param orderBytes        big endian
     * @return                  number
     */
    private static int recoverBigEndian(byte[] orderBytes) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    /**
     * Get content bytes
     *
     * @param text          text
     * @param appId         app id
     * @return              content bytes
     */
    private static byte[] getContentBytes(String text, String appId) {
        ByteGroup byteGroup = new ByteGroup();
        byte[] textBytes = text.getBytes(CommonConstant.UTF8);
        // randomStr + bigEndian + text + appId + pad
        byteGroup.addBytes(RandomStringUtils.random(16, true, false).getBytes(CommonConstant.UTF8));
        byteGroup.addBytes(getBigEndian(textBytes.length));
        byteGroup.addBytes(textBytes);
        byteGroup.addBytes(appId.getBytes());
        byteGroup.addBytes(PKCS7Encrypt.encrypt(byteGroup.size()));
        return byteGroup.toBytes();
    }

}
