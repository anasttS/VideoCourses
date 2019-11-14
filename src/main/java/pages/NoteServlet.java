package pages;

import BL.NoteService;
import BL.UserService;
import UILogic.ForNavbar;
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
    private ForNavbar forNavbar = new ForNavbar();
    private NoteService noteService = new NoteService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forNavbar.authUser(req);
        if (req.getSession().getAttribute("current_user") != null) {
            ArrayList<Note> notes = noteService.getNotesByUserID(userService.getIdByEmail((String) req.getSession().getAttribute("current_user")));
            req.setAttribute("notes", notes);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/notes.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        noteService.editNote(req, resp);
        noteService.deleteNote(req, resp);
    }
}
