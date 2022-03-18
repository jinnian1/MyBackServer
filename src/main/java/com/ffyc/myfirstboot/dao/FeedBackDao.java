package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.FeedBack;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Deevan
 */
@Repository
public interface FeedBackDao {

    void addFeedBack(FeedBack feedBack);

    void deleteFeedBack(@Param("feedBackId") Integer feedBackId);

    List<FeedBack> getFeedBackList(FeedBack feedBack);

    FeedBack getFeedBackById(@Param("feedBackId")Integer feedBackId);

    void updateState(FeedBack feedBack);

    Integer getPercentOn();

    Integer getPercentDown();
}
