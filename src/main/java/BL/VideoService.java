package BL;

import DAO.ChannelDAO;
import DAO.UserDAO;
import DAO.VideoDAO;
import UILogic.MediaAdd;
import models.Video;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class VideoService {
    UserDAO userDAO = new UserDAO();
    ChannelDAO channelDAO = new ChannelDAO();
    VideoDAO videoDAO = new VideoDAO();

    public void sendToAddVideoPage( HttpServletRequest req, HttpServletResponse resp) {

        if (req.getParameter("redirect") != null) {
            try {
                resp.sendRedirect("/addVideo");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void sendToVideoPage( HttpServletRequest req, HttpServletResponse resp) {
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
            int idUser = userDAO.findIDofUser((String) req.getSession().getAttribute("current_user"));
            int idChannel = channelDAO.findIDofChannelByUserID(idUser);
            String title = req.getParameter("videoName");
            String description = req.getParameter("description");
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
            Video video = new Video(title, description, upload_date, idUser, idChannel, likes, views, url, img);
            videoDAO.saveVideo(video);
            try {
                resp.sendRedirect("/channelProfile");
            } catch (IOException e) {
                System.out.println();
                throw new IllegalArgumentException();
            }
        }
    }

    public String getUrlById(int id){
        String url = null;
        videoDAO.getUrlById(id);
        return url;
    }
    public ArrayList<Video> getVideos() {
        return videoDAO.getVideoArr();
    }

    public ArrayList<Video> getRandomVideos() {
        return videoDAO.getRandomVideoArr();
    }

    public Video findVideoById(int id){
        return videoDAO.getVideoByID(id);
    }
}

