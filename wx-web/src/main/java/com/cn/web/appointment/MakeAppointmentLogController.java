package com.cn.web.appointment;

import com.cn.beans.appointment.MakeAppointmentLog;
import com.cn.beans.common.ResultBean;
import com.cn.service.appointment.MakeAppointmentLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/appointment")
public class MakeAppointmentLogController {

    final MakeAppointmentLogService makeAppointmentLogService;

    public MakeAppointmentLogController(MakeAppointmentLogService makeAppointmentLogService) {
        this.makeAppointmentLogService = makeAppointmentLogService;
    }

    /**
     * 获取客户约课记录信息
     *
     * @param start     起始页
     * @param limit     展示数量
     * @param startDate 开始时间 yyyy-MM-dd
     * @param endDate   结束时间 yyyy-MM-dd
     * @param mobile    客户手机号
     * @return 记录列表
     */
    @GetMapping("/getMakeAppointmentLogList")
    public ResultBean getMakeAppointmentLogList(@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int limit, String startDate, String endDate, String mobile) {
        PageInfo<MakeAppointmentLog> logPageInfo = makeAppointmentLogService.getMakeAppointmentLogList(start, limit, startDate, endDate, mobile);
        ResultBean resultBean = new ResultBean();
        resultBean.setResult(logPageInfo);
        return resultBean;
    }
}
