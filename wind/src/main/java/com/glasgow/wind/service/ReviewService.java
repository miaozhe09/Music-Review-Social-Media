package com.glasgow.wind.service;

import com.glasgow.wind.dao.ReviewMapper;
import com.glasgow.wind.domain.Review;
import com.glasgow.wind.domain.ReviewExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/6 13:17
 * @Version 1.0
 */

@Service
public class ReviewService {
    @Autowired(required=false)
    ReviewMapper reviewMapper;

    public int add(Review review){
        review.setAddTime(new Date());
        review.setUpdateTime(new Date());
        review.setLikeCount(0);

        return reviewMapper.insertSelective(review);
    }

    public List<Review> getAllByAlbumId(int albumId){
        ReviewExample example = new ReviewExample();
        example.createCriteria().andAlbumIdEqualTo(albumId);
        example.setOrderByClause("update_time desc");

        return reviewMapper.selectByExample(example);
    }

    public int deleteById(int id){
        return reviewMapper.deleteByPrimaryKey(id);
    }

    public List<Integer> getAlbumIdListByUserId(int userId){
        ReviewExample example = new ReviewExample();
        example.createCriteria().andUserIdEqualTo(userId);
        example.setOrderByClause("update_time desc");
        List<Review> reviewList = reviewMapper.selectByExample(example);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            res.add(reviewList.get(i).getAlbumId());
        }

        return res;
    }
}
