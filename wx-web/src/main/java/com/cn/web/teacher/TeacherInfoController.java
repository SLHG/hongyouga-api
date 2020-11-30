package com.cn.web.teacher;

import com.cn.beans.common.ResultBean;
import com.cn.beans.teacher.TeacherInfo;
import com.cn.service.teacher.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/view/teacher")
public class TeacherInfoController {

    @Autowired
    TeacherInfoService teacherInfoService;

    /**
     * 根据id获取老师信息
     *
     * @param teacherId 老师id
     * @return 老师信息
     */
    @GetMapping("/getTeacherInfoById")
    public ResultBean getTeacherInfoById(@RequestParam(defaultValue = "1") int teacherId) {
        ResultBean resultBean = new ResultBean();
        TeacherInfo teacherInfo = teacherInfoService.getTeacherInfoById(teacherId);
        if (teacherInfo == null) {
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            resultBean.setRtnMsg("无数据");
            return resultBean;
        }
        resultBean.setResult(teacherInfo);
        return resultBean;
    }
}
