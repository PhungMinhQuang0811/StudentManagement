package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomId;
    @Column(name = "room_code",length = 5,nullable = false)
    private String roomCode;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinTable(
            name = "room_schedule",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    private List<Schedule> schedules;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id",nullable = false)
    private Status status;

    public Room() {
    }

    public Room(int roomId, String roomCode) {
        this.roomId = roomId;
        this.roomCode = roomCode;
    }

    public int getroomId() {
        return roomId;
    }

    public void setroomId(int roomId) {
        this.roomId = roomId;
    }

    public String getroomCode() {
        return roomCode;
    }

    public void setroomCode(String roomCode) {
        this.roomCode = roomCode;
    }
}
