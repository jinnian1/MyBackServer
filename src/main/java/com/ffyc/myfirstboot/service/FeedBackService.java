package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.FeedBackDao;
import com.ffyc.myfirstboot.model.FeedBack;
import com.ffyc.myfirstboot.util.MarkdownUtil;
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

/**
 * @author Deevan
 */
@Service
public class FeedBackService {

    @Autowired
    FeedBackDao feedBackDao;

    public void addFeedBack(FeedBack feedBack) {
        feedBackDao.addFeedBack(feedBack);
    }

    public void deleteFeedBack(Integer feedBackId) {
        feedBackDao.deleteFeedBack(feedBackId);
    }

    public PageInfo<FeedBack> getFeedBackList(FeedBack feedBack) throws ParseException {
        if (feedBack.getTime() != null && !Objects.equals(feedBack.getTime(), "")) {
            String outputTime = feedBack.getTime();
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
            feedBack.setTime(format);
        }
        PageHelper.startPage(feedBack.getPageNum(), feedBack.getPageSize());
        List<FeedBack> list = feedBackDao.getFeedBackList(feedBack);
        return new PageInfo<>(list);
    }

    public FeedBack getFeedBackById(Integer feedBackId) {
        FeedBack feedBackById = feedBackDao.getFeedBackById(feedBackId);
        feedBackById.setInfo((MarkdownUtil.markdownToHtml(feedBackById.getInfo())));
        return feedBackById;
    }

    public void updateState(FeedBack feedBack) {
        feedBackDao.updateState(feedBack);
    }

    public Integer getPercent() {
        Integer percentOn = feedBackDao.getPercentOn();
        Integer percentDown = feedBackDao.getPercentDown();
        return percentOn * 100 / percentDown;
    }
}
