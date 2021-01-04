package com.cn.service.impl.wx;

import com.cn.beans.wx.WXConstant;
import com.cn.beans.wx.WXMsgInfo;
import com.cn.dao.wx.WXMsgDao;
import com.cn.service.wx.WXMsgService;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WXMsgServiceImpl implements WXMsgService {

    final WXMsgDao wxMsgDao;

    public WXMsgServiceImpl(WXMsgDao wxMsgDao) {
        this.wxMsgDao = wxMsgDao;
    }

    @Override
    public String handleMessage(Map<String, String> messageMap) {
        String msgType = messageMap.get("MsgType");
        //接收请求消息
        WXMsgInfo requestMsgInfo = new WXMsgInfo();
        requestMsgInfo.setRequestMsgType(msgType);
        WXMsgInfo responseMsg;
        if (WXConstant.MSG_TYPE_TEXT.equals(msgType)) {
            String content = messageMap.get("Content");
            if (!StringUtils.isBlank(content)) {
                requestMsgInfo.setKeyWord(content);
                WXMsgInfo searchResponseMsg = wxMsgDao.searchWXResponseMsg(requestMsgInfo);
                if (searchResponseMsg != null) {
                    responseMsg = searchResponseMsg;
                } else {
                    responseMsg = getDefaultResponseWXMsg();
                }
            } else {
                responseMsg = getDefaultResponseWXMsg();
            }
        } else {
            responseMsg = getDefaultResponseWXMsg();
        }
        responseMsg.setToUserName(messageMap.get("FromUserName"));
        responseMsg.setFromUserName(messageMap.get("ToUserName"));
        responseMsg.setCreateTime(messageMap.get("CreateTime"));
        return messageParseXml(responseMsg);

    }

    private WXMsgInfo getDefaultResponseWXMsg() {
        WXMsgInfo responseMessage = new WXMsgInfo();
        responseMessage.setResponseMsgType(WXConstant.MSG_TYPE_TEXT);
        responseMessage.setContent("你好.");
        return responseMessage;
    }

    /**
     * 构建消息回复xml包
     *
     * @param messageInfo 回复消息实体类信息
     * @return 回复消息xml包
     */
    private String messageParseXml(WXMsgInfo messageInfo) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("xml");
        root.addElement("ToUserName").add(DocumentHelper.createCDATA(messageInfo.getToUserName()));
        root.addElement("FromUserName").add(DocumentHelper.createCDATA(messageInfo.getFromUserName()));
        root.addElement("CreateTime").add(DocumentHelper.createText(messageInfo.getCreateTime()));
        root.addElement("MsgType").add(DocumentHelper.createCDATA(messageInfo.getResponseMsgType()));
        switch (messageInfo.getResponseMsgType()) {
            case WXConstant.MSG_TYPE_TEXT:
                root.addElement("Content").add(DocumentHelper.createCDATA(messageInfo.getContent()));
                break;
            case WXConstant.MSG_TYPE_IMAGE:
                setImageVoiceMessage(root, messageInfo, "Image");
                break;
            case WXConstant.MSG_TYPE_VOICE:
                setImageVoiceMessage(root, messageInfo, "Voice");
                break;
            default:
                root.addElement("Content").add(DocumentHelper.createCDATA("消息类型不支持"));
        }
        return document.asXML();
    }

    /**
     * 构建图片类型,语音类型回复消息xml
     *
     * @param root        xml根节点
     * @param messageInfo 消息实体类信息
     * @param type        节点key
     */
    private void setImageVoiceMessage(Element root, WXMsgInfo messageInfo, String type) {
        Element image = root.addElement(type);
        image.addElement("MediaId").add(DocumentHelper.createCDATA(messageInfo.getMediaId()));
    }

}
