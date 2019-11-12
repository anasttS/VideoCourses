package BL;

import DAO.ChannelDAO;
import DAO.UserDAO;
import DAO.VideoDAO;
import UILogic.MediaAdd;
import models.Channel;
import models.User;
import models.Video;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)

public class ChannelService {
    UserDAO userDAO = new UserDAO();
    ChannelDAO channelDAO = new ChannelDAO();
    VideoDAO videoDAO = new VideoDAO();

    public int getIdByName(String name) {
        try {
            int id = channelDAO.findIDofChannel(name);
            return id;
        } catch (NullPointerException e) {
            System.out.println("Exception");
        }
        return 0;
    }

    public ArrayList<Video> getVideosByChannelId(int channel_id) {

        return videoDAO.getVideoArrByChannelId(channel_id);
    }

    public void sendToCreatingChannel(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (!channelDAO.channelIsExist(userDAO.findIDofUser((String) req.getSession().getAttribute("current_user")))) {
                resp.sendRedirect("/createChannel");
            }
        } catch (IOException e) {
            System.out.println("Exception during sending to Creating channel page");
            throw new IllegalArgumentException();
        }
    }

    public void createChannel(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("createChannel") != null) {
                String email = (String) req.getSession().getAttribute("current_user");
                String nameOfChannel = req.getParameter("nameOfChannel");
                req.getSession().setAttribute("nameOfChannel", nameOfChannel);
                MediaAdd m = new MediaAdd();
                String img;
                try {
                    img = m.addMedia(req, "fileP");
                } catch (IOException | ServletException e) {
                    System.out.println();
                    throw new IllegalArgumentException();
                }
                channelDAO.createChannel(new Channel(userDAO.findIDofUser(email), nameOfChannel, img));
                userDAO.createChannel(channelDAO.findIDofChannelByUserID(userDAO.findIDofUser(email)), email);
                resp.sendRedirect("/channelProfile");
            }
        } catch (IOException e) {
            System.out.println("Exception during creating channel");
            throw new IllegalArgumentException();
        }
    }

    public String findNameofChannelByUserId(int owner_id) {
        String name = channelDAO.findNameOfChannelByUserID(owner_id);
        return name;
    }

    public String findImgOfChannelByUserId(int owner_id) {
        String img = channelDAO.findImgOfChannelByUserID(owner_id);
        return img;
    }

}
