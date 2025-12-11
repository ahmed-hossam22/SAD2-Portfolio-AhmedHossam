import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient extends User {
    private MedicalRecord medicalRecord; // composition
    private List<Prescription> prescriptions;
    private List<Appointment> appointments;

    public Patient(String name, int id) {
        super(name, id);
        this.medicalRecord = new MedicalRecord();
        this.prescriptions = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public List<Prescription> getPrescriptions() { return prescriptions; }
    public List<Appointment> getAppointments() { return appointments; }

    public void addPrescription(Prescription p) { prescriptions.add(p); }
    public void addAppointment(Appointment a) { appointments.add(a); }

    // Patient handles booking by showing doctors list and interacting with user.
    // Returns true if booked successfully.
    public boolean bookAppointment(Admin hm, Scanner scanner) {
        List<Doctor> doctors = hm.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return false;
        }
        System.out.println("\n--- Choose a doctor to book with ---");
        for (Doctor d : doctors) {
            System.out.println(d.getId() + ") " + d.getName() + " - " + d.getSpecialization());
            System.out.println("   Available times: " + d.getSchedule());
        }
        System.out.print("Enter doctor ID: ");
        String line = scanner.nextLine().trim();
        int did;
        try { did = Integer.parseInt(line); } catch (Exception e) { System.out.println("Invalid ID."); return false; }
        Doctor chosen = hm.findDoctorById(did);
        if (chosen == null) { System.out.println("Doctor not found."); return false; }
        System.out.println("Available times: " + chosen.getSchedule());
        System.out.print("Enter time from available times (exact, e.g. 10:00): ");
        String time = scanner.nextLine().trim();
        if (!chosen.getSchedule().getAvailableTimes().contains(time)) {
            System.out.println("Selected time not available.");
            return false;
        }
        // create appointment, update patient and doctor, and remove time from schedule
        Appointment ap = new Appointment(this.id, chosen.getId(), time);
        this.addAppointment(ap);
        chosen.addAppointment(ap);
        chosen.getSchedule().removeTime(time);
        System.out.println("Appointment booked at " + time + " with Dr. " + chosen.getName());
        return true;
    }

    public void viewRecord() {
        System.out.println("\n--- Your Medical Record ---");
        System.out.println(this.medicalRecord);
    }

    public void viewPrescriptions() {
        System.out.println("\n--- Your Prescriptions ---");
        if (prescriptions.isEmpty()) { System.out.println("(no prescriptions)"); return; }
        for (Prescription p : prescriptions) System.out.println(p);
    }

    @Override
    public void showMenu() {
        System.out.println("\nPatient Menu for " + name + " (ID: " + id + ")");
        System.out.println("1) Book appointment");
        System.out.println("2) View my medical record");
        System.out.println("3) View my prescriptions");
        System.out.println("4) Logout");
    }

    @Override
    public String toString() {
        return name + " (ID:" + id + ")";
    }
}
