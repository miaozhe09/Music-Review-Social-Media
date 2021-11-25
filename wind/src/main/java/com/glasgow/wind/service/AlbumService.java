package com.glasgow.wind.service;

import com.glasgow.wind.dao.AlbumMapper;
import com.glasgow.wind.dao.UserMapper;
import com.glasgow.wind.domain.Album;
import com.glasgow.wind.domain.AlbumExample;
import com.glasgow.wind.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/22 15:52
 * @Version 1.0
 */

@Service
public class AlbumService {
    @Autowired(required=false)
    AlbumMapper albumMapper;

    public void add(Album album) {
        albumMapper.insertSelective(album);
    }

    public List<Album> queryByKeyword(String name){
        AlbumExample example = new AlbumExample();
        AlbumExample.Criteria criteria = example.createCriteria();

        criteria.andNameLike("%" + name + "%");

        // sort TODO

        // page TODO

        return albumMapper.selectByExample(example);
    }

}