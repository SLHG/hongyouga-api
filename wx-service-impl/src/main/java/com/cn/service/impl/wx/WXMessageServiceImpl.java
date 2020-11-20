package com.cn.service.impl.wx;

import com.cn.beans.wx.WXConstant;
import com.cn.service.wx.WXMessageService;
import org.apache.commons.lang3.StringUtils;
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
                    return "<a src='http://www.shazhibin.top/service/appointment.html'>约课</a>";
                }
            }
        }
        return "消息错误";

    }
}
