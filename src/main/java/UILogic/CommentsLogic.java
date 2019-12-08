package UILogic;

import models.Comment;
import models.User;
import services.CommentService;
import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

import static java.lang.Integer.parseInt;

public class CommentsLogic {
    private CommentService commentService = new CommentService();
    private UserService userService = new UserService();

    public LinkedList<Comment> getComments(int videoId) {
       return commentService.getComments(videoId);
    }

    public void sendComment(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("send") != null) {
            int id_n = parseInt(request.getParameter("send"));
            int idUser = userService.getIdByEmail(request.getSession().getAttribute("current_user").toString());
            String text = request.getParameter("text");
            java.sql.Date myDate = new java.sql.Date(System.currentTimeMillis());
            Comment comment = new Comment(idUser, id_n, myDate, text);
            commentService.sendComment(comment);
            try {
                response.sendRedirect("/video?id=" + id_n);
            } catch (IOException e) {
                System.out.println();
                throw new IllegalArgumentException();
            }
        }
    }

}
