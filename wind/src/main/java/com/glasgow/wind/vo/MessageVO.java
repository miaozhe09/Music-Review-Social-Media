package com.glasgow.wind.vo;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/8 17:41
 * @Version 1.0
 */
public class MessageVO {
    private int messageId;
    private String username;
    private String addTime;
    private String content;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
