package com.saintdan.util.wechat.tools;

import com.saintdan.util.wechat.constant.CommonConstant;

import java.util.Arrays;

/**
 * Encode with PKCS7.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/1/16
 * @since JDK1.8
 */
public class PKCS7Encrypt {

    /**
     * PKCS7 encrypt
     *
     * @param count     bytes count
     * @return          encrypted bytes
     */
    public static byte[] encrypt(int count) {
        int amountToPad = BLOCK_SIZE - (count % BLOCK_SIZE);
        if (amountToPad == 0) {
            amountToPad = BLOCK_SIZE;
        }
        char padChr = chr(amountToPad);
        String tmp = "";
        for (int index = 0; index < amountToPad; index++) {
            tmp += padChr;
        }
        return tmp.getBytes(CommonConstant.UTF8);
    }

    /**
     * PKCS7 decrypt
     *
     * @param encrypted     encrypted bytes
     * @return              decrypted bytes
     */
    public static byte[] decrypt(byte[] encrypted) {
        int pad = (int) encrypted[encrypted.length - 1];
        if (pad < 1 || pad > 32) {
            pad = 0;
        }
        return Arrays.copyOfRange(encrypted, 0, encrypted.length - pad);
    }

    /**
     * Number to ASCII
     *
     * @param src   source number
     * @return      ASCII
     */
    public static char chr(int src) {
        byte target = (byte) (src & 0xFF);
        return (char) target;
    }

    private static final int BLOCK_SIZE = 32;
}
