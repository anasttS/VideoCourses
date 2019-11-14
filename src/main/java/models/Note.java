package models;

public class Note {
    private int id;
    private String text;
    private int id_user;
    private int id_video;
    private String videoName;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Note(int id, String text, int id_user, int id_video) {
        this.id = id;
        this.text = text;
        this.id_user = id_user;
        this.id_video = id_video;
    }

    public Note(String text, int id_user, int id_video) {
        this.text = text;
        this.id_user = id_user;
        this.id_video = id_video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

}
