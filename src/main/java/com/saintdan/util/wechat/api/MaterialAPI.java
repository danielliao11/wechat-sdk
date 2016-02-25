package com.saintdan.util.wechat.api;

import com.alibaba.fastjson.JSON;
import com.saintdan.util.wechat.bean.VideoMaterialDescription;
import com.saintdan.util.wechat.constant.MaterialConstant;
import com.saintdan.util.wechat.constant.ResourceConstant;
import com.saintdan.util.wechat.constant.TokenConstant;
import com.saintdan.util.wechat.constant.URIConstant;
import com.saintdan.util.wechat.enums.MaterialType;
import com.saintdan.util.wechat.http.DefaultHttpClient;
import com.saintdan.util.wechat.result.MaterialResult;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;

/**
 * API of material.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class MaterialAPI {

    /**
     * Add other material.
     *
     * @param accessToken       access token
     * @param type              material type {@link MaterialType}
     * @param file              upload file
     * @param description       description of video
     * @return                  result {@link MaterialResult}
     */
    public MaterialResult createOtherMaterial(String accessToken, MaterialType type, File file, VideoMaterialDescription description) {
        HttpPost httpPost = new HttpPost(new String(
                new StringBuilder(URIConstant.BASE_URI).append(ResourceConstant.CGI_BIN).append(MaterialConstant.MATERIAL).append(MaterialConstant.ADD_MATERIAL)));
        FileBody fileBody = new FileBody(file);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().addPart(MEDIA, fileBody);
        // If material type is video, add description.
        if (type.isVideo()) {
            multipartEntityBuilder.addTextBody(DESCRIPTION, JSON.toJSONString(description));
        }
        HttpEntity httpEntity = multipartEntityBuilder.addTextBody(TokenConstant.ACCESS_TOKEN, accessToken)
                .addTextBody(TYPE, type.description())
                .build();
        httpPost.setEntity(httpEntity);
        return DefaultHttpClient.executeJsonResult(httpPost, MaterialResult.class);
    }

    /**
     * Delete other material by media id
     *
     * @param accessToken       access token
     * @param mediaId           media id
     * @return                  result {@link MaterialResult}
     */
    public MaterialResult deleteOtherMaterial(String accessToken, String mediaId) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(new String(new StringBuilder(URIConstant.BASE_URI).append(ResourceConstant.CGI_BIN).append(MaterialConstant.MATERIAL).append(MaterialConstant.DEL_MATERIAL)))
                .addParameter(TokenConstant.ACCESS_TOKEN, accessToken)
                .addParameter(MaterialConstant.MEDIA_ID, mediaId)
                .build();
        return DefaultHttpClient.executeJsonResult(httpUriRequest, MaterialResult.class);
    }

    private final static String MEDIA = "media";

    private final static String DESCRIPTION = "description";

    private final static String TYPE = "type";
}
