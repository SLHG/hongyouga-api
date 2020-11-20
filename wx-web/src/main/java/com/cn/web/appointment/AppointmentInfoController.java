package com.cn.web.appointment;

import com.cn.beans.appointment.AppointmentInfo;
import com.cn.beans.common.ResultBean;
import com.cn.service.appointment.AppointmentInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointment")
public class AppointmentInfoController {

    @Autowired
    AppointmentInfoService appointmentInfoService;

    /**
     * 获取课程信息列表
     *
     * @param startDate 开始时间
     * @param dayNum    获取天数
     * @return 课程列表
     */
    @RequestMapping("/getAppointmentList")
    public ResultBean getAppointmentList(@RequestParam String startDate, @RequestParam(defaultValue = "5") int dayNum) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isBlank(startDate)) {
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            resultBean.setRtnMsg("时间参数为空");
            return resultBean;
        }
        Map<Integer, List<AppointmentInfo>> appointmentInfoMap = appointmentInfoService.getAppointmentList(startDate, dayNum);
        resultBean.setResult(appointmentInfoMap);
        return resultBean;
    }
}
