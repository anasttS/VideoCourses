package pages;

import BL.ChannelService;
import BL.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private UserService userService = new UserService();
    private ChannelService channelService = new ChannelService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("auth", req.getSession().getAttribute("current_user"));
        req.setAttribute("username", userService.getUsernameByEmail((String) req.getSession().getAttribute("current_user")));
        req.setAttribute("email", (String) req.getSession().getAttribute("current_user"));
        req.setAttribute("birthDate", userService.getbirthDateByEmail((String) req.getSession().getAttribute("current_user")) + "");
        req.setAttribute("img", userService.getImgByEmail((String) req.getSession().getAttribute("current_user")));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/profile.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = channelService.getIdByName(channelService.findNameofChannelByUserId(userService.getIdByEmail((String) req.getSession().getAttribute("current_user"))));
        channelService.sendToCreatingChannel(id, req, resp);
      userService.edit(req, resp);
      userService.delete(req, resp);


    }
}
