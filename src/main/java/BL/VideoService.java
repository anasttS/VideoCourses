package BL;

import DAO.NoteDAO;
import DAO.UserDAO;
import models.Note;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VideoService {
    UserDAO userDAO = new UserDAO();
    NoteDAO noteDAO = new NoteDAO();

    public void saveNote(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        if (req.getParameter("save") != null) {
            String note = req.getParameter("note");
            int id_video = 3; //Integer.parseInt(req.getParameter("id"));
            String user = (String) session.getAttribute("current_user");
            int id_user =  userDAO.findIDofUser(user);
            noteDAO.saveNote(new Note(note, id_user, id_video));
            try {
                resp.sendRedirect("/video");
            } catch (IOException e) {
                System.out.println();
                throw new IllegalArgumentException();
            }
        }
    }
}
