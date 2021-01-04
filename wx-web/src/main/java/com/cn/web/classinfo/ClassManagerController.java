package com.cn.web.classinfo;

import com.cn.beans.classinfo.ClassInfo;
import com.cn.beans.common.ResultBean;
import com.cn.service.classinfo.ClassInfoService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager/class")
public class ClassManagerController {

    final ClassInfoService classInfoService;

    public ClassManagerController(ClassInfoService classInfoService) {
        this.classInfoService = classInfoService;
    }

    /**
     * 新增课程信息
     *
     * @param classInfo 课程信息
     */
    @PostMapping("/insertClassInfo")
    public ResultBean insertClassInfo(@RequestBody ClassInfo classInfo) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isBlank(classInfo.getClassName())) {
            resultBean.setRtnMsg("课程名称为空");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        classInfoService.insertClassInfo(classInfo);
        return resultBean;
    }

    /**
     * 修改课程信息
     *
     * @param classInfo 课程信息
     */
    @PostMapping("/updateClassInfo")
    public ResultBean updateClassInfo(@RequestBody ClassInfo classInfo) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isBlank(classInfo.getClassId())) {
            resultBean.setRtnMsg("参数错误");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        int updateCount = classInfoService.updateClassInfo(classInfo);
        if (updateCount == 1) {
            return resultBean;
        }
        resultBean.setRtnMsg("更新失败");
        resultBean.setRtnCode(ResultBean.FAIL_CODE);
        return resultBean;
    }

    /**
     * 删除课程信息
     *
     * @param classId 课程编码
     */
    @GetMapping("/deleteClassInfo")
    public ResultBean deleteClassInfo(String classId) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isBlank(classId)) {
            resultBean.setRtnMsg("参数错误");
            resultBean.setRtnCode(ResultBean.FAIL_CODE);
            return resultBean;
        }
        return classInfoService.deleteClassInfo(classId);
    }

    @GetMapping("/getClassInfoById")
    public ResultBean getClassInfoById(@RequestParam(defaultValue = "1") int classId) {
        ResultBean resultBean = new ResultBean();
        ClassInfo classInfo = classInfoService.getClassInfoById(classId);
        resultBean.setResult(classInfo);
        return resultBean;
    }

    @GetMapping("/getClassInfoList")
    public ResultBean getClassInfoList(@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int limit, String className) {
        ResultBean resultBean = new ResultBean();
        PageInfo<ClassInfo> classPageInfo = classInfoService.getClassInfoList(start, limit, className);
        resultBean.setResult(classPageInfo);
        return resultBean;
    }
}
