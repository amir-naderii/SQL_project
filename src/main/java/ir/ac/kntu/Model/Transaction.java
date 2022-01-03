package ir.ac.kntu.Model;

import java.util.Date;

public class Transaction {
    private Integer id;
    private Date date;
    private Integer amount;
    private String credit_card_number;
    private Integer charge_user_id;
    private String type;

    public Transaction(Integer id, Date date, Integer amount, String credit_card_number, Integer charge_user_id, String type) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.credit_card_number = credit_card_number;
        this.charge_user_id = charge_user_id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public Integer getCharge_user_id() {
        return charge_user_id;
    }

    public void setCharge_user_id(Integer charge_user_id) {
        this.charge_user_id = charge_user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
