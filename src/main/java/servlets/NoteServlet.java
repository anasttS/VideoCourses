package servlets;

import UILogic.NoteLogic;
import UILogic.UserLogic;
import services.NoteService;
import services.UserService;
import UILogic.ForNavbar;
import models.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/notes")
public class NoteServlet extends HttpServlet {
    private NoteLogic noteLogic = new NoteLogic();
    private UserLogic userLogic = new UserLogic();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userLogic.authUser(req);
        if (userLogic.checkUser(req, resp)) {
            ArrayList<Note> notes = noteLogic.getNotesByUserID(userLogic.getIdByEmail((req)));
            req.setAttribute("notes", notes);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/notes.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        noteLogic.editNote(req, resp);
        noteLogic.deleteNote(req, resp);
    }
}
