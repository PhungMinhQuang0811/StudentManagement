package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "id_card",nullable = false)
    private String idCard;
    @Column(name = "address")
    private String address;
    @Column(name = "gender",nullable = false)
    private boolean gender;
    @Column(name = "avatar")
    @Lob
    private Blob avatar;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    @MapsId
    private Account account;

    public Profile(int accountId, String ID_card, String address, boolean gender, Blob avatar, Date dateOfBirth) {
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

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public Date getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
