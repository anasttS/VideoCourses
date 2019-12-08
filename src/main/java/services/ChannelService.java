package services;

import DAO.ChannelDAO;
import DAO.UserDAO;
import DAO.VideoDAO;
import UILogic.ChannelLogic;
import UILogic.MediaAdd;
import models.Channel;
import models.Video;

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
    private UserDAO userDAO = new UserDAO();
    private ChannelDAO channelDAO = new ChannelDAO();
    private VideoDAO videoDAO = new VideoDAO();

    public int getIdByName(String name) {
        try {
            int id = channelDAO.findIDofChannel(name);
            return id;
        } catch (NullPointerException e) {
            System.out.println("Exception during find Id of channel");
        }
        return 0;
    }

    public int findIdOfChannkeByUserId(int userId){
        return channelDAO.findIDofChannelByUserID(userId);
    }

    public ArrayList<Video> getVideosByChannelId(int channelId) {
        return videoDAO.getVideoArrByChannelId(channelId);
    }

    public void createChannel(String email, String nameOfChannel, String img) {
        channelDAO.createChannel(new Channel(userDAO.findIDofUser(email), nameOfChannel, img));
        userDAO.createChannel(channelDAO.findIDofChannelByUserID(userDAO.findIDofUser(email)), email);
    }


    public boolean channelIsExist(int id) {
        return channelDAO.channelIsExist(id);
    }

    public String findNameofChannelByUserId(int ownerId) {
        String name = channelDAO.findNameOfChannelByUserID(ownerId);
        return name;
    }

    public String findImgofChannelByUserId(int ownerId) {
        String img = channelDAO.findImgOfChannelByUserID(ownerId);
        return img;
    }

    public String findNameofChannelByIdVideo(int videoId) {
        String name = channelDAO.findNameOfChannelByVideoId(videoId);
        return name;
    }

    public String findImgOfChannelByVideoId(int videoId) {
        String img = channelDAO.findImgOfChannelByVideoId(videoId);
        return img;
    }

}
