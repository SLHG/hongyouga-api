package com.cn.service.wx;

import java.util.Map;

public interface WXMsgService {
    String handleMessage(Map<String, String> messageMap);
}
