package com.glasgow.wind.vo;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/6 15:12
 * @Version 1.0
 */
public class AlbumReviewVO {
    private int reviewId;
    private String username;
    private String content;
    private Integer likeCount;
    private String updateTime;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
