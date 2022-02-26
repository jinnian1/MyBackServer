package com.ffyc.myfirstboot.service;


import com.ffyc.myfirstboot.dao.NewsDao;
import com.ffyc.myfirstboot.model.News;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class NewsService{

    @Autowired
    NewsDao newsDao;

    public void addNews(News news) {
        newsDao.addNews(news);
    }

    public void deleteNews(Integer newsId) {
        newsDao.deleteNews(newsId);
    }

    public News updateGet(Integer newsId) {
        return newsDao.getNewsById(newsId);
    }

    public void updateNews(News news) {
        newsDao.updateNews(news);
    }

    public PageInfo<News> getNewsList(News news) throws ParseException {
        if (news.getOutputTime() != null && !Objects.equals(news.getOutputTime(), "")) {
            String outputTime = news.getOutputTime();
            //设定日期格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //转换为Date类型
            Date parse = simpleDateFormat.parse(outputTime);
            //加1天 (不需要,已删除)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            //calendar.add(Calendar.DAY_OF_MONTH, 1);
            //转换为需要格式
            String format = simpleDateFormat.format(calendar.getTime());
            news.setOutputTime(format);
        }

        PageHelper.startPage(news.getPageNum(), news.getPageSize());
        List<News> list = newsDao.getNewsList(news);
        return new PageInfo<>(list);
    }

    public List<News> getMainLeftNewsList() {
        return newsDao.getMainLeftNewsList();
    }

    public List<News> getMainRightNewsList() {
        return newsDao.getMainRightNewsList();
    }
}
