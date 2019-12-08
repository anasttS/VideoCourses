package models;

public class Note {
    private int id;
    private String text;
    private int idUser;
    private int idVideo;
    private String videoName;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Note(int id, String text, int idUser, int idVideo) {
        this.id = id;
        this.text = text;
        this.idUser = idUser;
        this.idVideo = idVideo;
    }

    public Note(String text, int idUser, int idVideo) {
        this.text = text;
        this.idUser = idUser;
        this.idVideo = idVideo;
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

    public int getidUser() {
        return idUser;
    }

    public void setidUser(int idUser) {
        this.idUser = idUser;
    }

    public int getidVideo() {
        return idVideo;
    }

    public void setidVideo(int idVideo) {
        this.idVideo = idVideo;
    }

}
