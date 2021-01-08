package com.cn.web.classinfo;

import com.cn.beans.classinfo.ClassType;
import com.cn.beans.common.ResultBean;
import com.cn.service.classinfo.ClassTypeService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/class")
public class ClassTypeManagerController {

    final ClassTypeService classTypeService;

    public ClassTypeManagerController(ClassTypeService classTypeService) {
        this.classTypeService = classTypeService;
    }

    @PostMapping("/insertClassType")
    public ResultBean insertClassType(@RequestBody ClassType classType) {
        if (StringUtils.isBlank(classType.getClassTypeName())) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程类型名称为空.");
        }
        return classTypeService.insertClassType(classType);
    }

    @PostMapping("/updateClassType")
    public ResultBean updateClassType(@RequestBody ClassType classType) {
        return classTypeService.updateClassType(classType);
    }

    @GetMapping("/deleteClassType")
    public ResultBean deleteClassType(@RequestParam(defaultValue = "1") int classTypeId) {
        return classTypeService.deleteClassType(classTypeId);
    }

    @GetMapping("/getClassTypeList")
    public ResultBean getClassTypeList(@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int limit, String classTypeName) {
        PageInfo<ClassType> classPageInfo = classTypeService.getClassTypeList(start, limit, classTypeName);
        return new ResultBean(classPageInfo);
    }

    @GetMapping("/getAllClassTypeList")
    public ResultBean getAllClassTypeList() {
        List<ClassType> list = classTypeService.getAllClassTypeList();
        return new ResultBean(list);
    }
}
