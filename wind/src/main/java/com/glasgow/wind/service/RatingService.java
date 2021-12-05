package com.glasgow.wind.service;

import com.glasgow.wind.dao.RatingMapper;
import com.glasgow.wind.domain.Album;
import com.glasgow.wind.domain.Rating;
import com.glasgow.wind.domain.RatingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

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

    public List<Integer> queryRecommendAlbumId(List<Integer> albumIds){
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < albumIds.size(); i++) {
            RatingExample example = new RatingExample();
            example.createCriteria().andAlbumIdEqualTo(albumIds.get(i));
            int count = (int)ratingMapper.countByExample(example);
            map.put(albumIds.get(i),count);
        }

        //这里将map.entrySet()转换成list
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            //降序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }

        });

        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
            res.add(mapping.getKey());
        }

        return res;
    }
}
