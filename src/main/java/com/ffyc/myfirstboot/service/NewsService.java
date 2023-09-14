package com.ffyc.myfirstboot.service;


import com.ffyc.myfirstboot.dao.NewsDao;
import com.ffyc.myfirstboot.model.HorseLamp;
import com.ffyc.myfirstboot.model.News;
import com.ffyc.myfirstboot.util.MarkdownUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class NewsService {

    @Autowired
    NewsDao newsDao;
    @Autowired
    RedisTemplate redisTemplate;

    public void addNews(News news) {
        newsDao.addNews(news);
        //缓存失效,再存一次缓存
        redisTemplate.opsForValue().set("leftNewsList", newsDao.getMainLeftNewsList());
        redisTemplate.opsForValue().set("rightNewsList", newsDao.getMainRightNewsList());
        redisTemplate.opsForValue().set("news" + news.getId(), news);
    }

    public void deleteNews(Integer newsId) {
        newsDao.deleteNews(newsId);
        redisTemplate.opsForValue().set("leftNewsList", newsDao.getMainLeftNewsList());
        redisTemplate.opsForValue().set("rightNewsList", newsDao.getMainRightNewsList());
        //删除key
        redisTemplate.delete("news" + newsId);
    }

    public News updateGet(Integer newsId) {
        return newsDao.getNewsById(newsId);
    }

    public void updateNews(News news) {
        newsDao.updateNews(news);
        redisTemplate.opsForValue().set("leftNewsList", newsDao.getMainLeftNewsList());
        redisTemplate.opsForValue().set("rightNewsList", newsDao.getMainRightNewsList());
        redisTemplate.opsForValue().set("news" + news.getId(), news);
    }

    public List<HorseLamp> getHorseLamp(){
           List<HorseLamp> list = newsDao.getHorseLamp();
        return list;
    }

    public List<News> getMainLeftNewsList() {
        //先从Redis中取
     //   List<News> list = (List<News>) redisTemplate.opsForValue().get("leftNewsList");
        List<News> list=new ArrayList<>();
        if (list == null) {
            //从mysql中拿
            list = newsDao.getMainLeftNewsList();
            redisTemplate.opsForValue().set("leftNewsList", list);
        }
        return list;
    }

    public List<News> getMainRightNewsList() {
        //先从Redis中取
        List<News> list = (List<News>) redisTemplate.opsForValue().get("rightNewsList");
        if (list == null) {
            //从mysql中拿
            list = newsDao.getMainRightNewsList();
            redisTemplate.opsForValue().set("rightNewsList", list);
        }
        return list;
    }

    public News getNewsShowById(Integer newsId) {
        //先从Redis中取
        Map<String, String> map = (Map<String, String>) redisTemplate.opsForValue().get("news" + newsId);
        News news;
        //缓存没
        if (map == null) {
            news = newsDao.getNewsShowById(newsId);
            if (news == null) {
                News ns = new News();
                ns.setInfo("Encountered a cache attack, your attack is invalid !!!");
                redisTemplate.opsForValue().set("news" + newsId, ns, 20, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set("news" + newsId, news);
                news.setInfo(MarkdownUtil.markdownToHtml(news.getInfo()));
            }
        } else {
            news = new News();
            //news.setId(Integer.valueOf(map.get("id")));
            news.setTitle(map.get("title"));
            news.setInfo((map.get("info")));
            news.setSummary(map.get("summary"));
            news.setInfo(MarkdownUtil.markdownToHtml(news.getInfo()));
        }
        return news;
    }

    public List<News> getNotice() {
        List<News> list = newsDao.getNotice();
        return list;
    }

    public List<HorseLamp> getFeedBackList() {
        List<HorseLamp> list = newsDao.getFeedBackList();
        return list;
    }

    public void saveNotice(HorseLamp horseLamp) {
        newsDao.saveNotice(horseLamp);
    }


    public HorseLamp updateNotice(Integer id) {
       return newsDao.updateNotice(id);
    }

    public void updateNoticeSave(HorseLamp horseLamp) {
        newsDao.updateNoticeSave(horseLamp);
    }

    public void deleteNotice(Integer id) {
        newsDao.deleteNotice(id);
    }

    public void deleteFeedBack(Integer id) {
        newsDao.deleteFeedBack(id);
    }

    public void addHorseLamp(HorseLamp horseLamp) {
        newsDao.addHorseLamp(horseLamp);
    }

    public HorseLamp updateHorseLampBy(Integer id) {
       return newsDao.updateHorseLampBy(id);
    }

    public void saveUpdateHorseLamp(HorseLamp horseLamp) {
        newsDao.saveUpdateHorseLamp(horseLamp);
    }

    public void deleteHorseLamp(Integer id) {
        newsDao.deleteHorseLamp(id);
    }
}
