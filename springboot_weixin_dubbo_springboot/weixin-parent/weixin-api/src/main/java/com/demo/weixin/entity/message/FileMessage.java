package com.demo.weixin.entity.message;


import com.demo.weixin.enums.MessageType;
import com.demo.weixin.exception.WeixinException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wujun
 * @description 文件消息
 * @date 2017/7/31
 * @since 1.0
 */
public class FileMessage extends BasicMessage {

    private String mediaId; // 必填。文件id，可以调用上传临时素材接口获取
    private boolean safe; //  表示是否是保密消息，0表示否，1表示是，默认0

    @Override
    public Map<String, Object> getParamMap() throws WeixinException {
        if (MessageType.FILE != messageType || StringUtils.isBlank(mediaId)) {
            throw new WeixinException(-1, "文件消息类型错误，或文件id为空");
        }

        Map<String, String> mediaMap = new HashMap<>();
        mediaMap.put("media_id", mediaId);

        Map<String, Object> paramMap = super.getParamMap();
        paramMap.put("file", mediaMap);
        paramMap.put("safe", safe ? "1" : "0");
        return paramMap;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

}
