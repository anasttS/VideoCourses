package UILogic;

import models.Note;
import services.NoteService;
import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class NoteLogic {
    private UserService userService = new UserService();
    private NoteService noteService = new NoteService();


    public void saveNote(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        try {
            if (req.getParameter("save") != null) {
                String note = req.getParameter("noteText");
                int id_video = Integer.parseInt(req.getParameter("id"));
                int id_user = userService.getIdByEmail((String) req.getSession().getAttribute("current_user"));
                noteService.saveNote(id_video, note, id_user);
                resp.sendRedirect("/video?id=" + id_video);
            }
        } catch (IOException e) {
            System.out.println("Exception during saveNote");
            throw new IllegalArgumentException();
        }
    }
    public void editNote(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("edit") != null) {
                noteService.editNote(req.getParameter("note"), Integer.parseInt(req.getParameter("edit")));
                resp.sendRedirect("/notes");
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }

    public void deleteNote(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("delete") != null) {
            noteService.deleteNote(Integer.parseInt(req.getParameter("delete")));
            try {
                resp.sendRedirect("/notes");
            } catch (IOException e) {
                System.out.println("Exception during deleteNote BD  ");
                throw new IllegalArgumentException();
            }
        }
    }

    public ArrayList<Note> getNotesByUserID(int id_user) {
        return noteService.getNotesByUserID(id_user);
    }
}
