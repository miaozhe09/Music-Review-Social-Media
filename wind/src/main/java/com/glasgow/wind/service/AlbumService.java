package com.glasgow.wind.service;

import com.glasgow.wind.dao.AlbumMapper;
import com.glasgow.wind.domain.Album;
import com.glasgow.wind.domain.AlbumExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        album.setAlbumStatus(0); // 0 to be reviewd; 1 approved; 2 not approved
        albumMapper.insertSelective(album);
    }

    public List<Album> queryApprovedByKeyword(String name){
        AlbumExample example = new AlbumExample();
        AlbumExample.Criteria criteria = example.createCriteria();

        criteria.andNameLike("%" + name + "%").andAlbumStatusEqualTo(1);

        AlbumExample.Criteria criteria1 = example.createCriteria();
        criteria1.andArtistLike("%" + name + "%").andAlbumStatusEqualTo(1);

        example.or(criteria1);
        // sort TODO

        // page TODO

        return albumMapper.selectByExample(example);
    }

    public Album queryById(Integer id){
        Album album = albumMapper.selectByPrimaryKey(id);
        return album;
    }

    public List<Album> getUnauditedAlbums(){
        AlbumExample example = new AlbumExample();
        example.createCriteria().andAlbumStatusEqualTo(0);

        return albumMapper.selectByExample(example);
    }

    public int update(Album album) {
        return albumMapper.updateByPrimaryKeySelective(album);
    }

    public List<Integer> getAlbumIdsWithinOneMonth(){
        List<Integer> res = new ArrayList<>();

        AlbumExample example = new AlbumExample();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -2);
        Date m = c.getTime();
        String mon = format.format(m);
        System.out.println(mon);

        example.createCriteria().andReleaseDateGreaterThan(mon).andAlbumStatusEqualTo(1);
        List<Album> albums = albumMapper.selectByExample(example);

        for (int i = 0; i < albums.size(); i++) {
            res.add(albums.get(i).getId());
        }

        return res;
    }

    public List<Album> queryByIdList(List<Integer> idList){
        AlbumExample example = new AlbumExample();
        example.createCriteria().andIdIn(idList);

        return albumMapper.selectByExample(example);
    }

}
