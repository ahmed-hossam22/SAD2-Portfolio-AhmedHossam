import java.time.LocalDateTime;

public class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    private String status;

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String date, String time) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = "scheduled";
    }

    public String getAppointmentId() { return appointmentId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getStatus() { return status; }


    public void cancel() { status = "cancelled"; }
    public void complete() { status = "done"; }

    @Override
    public String toString() {
        return "Appointment " + appointmentId + " (" + date + " " + time + ") - " + status;
    }
}