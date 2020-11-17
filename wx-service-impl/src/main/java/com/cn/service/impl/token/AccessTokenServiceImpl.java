package com.cn.service.impl.token;

import com.alibaba.fastjson.JSON;
import com.cn.beans.wx.Token;
import com.cn.service.token.AccessTokenService;
import com.cn.service.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {


    private static final String TOKEN_REDIS_KEY = "CACHE:TOKEN";

    private static final long TOKEN_REDIS_EXPIRE = 7200;

    private static final Logger LOGGER = Logger.getLogger(AccessTokenServiceImpl.class);

    @Value("${wx.token.url}")
    private String tokenUrl;
    @Value("${wx.app.id}")
    private String appId;
    @Value("${wx.token.secret}")
    private String secret;

    private static final String GRANT_TYPE = "client_credential";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public String getAccessToken() {
        Object tokenCache = redisTemplate.opsForValue().get(TOKEN_REDIS_KEY);
        if (tokenCache != null) {
            return (String) tokenCache;
        }
        return initAccessToken();
    }

    /**
     * 初始化公众号access_token的值
     *
     * @return access_token值
     */
    public String initAccessToken() {
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("grant_type", GRANT_TYPE));
        list.add(new BasicNameValuePair("appid", appId));
        list.add(new BasicNameValuePair("secret", secret));
        String tokenStr = HttpUtils.httpGet(tokenUrl, list);
        if (StringUtils.isBlank(tokenStr)) {
            LOGGER.error("initAccessToken=>获取AccessToken失败:" + tokenStr);
            return "";
        }
        Token token = JSON.parseObject(tokenStr, Token.class);
        String accessToken = token.getAccess_token();
        if (StringUtils.isEmpty(accessToken)) {
            LOGGER.error("initAccessToken=>获取AccessToken失败:" + tokenStr);
            return "";
        }
        redisTemplate.opsForValue().set(TOKEN_REDIS_KEY, accessToken, TOKEN_REDIS_EXPIRE);
        return accessToken;
    }
}
