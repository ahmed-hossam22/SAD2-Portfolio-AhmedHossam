public class Appointment {
    private int patientID;
    private int doctorID;
    private String time; // e.g. "10:00"

    public Appointment(int patientID, int doctorID, String time) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.time = time;
    }

    public int getPatientID() { return patientID; }
    public int getDoctorID() { return doctorID; }
    public String getTime() { return time; }

    @Override
    public String toString() {
        return "Appointment{patientID=" + patientID + ", doctorID=" + doctorID + ", time='" + time + "'}";
    }
}
