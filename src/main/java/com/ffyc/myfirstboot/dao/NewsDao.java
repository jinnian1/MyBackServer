package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Deevan
 */
@Repository
public interface NewsDao {

    void addNews(News news);

    void deleteNews(@Param("newsId") Integer newsId);

    News getNewsById(@Param("newsId") Integer newsId);

    void updateNews(News news);

    List<News> getNewsList(News news);

    List<News> getMainLeftNewsList();

    List<News> getMainRightNewsList();
}
