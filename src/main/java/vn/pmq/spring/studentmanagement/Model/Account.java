package vn.pmq.spring.studentmanagement.Model;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private int accountId;
    private String userName;
    private String fullName;
    private String passWord;
    private String email;
    private String phone;

    public Account() {
    }

    public Account(int accountId, String userName, String fullName, String passWord, String email, String phone) {
        this.accountId = accountId;
        this.userName = userName;
        this.fullName = fullName;
        this.passWord = passWord;
        this.email = email;
        this.phone = phone;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
