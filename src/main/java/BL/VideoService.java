package BL;

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
    UserDAO userDAO = new UserDAO();
    ChannelDAO channelDAO = new ChannelDAO();
    VideoDAO videoDAO = new VideoDAO();
    InterestDAO interestDAO = new InterestDAO();

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
            int idUser = userDAO.findIDofUser((String) req.getSession().getAttribute("current_user"));
            int idChannel = channelDAO.findIDofChannelByUserID(idUser);
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
            videoDAO.saveVideo(video);
            try {
                resp.sendRedirect("/channelProfile");
            } catch (IOException e) {
                System.out.println("Exception during add Video");
                throw new IllegalArgumentException();
            }
        }
    }

    public String getUrlById(int id) {
        String url = videoDAO.getUrlById(id);
        ;
        return url;
    }

    public ArrayList<Video> getVideos() {
        return videoDAO.getVideoArr();
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

    public void increaseLikes(int id, HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("like") != null) {
            videoDAO.increaseLikes(id);
            try {
                resp.sendRedirect("/video?id=" + id);
            } catch (IOException e) {
                System.out.println();
                throw new IllegalArgumentException();
            }
        }
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

