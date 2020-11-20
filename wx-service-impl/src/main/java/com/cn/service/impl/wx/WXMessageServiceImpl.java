package com.cn.service.impl.wx;

import com.cn.beans.wx.WXConstant;
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
        if (WXConstant.MSG_TYPE_TEXT.equals(msgType)) {
            String content = messageMap.get("Content");
            if (!StringUtils.isBlank(content)) {
                if (content.contains("约课")) {
                    messageMap.put("Content", "<a href='http://www.shazhibin.top/service/appointment.html'>约课</a>");
                    return messageParseXml(messageMap);
                }
            }
        }
        messageMap.put("Content", "消息错误");
        return messageParseXml(messageMap);

    }

    private static String messageParseXml(Map<String, String> map) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("xml");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Element element = root.addElement(entry.getKey());
            element.add(DocumentHelper.createCDATA(entry.getValue()));
        }
        return document.toString();

    }
}
