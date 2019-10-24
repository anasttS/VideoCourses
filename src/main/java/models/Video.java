package models;

import java.time.LocalDate;

public class Video {
    private int id;
    private String name;
    private String description;
    private LocalDate upload_date;
    private int owner_id;
    private int channel_id;
    private int playlist_id;
    private int likes;
    private int views;
    private String url;

    public Video(String name, String description, LocalDate upload_date, int owner_id, int channel_id, int playlist_id, int likes, int views, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.upload_date = upload_date;
        this.owner_id = owner_id;
        this.channel_id = channel_id;
        this.playlist_id = playlist_id;
        this.likes = likes;
        this.views = views;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
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
