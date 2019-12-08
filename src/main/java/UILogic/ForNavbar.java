package UILogic;

import services.UserService;

import javax.servlet.http.HttpServletRequest;

public class ForNavbar {
    UserService userService = new UserService();

    public void authUser(HttpServletRequest req){
        req.setAttribute("auth", req.getSession().getAttribute("current_user"));
        req.setAttribute("username", userService.getUsernameByEmail((String) req.getSession().getAttribute("current_user")));
    }
}
