package com.glasgow.wind.dao;

import com.glasgow.wind.domain.Rating;
import com.glasgow.wind.domain.RatingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RatingMapper {
    long countByExample(RatingExample example);

    int deleteByExample(RatingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rating record);

    int insertSelective(Rating record);

    List<Rating> selectByExample(RatingExample example);

    Rating selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rating record, @Param("example") RatingExample example);

    int updateByExample(@Param("record") Rating record, @Param("example") RatingExample example);

    int updateByPrimaryKeySelective(Rating record);

    int updateByPrimaryKey(Rating record);
}