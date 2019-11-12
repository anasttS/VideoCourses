package models;

import java.time.LocalDate;

public class User {
    private int id;
    private String email;
    private String username;
    private int password;
    private LocalDate birthDate;
    private String interests;
    private int role_id;
    private String right;
    private String img_user;

    public User(String email, String username, int password, LocalDate birthDate, String interests) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.interests = interests;
    }

    public User(String email, String username, int password, LocalDate birthDate, String interests, String img) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.interests = interests;
        this.img_user = img;
    }

    public String getImg() {
        return img_user;
    }

    public void setImg(String img) {
        this.img_user = img;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
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


    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(int password) {
        this.password = password;
    }


    public int getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
