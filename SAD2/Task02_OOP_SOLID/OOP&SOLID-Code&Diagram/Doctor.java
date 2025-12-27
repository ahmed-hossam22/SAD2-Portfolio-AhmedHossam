import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {
    private String specialization;
    private Schedule schedule;
    private List<Integer> patientIds; // ids of patients seen

    public Doctor(String name, int id, String specialization, List<String> times) {
        super(name, id);
        this.specialization = specialization;
        this.schedule = new SimpleSchedule(times);
        this.patientIds = new ArrayList<>();
    }

    public String getSpecialization() { return specialization; }
    public Schedule getSchedule() { return schedule; }

    public void addAppointment(Appointment a) {
        if (!patientIds.contains(a.getPatientID())) patientIds.add(a.getPatientID());
    }

    // Doctor writes a prescription and returns it (caller stores it)
    public Prescription writePrescription(int patientId, List<String> medicines) {
        return new Prescription(patientId, this.id, medicines);
    }

    // Doctor views list of his patients using Admin to resolve ids
    public void viewPatients(Admin hm) {
        if (patientIds.isEmpty()) {
            System.out.println("No patients assigned yet.");
            return;
        }
        System.out.println("Patients of Dr. " + name + ":");
        for (Integer pid : patientIds) {
            Patient p = hm.findPatientById(pid);
            if (p != null) System.out.println(" - " + p);
        }
    }

    // Doctor views a patient's medical record
    public void viewPatientMedicalRecord(int patientId, Admin hm) {
        Patient p = hm.findPatientById(patientId);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.println("Medical record for " + p.getName() + ":");
        System.out.println(p.getMedicalRecord());
    }

    @Override
    public void showMenu() {
        System.out.println("\nDoctor Menu for " + name + " (ID: " + id + ")");
        System.out.println("1) View my patients");
        System.out.println("2) Write prescription");
        System.out.println("3) View a patient's medical record");
        System.out.println("4) Logout");
    }

    @Override
    public String toString() {
        return name + " (ID:" + id + ") - " + specialization;
    }
}
