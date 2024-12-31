package vn.pmq.spring.studentmanagement.Model;

import java.sql.Date;

public class Profile {
    private int accountId;
    private String idCard;
    private String address;
    private boolean gender;
    private String avatar;
    private Date dateOfBirth;

    public Profile(int accountId, String ID_card, String address, boolean gender, String avatar, Date dateOfBirth) {
        this.accountId = accountId;
        this.idCard = idCard;
        this.address = address;
        this.gender = gender;
        this.avatar = avatar;
        this.dateOfBirth = dateOfBirth;
    }

    public Profile() {
    }

    public int getaccountId() {
        return accountId;
    }

    public void setaccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getidCard() {
        return idCard;
    }

    public void setidCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
