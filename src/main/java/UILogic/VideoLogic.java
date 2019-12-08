package UILogic;

import models.Video;
import services.ChannelService;
import services.UserService;
import services.VideoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class VideoLogic {
    private UserService userService = new UserService();
    private ChannelService channelService = new ChannelService();
    private VideoService videoService = new VideoService();

    public void sendToAddVideoPage(HttpServletRequest req, HttpServletResponse resp) {

        if (req.getParameter("redirect") != null) {
            try {
                resp.sendRedirect("/addVideo");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendToVideoPage(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("id") != null) {
            try {
                resp.sendRedirect("/video");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addVideo(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("addVideo") != null) {
            int idUser = userService.getIdByEmail((String) req.getSession().getAttribute("current_user"));
            int idChannel = channelService.findIdOfChannkeByUserId(idUser);
            String title = req.getParameter("videoName");
            String description = req.getParameter("description");
            int interest_id = 0;
            for (int i = 1; i <= 5; i++) {
                String interest = req.getParameter("Interest" + i);
                if (interest != null) {
                    interest_id = Integer.parseInt(interest);
                }
            }
            MediaAdd m = new MediaAdd();
            String url;
            String img;
            try {
                url = m.addMedia(req, "fileM");
                img = m.addMedia(req, "fileP");
            } catch (IOException | ServletException e) {
                System.out.println();
                throw new IllegalArgumentException();
            }
            int likes = 0;
            int views = 0;
            LocalDate upload_date = LocalDate.now();
            Video video = new Video(title, description, upload_date, idUser, idChannel, likes, views, url, img, interest_id);
            videoService.addVideo(video);
            try {
                resp.sendRedirect("/channelProfile");
            } catch (IOException e) {
                System.out.println("Exception during add Video");
                throw new IllegalArgumentException();
            }
        }
    }

    public ArrayList<Video> getVideos() {
        return videoService.getVideos();
    }

    public ArrayList<Video> get7Videos() {
        return videoService.get7Videos();
    }

    public ArrayList<Video> getVideosByVideoname(String name) {
        return videoService.getVideosByVideoname(name);
    }

    public ArrayList<Video> getVideoByUserName(String query) {
        return videoService.getVideoByUserName(query);
    }

    public ArrayList<Video> getVideosByUserInterests(int id_user) {
        return videoService.getVideosByUserInterests(id_user);
    }


    public ArrayList<Video> getVideoByChannelName(String query) {
        return videoService.getVideoByChannelName(query);
    }

    public Video findVideoById(int id) {
        return videoService.findVideoById(id);
    }

    public void increaseViews(int id) {
        videoService.increaseViews(id);
    }

    public void increaseLikes(int id, HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("like") != null) {
            videoService.increaseLikes(id);
            try {
                resp.sendRedirect("/video?id=" + id);
            } catch (IOException e) {
                System.out.println();
                throw new IllegalArgumentException();
            }
        }
    }
}
