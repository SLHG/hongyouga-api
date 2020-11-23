package com.cn.beans.wx;

/**
 * 微信消息实体类
 */
public class WXMsgInfo {
    //接收方id
    private String toUserName;
    //发送方微信号
    private String fromUserName;
    //创建时间(整型)
    private String createTime;
    //请求消息类型
    private String requestMsgType;
    //响应消息类型
    private String responseMsgType;
    //消息关键字
    private String keyWord;
    //文本消息内容
    private String content;
    //图片,语音消息素材id
    private String mediaId;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRequestMsgType() {
        return requestMsgType;
    }

    public void setRequestMsgType(String requestMsgType) {
        this.requestMsgType = requestMsgType;
    }

    public String getResponseMsgType() {
        return responseMsgType;
    }

    public void setResponseMsgType(String responseMsgType) {
        this.responseMsgType = responseMsgType;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "WXMsgInfo{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", requestMsgType='" + requestMsgType + '\'' +
                ", responseMsgType='" + responseMsgType + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", content='" + content + '\'' +
                ", mediaId='" + mediaId + '\'' +
                '}';
    }
}
