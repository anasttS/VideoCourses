package models;

import java.time.LocalDate;

public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private LocalDate birthDate;
    private String img_user;

    public User(String email, String username, String password, LocalDate birthDate) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
    }

    public User(String email, String username, String password, LocalDate birthDate, String img) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.img_user = img;
    }

    public String getImg() {
        return img_user;
    }

    public void setImg(String img) {
        this.img_user = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
