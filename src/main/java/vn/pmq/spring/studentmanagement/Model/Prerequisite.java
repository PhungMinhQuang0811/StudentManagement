package vn.pmq.spring.studentmanagement.Model;

public class Prerequisite {
    private int prerequisiteId;
    private String name;

    public Prerequisite(int prerequisiteId, String name) {
        this.prerequisiteId = prerequisiteId;
        this.name = name;
    }

    public Prerequisite() {
    }

    public int getprerequisiteId() {
        return prerequisiteId;
    }

    public void setprerequisiteId(int prerequisiteId) {
        this.prerequisiteId = prerequisiteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
