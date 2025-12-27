import java.util.ArrayList;

public class Nurse extends User {
    private String nurseId;
    private ArrayList<Patient> assignedPatients = new ArrayList<>();

    public Nurse(String id, String name, String email, String phone) {
        super(id, name, email, phone);
        this.nurseId = "N-" + id;
    }

    public void assignPatient(Patient p) {
        if (!assignedPatients.contains(p)) assignedPatients.add(p);
    }

    public void recordVitals(Patient p, String vitals) {
        System.out.println("Nurse " + name + " recorded vitals for " + p.getName() + ": " + vitals);
        p.getMedicalRecord().addEntry("Vitals by Nurse " + name + ": " + vitals);
    }

    @Override
    public String toString() {
        return "Nurse " + name + " (" + nurseId + ")";
    }
}