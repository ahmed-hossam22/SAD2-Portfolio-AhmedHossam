import java.util.ArrayList;

public class HospitalManagement {
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();

    public void addPatient(Patient p) { patients.add(p); }
    public void addDoctor(Doctor d) { doctors.add(d); }
    public void addNurse(Nurse n) { nurses.add(n); }
    public void addAdmin(Admin a) { admins.add(a); }
    public void addRoom(Room r) { rooms.add(r); }



    public void listPatients() {
        System.out.println("---- Patients ----");
        for (Patient p : patients) System.out.println(p);
    }

    public void listDoctors() {
        System.out.println("---- Doctors ----");
        for (Doctor d : doctors) System.out.println(d);
    }

    public void listRooms() {
        System.out.println("---- Rooms ----");
        for (Room r : rooms) System.out.println(r);
    }
    public void addAppointment(Appointment a) { appointments.add(a); }

    public Patient findPatientById(String id) {
        for (Patient p : patients) if (p.getId().equals(id) || ("P-"+p.getId()).equals(id)) return p;
        return null;
    }

    public Doctor findDoctorById(String id) {
        for (Doctor d : doctors) if (d.getId().equals(id) || ("D-"+d.getId()).equals(id)) return d;
        return null;
    }

    public void listAppointments() {
        System.out.println("---- Appointments ----");
        for (Appointment a : appointments) System.out.println(a);
    }

}
