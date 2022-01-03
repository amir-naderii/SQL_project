package ir.ac.kntu.Model;

import java.util.Date;

public class User {
    private int id;
    private int credit;
    private String user_info_id;
    private Date creation_date;

    public User(int id, int credit, String user_info_id, Date creation_date) {
        this.id = id;
        this.credit = credit;
        this.user_info_id = user_info_id;
        this.creation_date = creation_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(String user_info_id) {
        this.user_info_id = user_info_id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
