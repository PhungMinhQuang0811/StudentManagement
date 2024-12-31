package vn.pmq.spring.studentmanagement.Model;

public class Room {
    private int roomId;
    private String roomCode;

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
