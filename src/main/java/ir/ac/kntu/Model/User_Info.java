package ir.ac.kntu.Model;

import java.util.Date;

public class User_Info {
    private String id_number;
    private String email;
    private String phone_number;
    private String full_name;
    private String Gender;
    private Date birth_date;
    private String Pass;

    public User_Info(String id_number, String email, String phone_number, String full_name, String gender, Date birth_date, String pass) {
        this.id_number = id_number;
        this.email = email;
        this.phone_number = phone_number;
        this.full_name = full_name;
        Gender = gender;
        this.birth_date = birth_date;
        Pass = pass;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    @Override
    public String toString() {
        return "User_Info{" +
                "id_number='" + id_number + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", full_name='" + full_name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", birth_date=" + birth_date +
                ", Pass='" + Pass + '\'' +
                '}';
    }
}
