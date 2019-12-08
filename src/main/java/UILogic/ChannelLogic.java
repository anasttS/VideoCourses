package UILogic;
import models.Video;
import services.ChannelService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ChannelLogic {
    private ChannelService channelService = new ChannelService();

    public boolean channelIsExist(int id) {
        return channelService.channelIsExist(id);
    }

    public int getIdByName(String name) {
        return channelService.getIdByName(name);
    }

    public String findNameofChannelByUserId(int owner_id) {
        return channelService.findNameofChannelByUserId(owner_id);
    }

    public String findImgofChannelByUserId(int owner_id) {
        return channelService.findImgofChannelByUserId(owner_id);
    }

    public String findImgOfChannelByVideoId(int video_id) {
        return channelService.findImgOfChannelByVideoId(video_id);
    }

    public String findNameofChannelByIdVideo(int video_id) {
        return channelService.findNameofChannelByIdVideo(video_id);
    }

    public ArrayList<Video> getVideosByChannelId(int channel_id) {
        return channelService.getVideosByChannelId(channel_id);
    }

    public void createChannel(int id, HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("createChannel") != null) {
            if (id != 0) {
                try {
                    resp.sendRedirect("/channelProfile");
                } catch (IOException e) {
                    System.out.println();
                    throw new IllegalArgumentException();
                }
            } else {
                try {
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
                    channelService.createChannel(email, nameOfChannel, img);
                    resp.sendRedirect("/channelProfile");
                } catch (IOException e) {
                    System.out.println("Exception during creating channel");
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void sendToCreatingChannel(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("createChannel") != null) {
            try {
                resp.sendRedirect("/channelProfile");
            } catch (IOException e) {
                System.out.println("Exception during sending to Creating channel page");
                throw new IllegalArgumentException();
            }
        }
    }
}
