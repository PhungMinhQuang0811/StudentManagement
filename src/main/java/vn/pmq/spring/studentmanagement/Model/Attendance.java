package vn.pmq.spring.studentmanagement.Model;

public class Attendance {
    private int attendance_id;

    public Attendance() {
    }

    public Attendance(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }
}
