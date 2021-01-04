package com.cn.dao.wx;

import com.cn.beans.wx.WXMsgInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface WXMsgDao {
    WXMsgInfo searchWXResponseMsg(WXMsgInfo requestMsgInfo);
}
