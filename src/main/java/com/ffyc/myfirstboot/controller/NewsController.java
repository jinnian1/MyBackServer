package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.News;
import com.ffyc.myfirstboot.service.NewsService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.StringUtil;
import com.ffyc.myfirstboot.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 新闻controller层
 *
 * @author Deevan
 */
@RestController
@RequestMapping("api/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @RequestMapping("infoImg")
    public CommonResult<String> fileUpload(@RequestParam("fileName") CommonsMultipartFile infoImg, @RequestHeader("token") String token) {
        System.out.println("文章内上传图片");
        CommonResult<String> commonResult = null;
        //指定文件地址  localhost
        File folder = new File("/usr/local/apache-tomcat-9.0.37/webapps/ROOT/EPC/news");
        if (!folder.exists()) {
            folder.mkdir();
        }
        //生成新文件
        String fileName = StringUtil.getNewFileName(infoImg.getOriginalFilename());
        File file = new File(folder, fileName);
        try {
            //只上传问价,不存数据库
            infoImg.transferTo(file);
            //返回文件名
            System.out.println(fileName);
            System.out.println(file);
            commonResult = new CommonResult<>(200, "上传成功", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("addNews")
    public CommonResult addNews(@RequestHeader("token") String token, @RequestBody News news) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        news.setOperator(manageId);
        newsService.addNews(news);
        try {
            commonResult = new CommonResult<>(200, "保存成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("deleteNews/{newsId}")
    public CommonResult deleteNews(@PathVariable("newsId") Integer newsId) {
        CommonResult commonResult = null;
        newsService.deleteNews(newsId);
        try {
            commonResult = new CommonResult<>(200, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateGet/{newsId}")
    public CommonResult<News> updateGet(@PathVariable("newsId") Integer newsId) {
        CommonResult<News> commonResult = null;
        News news = newsService.updateGet(newsId);
        try {
            commonResult = new CommonResult<>(200, "查询成功", news);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateNews")
    public CommonResult<News> updateNews(@RequestHeader("token") String token,@RequestBody News news) {
        CommonResult<News> commonResult = null;
        //拿到管理员id
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        news.setOperator(manageId);
        newsService.updateNews(news);
        try {
            commonResult = new CommonResult<>(200, "修改成功", news);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getNewsList")
    public CommonResult<List<News>> getNewsList(@RequestBody News news){
        CommonResult commonResult = null;
        try {
            PageInfo<News> newsPageInfo = newsService.getNewsList(news);
            commonResult = new CommonResult<>(200, "查询成功", newsPageInfo.getList(), newsPageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }

    /**
     * 获取主界面左侧的新闻
     */
    @RequestMapping("getMainLeftNewsList")
    public CommonResult<List<News>> getMainLeftNewsList(){
        CommonResult commonResult = null;
        try {
            List<News> mainLeftNewsList = newsService.getMainLeftNewsList();
            commonResult = new CommonResult<>(200, "查询成功", mainLeftNewsList);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }

    @RequestMapping("getMainRightNewsList")
    public CommonResult<List<News>> getMainRightNewsList(){
        CommonResult commonResult = null;
        try {
            List<News> mainLeftNewsList = newsService.getMainRightNewsList();
            commonResult = new CommonResult<>(200, "查询成功", mainLeftNewsList);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }

    /**
     * 用户端打开新闻
     */
 @RequestMapping("getNewsShowById/{newsId}")
    public CommonResult<News> getNewsShowById(@PathVariable("newsId")Integer newsId){
        CommonResult commonResult = null;
        try {
            News news = newsService.getNewsShowById(newsId);
            commonResult = new CommonResult<>(200, "查询成功", news);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }
}
