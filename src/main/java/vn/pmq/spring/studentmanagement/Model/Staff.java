package vn.pmq.spring.studentmanagement.Model;

public class Staff {
    private int staffId;
    private String position;
    private String memberCode;
    private String major;

    public Staff(int staffId, String position, String memberCode, String major) {
        this.staffId = staffId;
        this.position = position;
        this.memberCode = memberCode;
        this.major = major;
    }

    public Staff() {
    }

    public int getstaffId() {
        return staffId;
    }

    public void setstaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getmemberCode() {
        return memberCode;
    }

    public void setmemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
