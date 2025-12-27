import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {

    // SRP: ID validation delegated to IdValidator
    private IdValidator validator = new IdValidator();

    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    private Scanner input = new Scanner(System.in);

    // ----------------------------------------------------
    // CRUD OPERATIONS
    // ----------------------------------------------------

    public boolean addDoctor(Doctor d) {
        if (d == null) return false;

        // Validation using IdValidator
        if (validator.doctorIdExists(d.getId(), doctors)) return false;

        doctors.add(d);
        return true;
    }

    public boolean removeDoctor(int id) {
        Doctor d = findDoctorById(id);
        if (d == null) return false;

        doctors.remove(d);
        return true;
    }

    public boolean addPatient(Patient p) {
        if (p == null) return false;

        // Validation using IdValidator
        if (validator.patientIdExists(p.getId(), patients)) return false;

        patients.add(p);
        return true;
    }

    public boolean removePatient(int id) {
        Patient p = findPatientById(id);
        if (p == null) return false;

        patients.remove(p);
        return true;
    }

    // ----------------------------------------------------
    // FIND METHODS
    // ----------------------------------------------------

    public Doctor findDoctorById(int id) {
        for (Doctor d : doctors)
            if (d.getId() == id) return d;
        return null;
    }

    public Patient findPatientById(int id) {
        for (Patient p : patients)
            if (p.getId() == id) return p;
        return null;
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors);
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    // ----------------------------------------------------
    // MANAGEMENT MENU
    // ----------------------------------------------------

    public void managementMenu() {
        while (true) {
            System.out.println("\n--- Hospital Management ---");
            System.out.println("1) Add Doctor");
            System.out.println("2) Remove Doctor");
            System.out.println("3) List Doctors");
            System.out.println("4) Add Patient");
            System.out.println("5) Remove Patient");
            System.out.println("6) List Patients");
            System.out.println("7) Back to Main Menu");
            System.out.print("Enter choice: ");
            int c = safeNextInt();

            switch (c) {
                case 1: flowAddDoctor(); break;
                case 2: flowRemoveDoctor(); break;
                case 3: listDoctors(); break;
                case 4: flowAddPatient(); break;
                case 5: flowRemovePatient(); break;
                case 6: listPatients(); break;
                default: return;
            }
        }
    }

    // ----------------------------------------------------
    // FLOWS
    // ----------------------------------------------------

    private void flowAddDoctor() {
        System.out.print("Enter doctor name: ");
        String name = safeNextLine();

        System.out.print("Enter doctor ID: ");
        int id = safeNextInt();

        if (id <= 0) {
            System.out.println("ID must be positive.");
            return;
        }

        if (validator.doctorIdExists(id, doctors)) {
            System.out.println("Doctor ID already exists.");
            return;
        }

        System.out.print("Enter specialization: ");
        String spec = safeNextLine();

        System.out.println("Enter available times (comma separated): (eg. 12:00 , eg. 24:00)");
        List<String> times = parseTimes(safeNextLine());

        Doctor d = new Doctor(name, id, spec, times);
        addDoctor(d);

        System.out.println("Doctor added.");
    }

    private void flowRemoveDoctor() {
        System.out.print("Enter doctor ID: ");
        int id = safeNextInt();

        if (removeDoctor(id)) System.out.println("Doctor removed.");
        else System.out.println("Doctor not found.");
    }

    private void flowAddPatient() {
        System.out.print("Enter patient name: ");
        String name = safeNextLine();

        System.out.print("Enter patient ID: ");
        int id = safeNextInt();

        if (id <= 0) {
            System.out.println("ID must be positive.");
            return;
        }

        if (validator.patientIdExists(id, patients)) {
            System.out.println("Patient ID already exists.");
            return;
        }

        Patient p = new Patient(name, id);
        addPatient(p);

        System.out.println("Patient added.");
    }

    private void flowRemovePatient() {
        System.out.print("Enter patient ID: ");
        int id = safeNextInt();

        if (removePatient(id)) System.out.println("Patient removed.");
        else System.out.println("Patient not found.");
    }

    // ----------------------------------------------------
    // LISTS
    // ----------------------------------------------------

    private void listDoctors() {
        System.out.println("\n--- Doctors ---");
        if (doctors.isEmpty()) {
            System.out.println("(none)");
            return;
        }

        for (Doctor d : doctors) {
            System.out.println(d);
            System.out.println("Available times: " + d.getSchedule());
            System.out.println("------------------");
        }
    }

    private void listPatients() {
        System.out.println("\n--- Patients ---");
        if (patients.isEmpty()) {
            System.out.println("(none)");
            return;
        }

        for (Patient p : patients)
            System.out.println(p);
    }

    // ----------------------------------------------------
    // INPUT HELPERS
    // ----------------------------------------------------

    private int safeNextInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (Exception ex) {
                System.out.print("Invalid input. Try again: ");
            }
        }
    }

    private String safeNextLine() {
        return input.nextLine().trim();
    }

    private List<String> parseTimes(String line) {
        List<String> list = new ArrayList<>();
        for (String part : line.split(",")) {
            String t = part.trim();
            if (!t.isEmpty()) list.add(t);
        }
        return list;
    }
}
