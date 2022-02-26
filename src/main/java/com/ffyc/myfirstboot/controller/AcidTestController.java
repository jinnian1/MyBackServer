package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.AcidTest;
import com.ffyc.myfirstboot.service.AcidTestService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Deevan
 */
@RestController
@RequestMapping("api/acidTest")
public class AcidTestController {

    @Autowired
    AcidTestService acidTestService;

    @RequestMapping("addAcidTest")
    public CommonResult addAcidTest(@RequestHeader("token") String token, @RequestBody AcidTest acidTest) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        acidTest.setOperator(manageId);
        acidTestService.addAcidTest(acidTest);
        try {
            commonResult = new CommonResult<>(200, "保存成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("deleteAcidTest/{acidTestId}")
    public CommonResult deleteAcidTest(@PathVariable("acidTestId") Integer acidTestId) {
        CommonResult commonResult = null;
        acidTestService.deleteAcidTest(acidTestId);
        try {
            commonResult = new CommonResult<>(200, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateGet/{acidTestId}")
    public CommonResult<AcidTest> updateGet(@PathVariable("acidTestId") Integer acidTestId) {
        CommonResult<AcidTest> commonResult = null;
        AcidTest acidTest = acidTestService.updateGet(acidTestId);
        try {
            commonResult = new CommonResult<>(200, "查找成功", acidTest);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateAcidTest")
    public CommonResult  updateAcidTest(@RequestHeader("token") String token,@RequestBody AcidTest acidTest) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        acidTest.setOperator(manageId);
        acidTestService.updateAcidTest(acidTest);
        try {
            commonResult = new CommonResult<>(200, "修改成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    /**
     * 传入参数类型错误   ***********************
     */
    @RequestMapping("getAcidTestList")
    public CommonResult<List<AcidTest>>  getAcidTestList(@RequestBody AcidTest acidTest) {
        CommonResult<List<AcidTest>> commonResult = null;

        System.out.println(acidTest.getStarttime());


        System.out.println(acidTest.getCollege());


        List<AcidTest> acidTestList = acidTestService.getAcidTestList(acidTest);
        try {
            commonResult = new CommonResult<>(200, "查询成功", acidTestList);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }
}
