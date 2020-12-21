package com.cn.web.client;

import com.cn.beans.client.ClientInfo;
import com.cn.beans.common.ResultBean;
import com.cn.service.client.ClientInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/client")
public class ClientManagerController {

    @Autowired
    ClientInfoService clientInfoService;

    @GetMapping("/getClientInfoList")
    public ResultBean getClientInfoList(@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int limit, String clientName, String mobile) {
        ResultBean resultBean = new ResultBean();
        PageInfo<ClientInfo> clientPageInfo = clientInfoService.getClientInfoList(start, limit, clientName, mobile);
        resultBean.setResult(clientPageInfo);
        return resultBean;
    }
}
