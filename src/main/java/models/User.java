package models;

import java.time.LocalDate;

public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private LocalDate birthDate;
    private String interests;

    public User(String email, String username, String password, LocalDate birthDate, String interests) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.interests = interests;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
