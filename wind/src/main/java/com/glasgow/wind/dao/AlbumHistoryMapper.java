package com.glasgow.wind.dao;

import com.glasgow.wind.domain.AlbumHistory;
import com.glasgow.wind.domain.AlbumHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumHistoryMapper {
    long countByExample(AlbumHistoryExample example);

    int deleteByExample(AlbumHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AlbumHistory record);

    int insertSelective(AlbumHistory record);

    List<AlbumHistory> selectByExample(AlbumHistoryExample example);

    AlbumHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AlbumHistory record, @Param("example") AlbumHistoryExample example);

    int updateByExample(@Param("record") AlbumHistory record, @Param("example") AlbumHistoryExample example);

    int updateByPrimaryKeySelective(AlbumHistory record);

    int updateByPrimaryKey(AlbumHistory record);
}