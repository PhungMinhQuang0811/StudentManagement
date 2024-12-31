package vn.pmq.spring.studentmanagement.Model;

import java.sql.Timestamp;

public class Schedule {
    private int scheduleId;
    private Timestamp timeTable;
    private int slot;

    public Schedule() {
    }

    public Schedule(int scheduleId, Timestamp timeTable, int slot) {
        this.scheduleId = scheduleId;
        this.timeTable = timeTable;
        this.slot = slot;
    }

    public int getscheduleId() {
        return scheduleId;
    }

    public void setscheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Timestamp gettimeTable() {
        return timeTable;
    }

    public void settimeTable(Timestamp timeTable) {
        this.timeTable = timeTable;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
