package models;

import java.time.LocalDate;

public class Video {
    private int idVideo;
    private String name;
    private String description;
    private LocalDate uploadDate;
    private int ownerId;
    private int channelId;
    private int likes;
    private int views;
    private String url;
    private String img;
    private String username;
    private int interestId;

    public Video(int id, String name, String description, LocalDate uploadDate, int ownerId, int channelId, int likes, int views, String url, String img) {
        this.idVideo = id;
        this.name = name;
        this.description = description;
        this.uploadDate = uploadDate;
        this.ownerId = ownerId;
        this.channelId = channelId;
        this.likes = likes;
        this.views = views;
        this.url = url;
        this.img = img;
    }
    public Video(String name, String description, LocalDate uploadDate, int ownerId, int channelId, int likes, int views, String url, String img, int interestId) {
        this.name = name;
        this.description = description;
        this.uploadDate = uploadDate;
        this.ownerId = ownerId;
        this.channelId = channelId;
        this.likes = likes;
        this.views = views;
        this.url = url;
        this.img = img;
        this.interestId = interestId;
    }
    public Video(int id, String name, String description, LocalDate uploadDate, int ownerId, int channelId, String url, String img) {
        this.idVideo = id;
        this.name = name;
        this.description = description;
        this.uploadDate = uploadDate;
        this.ownerId = ownerId;
        this.channelId = channelId;
        this.url = url;
        this.img = img;
    }

    public Video(String name, String description, LocalDate uploadDate, int ownerId, int channelId, int likes, int views, String url, String img) {
        this.name = name;
        this.description = description;
        this.uploadDate = uploadDate;
        this.ownerId = ownerId;
        this.channelId = channelId;
        this.url = url;
        this.img = img;
    }

    public int getinterestId() {
        return interestId;
    }

    public void setinterestId(int interestId) {
        this.interestId = interestId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getidVideo() {
        return idVideo;
    }

    public void setidVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getuploadDate() {
        return uploadDate;
    }

    public void setuploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getownerId() {
        return ownerId;
    }

    public void setownerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getchannelId() {
        return channelId;
    }

    public void setchannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
