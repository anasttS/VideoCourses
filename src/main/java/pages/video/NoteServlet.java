package pages.video;

import BL.NoteService;
import BL.UserService;
import models.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/notes")
public class NoteServlet extends HttpServlet {

    NoteService noteService = new NoteService();
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Note> notes = noteService.getNotesByUserID(userService.getIdByEmail((String) req.getSession().getAttribute("current_user")));
        req.setAttribute("notes", notes);
        req.setAttribute("auth", req.getSession().getAttribute("current_user"));
        req.setAttribute("username", userService.getUsernameByEmail((String) req.getSession().getAttribute("current_user")));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/notes.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            noteService.editNote(req, resp);
            noteService.deleteNote(req, resp);


    }
}
