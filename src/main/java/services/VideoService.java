package services;

import DAO.ChannelDAO;
import DAO.InterestDAO;
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
    private UserDAO userDAO = new UserDAO();
    private ChannelDAO channelDAO = new ChannelDAO();
    private VideoDAO videoDAO = new VideoDAO();


    public void addVideo(Video video) {
        videoDAO.saveVideo(video);
    }

    public ArrayList<Video> getVideos() {
        return videoDAO.getVideoArr();
    }

    public ArrayList<Video> get7Videos() {
        return videoDAO.get7VideoArr();
    }

    public ArrayList<Video> getVideosByVideoname(String name) {
        return videoDAO.getVideoByVideoName(name);
    }

    public ArrayList<Video> getVideoByUserName(String query) {
        return videoDAO.getVideoByUserName(query);
    }

    public ArrayList<Video> getVideosByUserInterests(int id_user) {
        return videoDAO.getVideosByInterests(id_user);
    }


    public ArrayList<Video> getVideoByChannelName(String query) {
        return videoDAO.getVideoByChannelName(query);
    }

    public Video findVideoById(int id) {
        return videoDAO.getVideoByID(id);
    }

    public void increaseViews(int id) {
        videoDAO.increaseViews(id);
    }

    public void increaseLikes(int id) {

        videoDAO.increaseLikes(id);
    }

    public void sendToVideoPageByWatchButton(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("watch") != null && req.getSession().getAttribute("current_user") != null) {
                resp.sendRedirect("/video");
            } else {
                resp.sendRedirect("/videos");

            }
        } catch (IOException e) {
            System.out.println("Exception during sending to video page");
            throw new IllegalArgumentException();
        }
    }

}

