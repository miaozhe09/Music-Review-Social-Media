package com.glasgow.wind.service;

import com.glasgow.wind.dao.RatingMapper;
import com.glasgow.wind.domain.Rating;
import com.glasgow.wind.domain.RatingExample;
import com.glasgow.wind.domain.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
