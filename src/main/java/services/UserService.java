package services;

import DAO.InterestDAO;
import DAO.UserDAO;
import models.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class UserService {
    private UserDAO dao = new UserDAO();
    private InterestDAO interestDAO = new InterestDAO();

    public int getIdByEmail(String email) {
        try {
            int id = dao.findIDofUser(email);
            return id;
        } catch (NullPointerException e) {
            System.out.println("Exception during get id by user's email");
        }
        return 0;
    }

    public String getUsernameByEmail(String email) {
        try {
            User user = dao.getUserByEmail(email);
            return user.getUsername();
        } catch (NullPointerException e) {
            System.out.println("Exception during get username by email");
        }
        return null;
    }

    public LocalDate getbirthDateByEmail(String email) {
        try {
            User user = dao.getUserByEmail(email);
            return user.getBirthDate();
        } catch (NullPointerException e) {
            System.out.println("Exception during get birthDate by email");
        }
        return null;
    }

    public String getImgByEmail(String email) {
        try {
            User user = dao.getUserByEmail(email);
            return user.getImg();
        } catch (NullPointerException e) {
            System.out.println("Exception during getImg by Email ");
        }
        return null;
    }

    public int getChannelIdByEmail(String email) {
        return dao.getChannelIdOfUser(email);
    }

    public boolean userIsExist(String email, String password) {
       return dao.userIsExist(email, password);
    }

    public boolean emailIsContained(String email) {
        return dao.emailIsContained(email);
    }

    public void saveUser(String email, String username, String passwordHash, LocalDate birthDate, String img){
        dao.saveUser(new User(email, username, passwordHash, birthDate, img));
    }

    public void updateData(String username, LocalDate date, String email){
        dao.updateData(username, date, email);
    }

    public void addInterest(int idUser, int i){
       interestDAO.addInterest(idUser, String.valueOf(i));
    }

    public void deleteInterest(int idUser, int i){
        interestDAO.deleteInterest(idUser, String.valueOf(i));
    }

    public boolean interestIsExist(int i, int idUser){
        return interestDAO.interestIsExist(String.valueOf(i), idUser);
    }

    public Map<Integer, String> findInterestOfUser(int idUser) {
        return interestDAO.findInterestsOfUser(idUser);
    }

    public Map<Integer, String> getInterests() {
        return interestDAO.getInterests();
    }

    public void editInterests(ArrayList interests, int idUser){
        for (int i = 0; i < interests.size() ; i++) {
            if (interests.get(i) != null) {
                if (interests.get(i).equals("off")) {
                    addInterest(idUser, i+1);
                }
            } else {
                if (interestIsExist(i+1, idUser)) {
                    deleteInterest(idUser, i+1);
                }
            }
        }

    }
}
