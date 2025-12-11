import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Admin hm = new Admin();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        seedSampleData();

        while (true) {
            System.out.println("\n=====================================");
            System.out.println("   Welcome to Hospital System");
            System.out.println("=====================================");
            System.out.println("Select User Type:");
            System.out.println("1) Doctor");
            System.out.println("2) Patient");
            System.out.println("3) Admin");
            System.out.println("4) Exit");
            System.out.print("Enter choice: ");

            String choiceLine = input.nextLine().trim();
            if (choiceLine.isEmpty()) continue;
            int choice;
            try { choice = Integer.parseInt(choiceLine); } catch (Exception e) { System.out.println("Invalid."); continue; }

            switch (choice) {
                case 1: doctorLoginFlow(); break;
                case 2: patientLoginFlow(); break;
                case 3: hm.managementMenu(); break;
                case 4: System.out.println("Exiting. Bye."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void doctorLoginFlow() {
        System.out.print("Enter doctor name: ");
        String name = input.nextLine().trim();
        System.out.print("Enter doctor ID: ");
        int id;
        try { id = Integer.parseInt(input.nextLine().trim()); } catch (Exception e) { System.out.println("Invalid ID."); return; }
        Doctor doc = hm.findDoctorById(id);
        if (doc != null && doc.getName().equalsIgnoreCase(name)) {
            doctorSession(doc);
        } else {
            System.out.println("Doctor not found or name/ID mismatch.");
        }
    }

    private static void doctorSession(Doctor doc) {
        while (true) {
            doc.showMenu();
            System.out.print("Enter choice: ");
            int c;
            try { c = Integer.parseInt(input.nextLine().trim()); } catch (Exception e) { System.out.println("Invalid."); continue; }
            switch (c) {
                case 1: doc.viewPatients(hm); break;
                case 2:
                    System.out.print("Enter patient ID to write prescription for: ");
                    int pid; try { pid = Integer.parseInt(input.nextLine().trim()); } catch (Exception e) { System.out.println("Invalid."); break; }
                    Patient p = hm.findPatientById(pid);
                    if (p == null) { System.out.println("Patient not found."); break; }
                    System.out.println("Enter medicines separated by comma: ");
                    String medsLine = input.nextLine();
                    List<String> meds = new ArrayList<>();
                    for (String s : medsLine.split(",")) { if (!s.trim().isEmpty()) meds.add(s.trim()); }
                    Prescription pr = doc.writePrescription(p.getId(), meds);
                    p.addPrescription(pr);
                    System.out.print("Add a short diagnosis/note for medical record? (y/n): ");
                    String ans = input.nextLine().trim();
                    if (ans.equalsIgnoreCase("y")) {
                        System.out.print("Enter diagnosis/note: ");
                        String note = input.nextLine().trim();
                        p.getMedicalRecord().addEntry(note);
                    }
                    System.out.println("Prescription added.");
                    break;
                case 3:
                    System.out.print("Enter patient ID to view records: ");
                    int pid2; try { pid2 = Integer.parseInt(input.nextLine().trim()); } catch (Exception e) { System.out.println("Invalid."); break; }
                    doc.viewPatientMedicalRecord(pid2, hm);
                    break;
                default: return;
            }
        }
    }

    private static void patientLoginFlow() {
        System.out.print("Enter patient name: ");
        String name = input.nextLine().trim();
        System.out.print("Enter patient ID: ");
        int id;
        try { id = Integer.parseInt(input.nextLine().trim()); } catch (Exception e) { System.out.println("Invalid ID."); return; }
        Patient pat = hm.findPatientById(id);
        if (pat != null && pat.getName().equalsIgnoreCase(name)) {
            patientSession(pat);
        } else {
            System.out.println("Patient not found or name/ID mismatch.");
        }
    }

    private static void patientSession(Patient pat) {
        while (true) {
            pat.showMenu();
            System.out.print("Enter choice: ");
            int c;
            try { c = Integer.parseInt(input.nextLine().trim()); } catch (Exception e) { System.out.println("Invalid."); continue; }
            switch (c) {
                case 1:
                    boolean ok = pat.bookAppointment(hm, input);
                    if (ok) System.out.println("Booked successfully.");
                    else System.out.println("Booking failed.");
                    break;
                case 2:
                    pat.viewRecord();
                    break;
                case 3:
                    pat.viewPrescriptions();
                    break;
                default: return;
            }
        }
    }

    private static void seedSampleData() {
        List<String> times1 = new ArrayList<>();
        times1.add("10:00"); times1.add("12:00"); times1.add("14:00");
        Doctor d1 = new Doctor("Ahmed", 101, "Cardiology", times1);
        hm.addDoctor(d1);

        List<String> times2 = new ArrayList<>();
        times2.add("09:00"); times2.add("11:00"); times2.add("15:00");
        Doctor d2 = new Doctor("Mona", 102, "Dermatology", times2);
        hm.addDoctor(d2);

        Patient p1 = new Patient("Omar", 201);
        hm.addPatient(p1);

        Patient p2 = new Patient("Sara", 202);
        hm.addPatient(p2);
    }
}
