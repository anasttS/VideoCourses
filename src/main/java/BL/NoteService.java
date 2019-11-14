package BL;

import DAO.NoteDAO;
import DAO.UserDAO;
import models.Note;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

// delete, edit
public class NoteService {
    NoteDAO noteDAO = new NoteDAO();
    UserDAO userDAO = new UserDAO();


    public void saveNote(int id_video, HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        try {
            if (req.getParameter("save") != null) {
                String note = req.getParameter("noteText");
                int id_user = userDAO.findIDofUser((String) session.getAttribute("current_user"));
                noteDAO.saveNoteBD(new Note(note, id_user, id_video));
                resp.sendRedirect("/video?id=" + id_video);
            }
        } catch (IOException e) {
            System.out.println("Exception during saveNote");
            throw new IllegalArgumentException();
        }
    }
    public ArrayList<Note> getNotesByUserID(int id_user) {
        return noteDAO.getNotesArrByUserID(id_user);
    }

    public void editNote(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("edit") != null){
//                String note = req.getParameter("noteText");
//                int id_video = 1;
//                int id_user = userDAO.findIDofUser((String) req.getSession().getAttribute("current_user"));
                noteDAO.updateData(req.getParameter("note"), Integer.parseInt(req.getParameter("edit")));
                resp.sendRedirect("/notes");
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }
    public void deleteNote(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("delete") != null) {
            noteDAO.deleteNote(Integer.parseInt(req.getParameter("delete")));

            try {
                resp.sendRedirect("/notes");
            } catch (IOException e) {
                System.out.println("Exception during deleteNote BD  ");
                throw new IllegalArgumentException();
            }
        }
    }
}
