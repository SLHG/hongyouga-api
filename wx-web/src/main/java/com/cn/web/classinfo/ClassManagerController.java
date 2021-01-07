package com.cn.web.classinfo;

import com.cn.beans.classinfo.ClassInfo;
import com.cn.beans.common.ResultBean;
import com.cn.beans.common.Status;
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
        if (StringUtils.isBlank(classInfo.getClassName())) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程名称为空.");
        }
        int count = classInfoService.getClassInfoCountByName(classInfo.getClassName());
        if (count == 1) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程名称重复,新增失败");
        }
        classInfoService.insertClassInfo(classInfo);
        return new ResultBean();
    }

    /**
     * 修改课程信息
     *
     * @param classInfo 课程信息
     */
    @PostMapping("/updateClassInfo")
    public ResultBean updateClassInfo(@RequestBody ClassInfo classInfo) {
        return classInfoService.updateClassInfo(classInfo);
    }

    /**
     * 删除课程信息
     *
     * @param classId 课程编码
     */
    @GetMapping("/deleteClassInfo")
    public ResultBean deleteClassInfo(@RequestParam(defaultValue = "1") int classId) {
        return classInfoService.deleteClassInfo(classId);
    }

    @GetMapping("/getClassInfoById")
    public ResultBean getClassInfoById(@RequestParam(defaultValue = "1") int classId) {
        ResultBean resultBean = new ResultBean();
        ClassInfo classInfo = classInfoService.getClassInfoById(classId, Status.IS_ENABLE.getStatus());
        resultBean.setResult(classInfo);
        return resultBean;
    }

    @GetMapping("/getClassInfoList")
    public ResultBean getClassInfoList(@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int limit, String className) {
        PageInfo<ClassInfo> classPageInfo = classInfoService.getClassInfoList(start, limit, className);
        return new ResultBean(classPageInfo);
    }
}
