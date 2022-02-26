package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.Building;
import com.ffyc.myfirstboot.model.FeedBack;
import com.ffyc.myfirstboot.model.News;
import com.ffyc.myfirstboot.service.FeedBackService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("addFeedBack")
    public CommonResult addFeedBack(@RequestHeader("token") String token, FeedBack feedBack) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        feedBack.setOperator(manageId);
        feedBackService.addFeedBack(feedBack);
        try {
            commonResult = new CommonResult<>(200, "保存成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

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
}
