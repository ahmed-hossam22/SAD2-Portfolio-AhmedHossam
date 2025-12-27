public class Prescription {
    private String prescriptionId;
    private Doctor doctor;
    private Patient patient;
    private String medicineName;
    private String dosage;
    private String duration;

    public Prescription(String id, Doctor doctor, Patient patient, String medicineName, String dosage, String duration) {
        this.prescriptionId = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Prescription " + prescriptionId + " - " + medicineName + " for " + patient.getName();
    }
}