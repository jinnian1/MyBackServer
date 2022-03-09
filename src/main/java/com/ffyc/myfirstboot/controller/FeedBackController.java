package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.FeedBack;
import com.ffyc.myfirstboot.service.FeedBackService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.StringUtil;
import com.ffyc.myfirstboot.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @author Deevan
 */
@RestController
@RequestMapping("api/feedBack")
public class FeedBackController {
    @Autowired
    FeedBackService feedBackService;

    @RequestMapping("deleteFeedBack")
    public CommonResult deleteFeedBack(Integer feedBackId) {
        CommonResult commonResult = null;

        feedBackService.deleteFeedBack(feedBackId);
        try {
            commonResult = new CommonResult<>(200, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getFeedBackById/{feedBackId}")
    public CommonResult<FeedBack> getFeedBackById(@PathVariable("feedBackId")Integer feedBackId){
        CommonResult<FeedBack> commonResult = null;
        FeedBack feedBack = feedBackService.getFeedBackById(feedBackId);
        System.out.println(feedBack.getInfo());
        try {
            commonResult = new CommonResult<>(200, "查询成功",feedBack);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getFeedBackList")
    public CommonResult<List<FeedBack>> getFeedBackList(@RequestBody FeedBack feedBack) throws ParseException {
        CommonResult<List<FeedBack>> commonResult = null;
        PageInfo<FeedBack> feedBackPageInfo = feedBackService.getFeedBackList(feedBack);
        try {
            commonResult = new CommonResult<>(200, "查询成功", feedBackPageInfo.getList(), feedBackPageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateState/{state}/{id}")
    public CommonResult updateState(@RequestHeader("token")String token,@PathVariable("state")Integer state,@PathVariable("id")Integer id){
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        FeedBack feedBack = new FeedBack();
        feedBack.setOperator(manageId);
        feedBack.setState(state);
        feedBack.setId(id);
        feedBackService.updateState(feedBack);
        try {
            commonResult = new CommonResult<>(200, "操作成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("infoImg")
    public CommonResult<String> fileUpload(@RequestParam("fileName") CommonsMultipartFile infoImg) {
        CommonResult<String> commonResult = null;
        //指定文件地址  localhost
        File folder = new File("D:\\Program Files\\apache-tomcat-9.0.43(img)\\webapps\\ROOT\\EPC\\feedBack");
        if (!folder.exists()) {
            folder.mkdir();
        }
        //生成新文件
        String fileName = StringUtil.getNewFileName(infoImg.getOriginalFilename());
        File file = new File(folder, fileName);
        try {
            //只上传问价,不存数据库
            infoImg.transferTo(file);
            commonResult = new CommonResult<>(200, "上传成功", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("addFeedBack")
    public CommonResult addNews( @RequestBody FeedBack feedBack) {
        CommonResult commonResult = null;
        System.out.println("getStudentID"+feedBack.getStudentID());
        feedBackService.addFeedBack(feedBack);
        try {
            commonResult = new CommonResult<>(200, "保存成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }
}
