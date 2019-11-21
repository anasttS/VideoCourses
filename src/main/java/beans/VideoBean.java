package beans;

import BL.VideoService;
import models.Video;

import java.util.ArrayList;

public class VideoBean {
    private VideoService videoService = new VideoService();
    private ArrayList<Video> videos7;
    private ArrayList<Video> videos;

    public ArrayList<Video> getVideos(){
        return videoService.getVideos();
    }


    public ArrayList<Video> getVideos7() {
        return videoService.get7Videos();
    }

    public void setVideos7(ArrayList<Video> videos7) {
        this.videos7 = videos7;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }
}
