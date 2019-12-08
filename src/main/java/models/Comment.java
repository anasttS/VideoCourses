package models;

import java.sql.Date;

public class Comment{
    private int id;
    private int userId;
    private int mediaId;
    private Date date;
    private String text;
    private String userName;
    private String img;

    public Comment(int userId, int mediaId, Date date, String text) {
        this.userId = userId;
        this.mediaId = mediaId;
        this.date = date;
        this.text = text;
    }

    public Comment(int id, int mediaId, Date date, String text, String userName, String img) {
        this.id = id;
        this.mediaId = mediaId;
        this.date = date;
        this.text = text;
        this.userName = userName;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public String getImg() {
        return img;
    }
}
