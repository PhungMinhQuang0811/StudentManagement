package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private int scheduleId;
    @Column(name = "time_table")
    private Timestamp timeTable;
    @Column(name = "slot")
    private int slot;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinTable(
            name = "class_schedule",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<Class> classes;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinTable(
            name = "room_schedule",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> rooms;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id",nullable = false)
    private Status status;

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
