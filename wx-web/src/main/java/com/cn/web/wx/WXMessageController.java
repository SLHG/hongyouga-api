package com.cn.web.wx;

import com.alibaba.fastjson.JSON;
import com.cn.service.wx.WXMsgService;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信消息处理
 */
@RestController
@RequestMapping("/message")
public class WXMessageController {

    private static final Logger LOGGER = Logger.getLogger(WXConfigController.class);

    final WXMsgService wxMessageService;

    public WXMessageController(WXMsgService wxMessageService) {
        this.wxMessageService = wxMessageService;
    }


    @GetMapping("/acceptWXMessage")
    public String checkWXMessage(String echostr) {
        LOGGER.info("checkWXMessage=>get接收消息" + echostr);
        return echostr;
    }

    @PostMapping("/acceptWXMessage")
    public String acceptWXMessage(HttpServletRequest request) {
        Map<String, String> messageMap = requestParseXml(request);
        LOGGER.info("acceptWXMessage=>" + JSON.toJSONString(messageMap));
        return wxMessageService.handleMessage(messageMap);
    }

    /**
     * 将微信消息请求xml包转换为map消息
     *
     * @param request 微信消息请求
     * @return 转换后的消息map
     */
    private Map<String, String> requestParseXml(HttpServletRequest request) {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<>();
        Element root;
        try {
            //获取根元素
            root = getRootElement(request);
        } catch (IOException e) {
            LOGGER.error("requestParseXml=>读取微信消息异常", e);
            return map;
        }
        if (root == null) {
            return map;
        }
        // 得到根元素的所有子节点
        List<?> elements = root.elements();
        for (Object element : elements) {
            if (element instanceof Element) {
                Element e = (Element) element;
                map.put(e.getName(), e.getText());
            }
        }
        return map;
    }

    /**
     * 获取请求的根元素
     *
     * @param request 请求
     * @return 根元素
     * @throws IOException 读写异常
     */
    private Element getRootElement(HttpServletRequest request) throws IOException {
        // 读取输入流
        SAXReader reader = new SAXReader();
        try (InputStream inputStream = request.getInputStream()) {
            Document document = reader.read(inputStream);
            // 得到xml根元素
            return document.getRootElement();
        } catch (DocumentException e) {
            LOGGER.error("getRootElement=>", e);
        }
        return null;
    }
}
