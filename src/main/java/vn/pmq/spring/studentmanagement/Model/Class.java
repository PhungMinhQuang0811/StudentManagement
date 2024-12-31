package vn.pmq.spring.studentmanagement.Model;

public class Class {
    private int class_id;
    private String class_code;

    public Class() {
    }

    public Class(int class_id, String class_code) {
        this.class_id = class_id;
        this.class_code = class_code;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }
}
