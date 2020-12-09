package com.cn.web.teacher;

import com.cn.beans.common.ResultBean;
import com.cn.beans.teacher.TeacherInfo;
import com.cn.service.teacher.TeacherInfoService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager/teacher")
public class TeacherManagerController {

    @Autowired
    TeacherInfoService teacherInfoService;

    /**
     * 新增老师信息
     *
     * @param teacherInfo 老师信息
     */
    @PostMapping("/insertTeacherInfo")
    public ResultBean insertTeacherInfo(@RequestBody TeacherInfo teacherInfo) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isBlank(teacherInfo.getTeacherName())) {
            resultBean.setRtnMsg("老师姓名为空");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        teacherInfoService.insertTeacherInfo(teacherInfo);
        return resultBean;
    }

    /**
     * 修改老师信息
     *
     * @param teacherInfo 老师信息
     */
    @PostMapping("/updateTeacherInfo")
    public ResultBean updateTeacherInfo(@RequestBody TeacherInfo teacherInfo) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isBlank(teacherInfo.getTeacherId())) {
            resultBean.setRtnMsg("参数错误");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        int updateCount = teacherInfoService.updateTeacherInfo(teacherInfo);
        if (updateCount == 1) {
            return resultBean;
        }
        resultBean.setRtnMsg("更新失败");
        resultBean.setRtnCode(ResultBean.FAIL_CODE);
        return resultBean;
    }

    /**
     * 删除老师信息
     *
     * @param teacherId 信息编码
     */
    @GetMapping("/deleteTeacherInfo")
    public ResultBean deleteTeacherInfo(@RequestParam(defaultValue = "1") int teacherId) {
        return teacherInfoService.deleteTeacherInfo(teacherId);
    }

    @GetMapping("/getTeacherInfoById")
    public ResultBean getTeacherInfoById(@RequestParam(defaultValue = "1") int teacherId) {
        ResultBean resultBean = new ResultBean();
        TeacherInfo teacherInfo = teacherInfoService.getTeacherInfoById(teacherId);
        resultBean.setResult(teacherInfo);
        return resultBean;
    }

    @GetMapping("/getTeacherInfoList")
    public ResultBean getTeacherInfoList(@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int limit, String teacherName) {
        ResultBean resultBean = new ResultBean();
        PageInfo<TeacherInfo> teacherInfoPageInfo = teacherInfoService.getTeacherInfoList(start, limit, teacherName);
        resultBean.setResult(teacherInfoPageInfo);
        return resultBean;
    }

}
