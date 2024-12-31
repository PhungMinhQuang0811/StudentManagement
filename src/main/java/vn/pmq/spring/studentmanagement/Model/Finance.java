package vn.pmq.spring.studentmanagement.Model;

public class Finance {
    private int studentId;
    private int accountBalance;

    public Finance() {
    }

    public Finance(int studentId, int accountBalance) {
        this.studentId = studentId;
        this.accountBalance = accountBalance;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}
