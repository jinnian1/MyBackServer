package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.HorseLamp;
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

    News getNewsShowById(@Param("newsId")Integer newsId);

    List<HorseLamp> getHorseLamp();

    List<News> getNotice();

    List<HorseLamp> getFeedBackList();

    void saveNotice(HorseLamp horseLamp);

    HorseLamp updateNotice(Integer id);

    void updateNoticeSave(HorseLamp horseLamp);

    void deleteNotice(Integer id);

    void deleteFeedBack(Integer id);

    void addHorseLamp(HorseLamp horseLamp);

    HorseLamp updateHorseLampBy(Integer id);

    void saveUpdateHorseLamp(HorseLamp horseLamp);

    void deleteHorseLamp(Integer id);
}
