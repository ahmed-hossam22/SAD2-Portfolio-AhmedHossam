import java.time.LocalDate;
import java.util.List;

public class Prescription {
    private int patientID;
    private int doctorID;
    private List<String> medicines;
    private LocalDate date;

    public Prescription(int patientID, int doctorID, List<String> medicines) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.medicines = medicines;
        this.date = LocalDate.now();
    }

    public int getPatientID() { return patientID; }
    public int getDoctorID() { return doctorID; }
    public List<String> getMedicines() { return medicines; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return "Prescription from Dr.ID:" + doctorID + " on " + date + " -> " + String.join(", ", medicines);
    }
}
