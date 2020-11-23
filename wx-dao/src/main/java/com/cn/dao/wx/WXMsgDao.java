package com.cn.dao.wx;

import com.cn.beans.wx.WXMsgInfo;

public interface WXMsgDao {
    WXMsgInfo searchWXResponseMsg(WXMsgInfo requestMsgInfo);
}
