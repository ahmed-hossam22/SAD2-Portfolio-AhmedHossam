import java.util.ArrayList;

public class Doctor extends User {
    private String doctorId;
    private String specialization;
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Prescription> writtenPrescriptions = new ArrayList<>();

    public Doctor(String id, String name, String email, String phone, String specialization) {
        super(id, name, email, phone);
        this.doctorId = "D-" + id;
        this.specialization = specialization;
    }

    public void addAppointment(Appointment a) { appointments.add(a); }


    public Prescription writePrescription(Patient patient, String medicine, String dosage, String duration) {
        Prescription p = new Prescription("RX-" + doctorId, this, patient, medicine, dosage, duration);
        writtenPrescriptions.add(p);
        patient.addPrescription(p);
        patient.getMedicalRecord().addEntry("Prescription: " + medicine + " - " + dosage + " for " + duration);
        return p;
    }

    public void viewPatientRecord(Patient patient) {
        System.out.println("Doctor " + name + " viewing record of " + patient.getName());
        patient.viewMedicalRecord();
    }

    @Override
    public String toString() {
        return "Doctor " + name + " (" + specialization + ")";
    }
}