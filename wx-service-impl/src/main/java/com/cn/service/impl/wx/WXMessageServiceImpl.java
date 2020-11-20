package com.cn.service.impl.wx;

import com.cn.beans.wx.WXConstant;
import com.cn.beans.wx.WXMessageInfo;
import com.cn.service.wx.WXMessageService;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WXMessageServiceImpl implements WXMessageService {

    @Override
    public String handleMessage(Map<String, String> messageMap) {
        String msgType = messageMap.get("MsgType");
        WXMessageInfo messageInfo = new WXMessageInfo();
        messageInfo.setToUserName(messageMap.get("FromUserName"));
        messageInfo.setFromUserName(messageMap.get("ToUserName"));
        messageInfo.setCreateTime(messageMap.get("CreateTime"));
        if (WXConstant.MSG_TYPE_TEXT.equals(msgType)) {
            String content = messageMap.get("Content");
            messageInfo.setMsgType(WXConstant.MSG_TYPE_TEXT);
            if (!StringUtils.isBlank(content)) {
                if (content.contains("约课")) {
                    messageInfo.setContent("<a href='http://www.shazhibin.top/service/appointment.html?openId=" + messageInfo.getFromUserName() + "'>约课</a>");
                    return messageParseXml(messageInfo);
                }
            }
        }
        messageInfo.setMsgType(WXConstant.MSG_TYPE_TEXT);
        messageInfo.setContent("抱歉,还未设置此消息回复.");
        return messageParseXml(messageInfo);

    }

    /**
     * 构建消息回复xml包
     *
     * @param messageInfo 回复消息实体类信息
     * @return 回复消息xml包
     */
    private String messageParseXml(WXMessageInfo messageInfo) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("xml");
        root.addElement("ToUserName").add(DocumentHelper.createCDATA(messageInfo.getToUserName()));
        root.addElement("FromUserName").add(DocumentHelper.createCDATA(messageInfo.getFromUserName()));
        root.addElement("CreateTime").add(DocumentHelper.createText(messageInfo.getCreateTime()));
        root.addElement("MsgType").add(DocumentHelper.createCDATA(messageInfo.getMsgType()));
        switch (messageInfo.getMsgType()) {
            case WXConstant.MSG_TYPE_TEXT:
                root.addElement("Content").add(DocumentHelper.createCDATA(messageInfo.getContent()));
            case WXConstant.MSG_TYPE_IMAGE:
                setImageVoiceMessage(root, messageInfo, "Image");
            case WXConstant.MSG_TYPE_VOICE:
                setImageVoiceMessage(root, messageInfo, "Voice");
            default:
                root.addElement("Content").add(DocumentHelper.createCDATA("消息类型不支持"));
        }
        return document.asXML();
    }

    /**
     * 构建图片类型回复消息xml
     *
     * @param root        xml根节点
     * @param messageInfo 消息实体类信息
     * @param type        节点key
     */
    private void setImageVoiceMessage(Element root, WXMessageInfo messageInfo, String type) {
        Element image = root.addElement(type);
        image.addElement("MediaId").add(DocumentHelper.createCDATA(messageInfo.getMediaId()));
    }

}
