package com.cn.service.impl.wx;

import com.cn.beans.wx.WXConstant;
import com.cn.service.wx.WXMessageService;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WXMessageServiceImpl implements WXMessageService {

    @Override
    public String handleMessage(Map<String, String> messageMap) {
        String msgType = messageMap.get("MsgType");
        Map<String, String> sendMessageMap = new HashMap<>();
        sendMessageMap.put("ToUserName", messageMap.get("FromUserName"));
        sendMessageMap.put("FromUserName", messageMap.get("ToUserName"));
        sendMessageMap.put("CreateTime", messageMap.get("CreateTime"));
        sendMessageMap.put("MsgType", WXConstant.MSG_TYPE_TEXT);
        if (WXConstant.MSG_TYPE_TEXT.equals(msgType)) {
            String content = messageMap.get("Content");
            if (!StringUtils.isBlank(content)) {
                if (content.contains("约课")) {
                    sendMessageMap.put("Content", "<a href='http://www.shazhibin.top/service/appointment.html'>约课</a>");
                    return messageParseXml(sendMessageMap);
                }
            }
        }
        sendMessageMap.put("Content", "消息错误");
        return messageParseXml(sendMessageMap);

    }

    private static String messageParseXml(Map<String, String> map) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("xml");
        Element element1 = root.addElement("ToUserName");
        element1.add(DocumentHelper.createCDATA(map.get("ToUserName")));
        Element element2 = root.addElement("FromUserName");
        element2.add(DocumentHelper.createCDATA(map.get("FromUserName")));
        Element element3 = root.addElement("CreateTime");
        element3.add(DocumentHelper.createText(map.get("CreateTime")));
        Element element4 = root.addElement("MsgType");
        element4.add(DocumentHelper.createCDATA(map.get("MsgType")));
        Element element5 = root.addElement("Content");
        element5.add(DocumentHelper.createCDATA(map.get("Content")));
        return document.asXML();
    }
}
