import java.util.ArrayList;

public class Patient extends User {
    private String patientId;
    private MedicalRecord medicalRecord;
    private Room room;
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Prescription> prescriptions = new ArrayList<>();

    public Patient(String id, String name, String email, String phone) {
        super(id, name, email, phone);
        this.patientId = "P-" + id;
        this.medicalRecord = new MedicalRecord(this);
    }

    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    public void addAppointment(Appointment a) { appointments.add(a); }
    public void addPrescription(Prescription p) { prescriptions.add(p); }

    public void viewMedicalRecord() {
        System.out.println("Medical record for " + name + ":");
        medicalRecord.viewRecord();
    }

    @Override
    public String toString() {
        return "Patient " + name + " (" + patientId + ")";
    }
}