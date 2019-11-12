package pages;

import DAO.FindDAO;

import models.Video;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dosearch")
public class AjaxSearchServlet extends HttpServlet {
    FindDAO findDAO = new FindDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        String searchParam = req.getParameter("search_param");
        List<Video> videos = null;
        switch (searchParam){
            case "all":
                videos = findDAO.getAllByAll(query);
                break;
            case "video":
                videos = findDAO.getNoteBySearch(query);
                break;
            case "username":
                videos = findDAO.getAllByUserName(query);
                break;
            case "channel":
                videos = findDAO.getAllByChannelName(query);
                break;
        }

        JSONArray ja = new JSONArray();
        for (Video note: videos) {
            ja.put(new JSONObject(note));
        }
        JSONObject jo = new JSONObject();
        jo.put("objects", ja);

        resp.setContentType("text/json");
        resp.getWriter().write(jo.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
