package com.glasgow.wind.service;

import com.glasgow.wind.dao.AlbumHistoryMapper;
import com.glasgow.wind.domain.AlbumHistory;
import com.glasgow.wind.domain.AlbumHistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/12 10:39
 * @Version 1.0
 */

@Service
public class AlbumHistoryService {
    @Autowired(required = false)
    AlbumHistoryMapper albumHistoryMapper;

    public void add(AlbumHistory albumHistory){
        albumHistory.setAddDate(new Date());
        albumHistory.setStatus(0); // 0 to be reviewd; 1 approved; 2 not approved
        albumHistoryMapper.insertSelective(albumHistory);
    }

    public List<AlbumHistory> getUnaudited(){
        AlbumHistoryExample example = new AlbumHistoryExample();
        example.createCriteria().andStatusEqualTo(0);

        return albumHistoryMapper.selectByExample(example);
    }

    public AlbumHistory queryById(Integer id){
        return albumHistoryMapper.selectByPrimaryKey(id);
    }

    public int update(AlbumHistory albumHistory){
        return albumHistoryMapper.updateByPrimaryKeySelective(albumHistory);
    }
}
