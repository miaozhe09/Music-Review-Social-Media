package com.glasgow.wind.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glasgow.wind.domain.Album;
import com.glasgow.wind.domain.Message;
import com.glasgow.wind.domain.User;
import com.glasgow.wind.service.*;
import com.glasgow.wind.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/11 15:54
 * @Version 1.0
 */

@Controller
public class WebController {
    @Autowired
    RatingService ratingService;

    @Autowired
    AlbumService albumService;

    @Autowired
    UserService userService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    MessageService messageService;

    @Autowired
    AdminService adminService;

    @GetMapping("/")
    public String index(Model model){
        List<Integer> albumIdList = ratingService.queryRecommendAlbumId(albumService.getAlbumIdsWithinOneMonth());
        List<Album> albumList = new ArrayList<>();
        for (int i = 0; i < albumIdList.size(); i++) {
            albumList.add(albumService.queryById(albumIdList.get(i)));
        }

        setAttribute(albumList, model);
        return "/user/index";
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable("id") int id, Model model){
        User user = userService.queryById(id);
        model.addAttribute("user",user);

        return "/user/profile";
    }

    @GetMapping("/message/{id}")
    public String message(@PathVariable("id") int id, Model model){
        List<Message> messageList = messageService.queryByReceiverId(id);
        List<MessageVO> messageVOList = new ArrayList<>();
        for (int i = 0; i < messageList.size(); i++) {
            Message message = messageList.get(i);
            MessageVO messageVO = new MessageVO();
            messageVO.setMessageId(message.getId());
            if(message.getSenderType() == 0){ // 0: admin 1: user
                messageVO.setUsername("Offical Notification");
            }
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.getAddTime());
            messageVO.setAddTime(format);
            messageVO.setContent(message.getContent());
            messageVOList.add(messageVO);
        }

        model.addAttribute("messageVOList", messageVOList);
        model.addAttribute("count", messageVOList.size());

        return "/user/message";
    }

    @GetMapping("/record/{id}")
    public String record(@PathVariable("id") int id, Model model){
        List<Integer> albumIdList1 = reviewService.getAlbumIdListByUserId(id);
        List<Album> albumList1 = new ArrayList<>();
        for (int i = 0; i < albumIdList1.size(); i++) {
            albumList1.add(albumService.queryById(albumIdList1.get(i)));
        }
        model.addAttribute("albumList1", albumList1);
        model.addAttribute("count1", albumList1.size());

        List<Integer> albumIdList2 = ratingService.getAlbumIdListByUserId(id);
        List<Album> albumList2 = new ArrayList<>();
        for (int i = 0; i < albumIdList2.size(); i++) {
            albumList2.add(albumService.queryById(albumIdList2.get(i)));
        }
        model.addAttribute("albumList2", albumList2);
        model.addAttribute("count2", albumList2.size());

        return "/user/record";
    }

    @GetMapping("/albumToBeReviewed")
    public String albumToBeReviewd(){
        return "/user/albumToBeReviewed";
    }

    @GetMapping("/newRelease")
    public String newRelease(Model model, @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                             @RequestParam(defaultValue="10",value="pageSize")Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null) {
            pageSize = 10;
        }

        List<Integer> albumIdList = ratingService.queryRecommendAlbumId(albumService.getAlbumIdsWithinOneMonth());

        PageHelper.startPage(pageNum,pageSize);
        List<Album> albumList = albumService.queryByIdList(albumIdList);
        PageInfo<Album> pageInfo = new PageInfo<Album>(albumList);

        model.addAttribute("albumList", albumList);
        model.addAttribute("pageInfo", pageInfo);
        return "/user/newRelease";
    }

    @GetMapping("/discover")
    public String discover(){
        return "/user/discover";
    }

    @GetMapping("/charts")
    public String charts(){
        return "/user/charts";
    }

    @GetMapping("/review")
    public String review(){
        return "/user/review";
    }

    public void setAttribute(List<Album> albumList, Model model){
        model.addAttribute("c1", albumList.get(0));
        model.addAttribute("c2", albumList.get(1));
        model.addAttribute("c3", albumList.get(2));
        model.addAttribute("c4", albumList.get(3));
        model.addAttribute("n1", albumList.get(4));
        model.addAttribute("n2", albumList.get(5));
        model.addAttribute("n3", albumList.get(6));
        model.addAttribute("n4", albumList.get(7));
        model.addAttribute("n5", albumList.get(8));
        model.addAttribute("n6", albumList.get(9));
        model.addAttribute("n7", albumList.get(10));
        model.addAttribute("n8", albumList.get(11));
    }

}
