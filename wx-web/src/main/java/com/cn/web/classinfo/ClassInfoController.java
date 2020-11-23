package com.cn.web.classinfo;

import com.cn.beans.classinfo.ClassInfo;
import com.cn.beans.common.ResultBean;
import com.cn.service.classinfo.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassInfoController {

    @Autowired
    ClassInfoService classInfoService;

    /**
     * 根据课程id获取课程信息
     *
     * @param classId 课程id
     * @return 课程信息
     */
    @GetMapping("/getClassInfoById")
    public ResultBean getClassInfoById(@RequestParam(defaultValue = "1") int classId) {
        ResultBean resultBean = new ResultBean();
        ClassInfo classInfo = classInfoService.getClassInfoById(classId);
        resultBean.setResult(classInfo);
        return resultBean;
    }
}
