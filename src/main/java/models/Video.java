package models;

import java.time.LocalDate;

public class Video {
    private int id_video;
    private String name;
    private String description;
    private LocalDate upload_date;
    private int owner_id;
    private int channel_id;
    private int likes;
    private int views;
    private String url;
    private String img;
    private String username;
    private int interest_id;

    public Video(int id, String name, String description, LocalDate upload_date, int owner_id, int channel_id, int likes, int views, String url, String img) {
        this.id_video = id;
        this.name = name;
        this.description = description;
        this.upload_date = upload_date;
        this.owner_id = owner_id;
        this.channel_id = channel_id;
        this.likes = likes;
        this.views = views;
        this.url = url;
        this.img = img;
    }
    public Video(String name, String description, LocalDate upload_date, int owner_id, int channel_id, int likes, int views, String url, String img, int interest_id) {
        this.name = name;
        this.description = description;
        this.upload_date = upload_date;
        this.owner_id = owner_id;
        this.channel_id = channel_id;
        this.likes = likes;
        this.views = views;
        this.url = url;
        this.img = img;
        this.interest_id = interest_id;
    }
    public Video(int id, String name, String description, LocalDate upload_date, int owner_id, int channel_id, String url, String img) {
        this.id_video = id;
        this.name = name;
        this.description = description;
        this.upload_date = upload_date;
        this.owner_id = owner_id;
        this.channel_id = channel_id;
        this.url = url;
        this.img = img;
    }

    public Video(String name, String description, LocalDate upload_date, int owner_id, int channel_id, int likes, int views, String url, String img) {
        this.name = name;
        this.description = description;
        this.upload_date = upload_date;
        this.owner_id = owner_id;
        this.channel_id = channel_id;

        this.url = url;
        this.img = img;
    }

    public int getInterest_id() {
        return interest_id;
    }

    public void setInterest_id(int interest_id) {
        this.interest_id = interest_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
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

    public LocalDate getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(LocalDate upload_date) {
        this.upload_date = upload_date;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
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
