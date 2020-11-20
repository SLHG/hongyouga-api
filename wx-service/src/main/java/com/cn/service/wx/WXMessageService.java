package com.cn.service.wx;

import java.util.Map;

public interface WXMessageService {
    String handleMessage(Map<String, String> messageMap);
}
