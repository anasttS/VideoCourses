package servlets;

import services.VideoService;

import models.Video;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/doSearch")
public class AjaxSearchServlet extends HttpServlet {
    private VideoService videoService = new VideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        String searchParam = req.getParameter("search_param");
        ArrayList<Video> videos = new ArrayList<>();
        switch (searchParam){
            case "video":
                videos = videoService.getVideosByVideoname(query);
                break;
            case "username":
                videos = videoService.getVideoByUserName(query);
                break;
            case "channelName":
                videos = videoService.getVideoByChannelName(query);
                break;
        }

        JSONArray ja = new JSONArray();
        for (Video video: videos) {
            ja.put(new JSONObject(video));
        }
        JSONObject jo = new JSONObject();
        jo.put("videos", ja);

        resp.setContentType("text/json");
        resp.getWriter().write(jo.toString());


    }
}
