package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Blog {
    private int blogId;
    private String title;
    private String content;
    private int UserId;
    private Timestamp postTime;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

//    public Timestamp getPostTime() {
//        return postTime;
//    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public String getPostTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(postTime);

    }
}
