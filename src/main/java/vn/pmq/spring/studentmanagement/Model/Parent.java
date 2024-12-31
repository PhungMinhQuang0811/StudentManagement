package vn.pmq.spring.studentmanagement.Model;

public class Parent {
    private int parentId;
    private String fullName;
    private String address;
    private String email;
    private String job;
    private String placeOfWork;

    public Parent(int parentId, String fullName, String address, String email, String job, String placeOfWork) {
        this.parentId = parentId;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.job = job;
        this.placeOfWork = placeOfWork;
    }

    public Parent() {
    }

    public int getparentId() {
        return parentId;
    }

    public void setparentId(int parentId) {
        this.parentId = parentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getplaceOfWork() {
        return placeOfWork;
    }

    public void setplaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }
}
