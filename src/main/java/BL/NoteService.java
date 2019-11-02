package BL;

import DAO.NoteDAO;
import DAO.UserDAO;
import DAO.VideoDAO;
import models.Note;
import models.Video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// delete, edit
public class NoteService {
    NoteDAO noteDAO = new NoteDAO();
   UserService service = new UserService();
    UserDAO userDAO = new UserDAO();

//    public String getVideonameByUserID(int id_video) {
//        return videoDAO.getVideonameByID(id_video);
//    }

    public ArrayList<Note> getNotesByUserID(int id_user) {
        return noteDAO.getNotesArrByUserID(id_user);
    }

    public void editNote(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("save") != null){
                noteDAO.updateData(Integer.parseInt(req.getParameter("id_video")), (String) req.getSession().getAttribute("current_user"), service.getIdByEmail((String) req.getSession().getAttribute("current_user")));
                resp.sendRedirect("/profile");
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }
    public void deleteNote(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("delete") != null){
                noteDAO.deleteNote(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("/profile");
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }
}
