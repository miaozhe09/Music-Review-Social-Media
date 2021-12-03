package com.glasgow.wind.service;

import com.glasgow.wind.dao.RatingMapper;
import com.glasgow.wind.domain.Rating;
import com.glasgow.wind.domain.RatingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/2 20:01
 * @Version 1.0
 */

@Service
public class RatingService {
    @Autowired(required=false)
    RatingMapper ratingMapper;

    public List<Rating> queryByAlbumIdAndUserId(int albumId, int userId){
        RatingExample example = new RatingExample();
        example.createCriteria().andAlbumIdEqualTo(albumId).andUserIdEqualTo(userId);

        return ratingMapper.selectByExample(example);
    }

    public void add(Rating rating){
        ratingMapper.insertSelective(rating);
    }

    public Object getAlbumRatingCount(int albumId){
        RatingExample example = new RatingExample();
        example.createCriteria().andAlbumIdEqualTo(albumId);

        return ratingMapper.countByExample(example);
    }

    public double getAlbumAverageRating(int albumId){
        RatingExample example = new RatingExample();
        example.createCriteria().andAlbumIdEqualTo(albumId);
        List<Rating> ratings = ratingMapper.selectByExample(example);

        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < ratings.size(); i++) {
            sum = sum.add(ratings.get(i).getScore());
        }

        return sum.divide(new BigDecimal(ratings.size()), 2, RoundingMode.HALF_UP).doubleValue();
    }
}