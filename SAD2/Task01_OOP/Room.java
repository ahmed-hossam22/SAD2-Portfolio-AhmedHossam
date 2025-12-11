public class Room {
    private String roomId;
    private String type;
    private boolean occupied = false;
    private Patient assignedPatient = null;

    public Room(String roomId, String type) {
        this.roomId = roomId;
        this.type = type;
    }

    public boolean isOccupied() { return occupied; }

    public boolean assignToPatient(Patient p) {
        if (occupied) return false;
        assignedPatient = p;
        occupied = true;
        p.setRoom(this);
        return true;
    }

    public void freeRoom() {
        if (assignedPatient != null) {
            assignedPatient.setRoom(null);
            assignedPatient = null;
        }
        occupied = false;
    }

    @Override
    public String toString() {
        return "Room " + roomId + " (" + type + ") - " + (occupied ? "Occupied" : "Available");
    }
}