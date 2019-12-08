package services;

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
    private NoteDAO noteDAO = new NoteDAO();
    private UserDAO userDAO = new UserDAO();


    public void saveNote(int videoId, String note, int idUser) {
        noteDAO.saveNoteBD(new Note(note, idUser, videoId));
    }

    public ArrayList<Note> getNotesByUserID(int idUser) {
        return noteDAO.getNotesArrByUserID(idUser);
    }

    public void editNote(String note, int id) {
        noteDAO.updateData(note, id);

    }

    public void deleteNote(int id) {
        noteDAO.deleteNote(id);
    }
}
