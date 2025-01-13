package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;
    @Column(name = "position",length = 25,nullable = false)
    private String position;
    @Column(name = "member_code",length = 50,nullable = false)
    private String memberCode;
    @Column(name = "staff_code",length = 10,nullable = false)
    private String staffCode;
    @Column(name = "major",length = 25,nullable = false)
    private String major;
    @OneToOne(mappedBy = "staff",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Account account;
    @OneToMany(mappedBy = "staff",fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    private List<Feedback> feedbacks;
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

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", position='" + position + '\'' +
                ", memberCode='" + memberCode + '\'' +
                ", staffCode='" + staffCode + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
