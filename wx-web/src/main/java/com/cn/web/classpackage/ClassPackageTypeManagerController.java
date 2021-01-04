package com.cn.web.classpackage;

import com.cn.beans.classpackage.ClassPackageType;
import com.cn.beans.common.ResultBean;
import com.cn.service.classpackage.ClassPackageTypeService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager/package")
public class ClassPackageTypeManagerController {

    final ClassPackageTypeService classPackageTypeService;

    public ClassPackageTypeManagerController(ClassPackageTypeService classPackageTypeService) {
        this.classPackageTypeService = classPackageTypeService;
    }

    /**
     * 新增套餐信息
     *
     * @param classPackageType 套餐信息
     */
    @PostMapping("/insertClassPackageType")
    public ResultBean insertClassPackageType(@RequestBody ClassPackageType classPackageType) {
        if (StringUtils.isBlank(classPackageType.getPackageName())) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程名称为空");
        }
        if (StringUtils.isBlank(classPackageType.getClassType())) {
            return new ResultBean(ResultBean.FAIL_CODE, "课程类型为空");
        }
        if (classPackageType.getEnableTime() <= 0) {
            return new ResultBean(ResultBean.FAIL_CODE, "可用时间错误");
        }
        if (classPackageType.getEnableNum() <= 0) {
            return new ResultBean(ResultBean.FAIL_CODE, "可用次数错误");
        }
        classPackageTypeService.insertClassPackageType(classPackageType);
        return new ResultBean();
    }

    /**
     * 修改套餐信息
     *
     * @param classPackageType 套餐信息
     */
    @PostMapping("/updateClassPackageType")
    public ResultBean updateClassPackageType(@RequestBody ClassPackageType classPackageType) {
        return classPackageTypeService.updateClassPackageType(classPackageType);
    }

    /**
     * 删除套餐信息
     *
     * @param id 套餐编码
     */
    @GetMapping("/deleteClassPackageType")
    public ResultBean deleteClassPackageType(@RequestParam(defaultValue = "1") int id) {
        return classPackageTypeService.deleteClassPackageType(id);
    }

    /**
     * 查询套餐信息列表
     *
     * @param start       开始页
     * @param limit       限制数量
     * @param packageName 套餐名称
     * @return 套餐信息
     */
    @GetMapping("/getClassPackageTypeList")
    public ResultBean getClassPackageTypeList(@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int limit, String packageName) {
        PageInfo<ClassPackageType> classPackageTypeList = classPackageTypeService.getClassPackageTypeList(start, limit, packageName);
        ResultBean resultBean = new ResultBean();
        resultBean.setResult(classPackageTypeList);
        return resultBean;
    }
}
