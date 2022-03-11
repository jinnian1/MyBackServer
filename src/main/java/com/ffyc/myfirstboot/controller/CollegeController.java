package com.ffyc.myfirstboot.controller;

import com.ffyc.myfirstboot.model.College;
import com.ffyc.myfirstboot.service.CollegeService;
import com.ffyc.myfirstboot.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Deevan
 */
@RestController
@RequestMapping("api/college")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @RequestMapping("getColleges")
    public CommonResult<List<College>> getColleges() {
        CommonResult<List<College>> commonResult = null;
        List<College> colleges = collegeService.getColleges();
        try {
            commonResult = new CommonResult<>(200, "查询成功", colleges);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }
}
