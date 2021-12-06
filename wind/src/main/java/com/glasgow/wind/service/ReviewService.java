package com.glasgow.wind.service;

import com.glasgow.wind.dao.ReviewMapper;
import com.glasgow.wind.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/6 13:17
 * @Version 1.0
 */

@Service
public class ReviewService {
    @Autowired(required=false)
    ReviewMapper reviewMapper;

    public void add(Review review){
        review.setAddTime(new Date());
        review.setUpdateTime(new Date());
        review.setLikeCount(0);
        reviewMapper.insertSelective(review);
    }
}
