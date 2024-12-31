package vn.pmq.spring.studentmanagement.Model;

public class Status {
    private int statusId;
    private String name;
    public Status(int statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    public Status() {
    }

    public int getstatusId() {
        return statusId;
    }
    public void setstatusId(int statusId) {
        this.statusId = statusId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
