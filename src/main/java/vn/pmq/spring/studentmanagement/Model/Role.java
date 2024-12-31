package vn.pmq.spring.studentmanagement.Model;

public class Role {
    private int roleId;
    private String name;

    public Role(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public int getroleId() {
        return roleId;
    }

    public void setroleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role() {
    }
}
