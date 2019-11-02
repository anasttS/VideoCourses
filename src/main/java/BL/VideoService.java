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
    UserService service = new UserService();


    public void saveNote(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        try {
            if (req.getParameter("save") != null) {
                String note = req.getParameter("noteText");
                int id_video = 1;
                int id_user = service.getIdByEmail((String) session.getAttribute("current_user"));
                noteDAO.saveNoteBD(new Note(note, id_user, id_video));
                resp.sendRedirect("/video");
            }
        } catch (IOException e) {
            System.out.println("Exception during saveNote");
            throw new IllegalArgumentException();
        }
    }
}

