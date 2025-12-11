
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalManagement hm = new HospitalManagement();

        // Seed some data
        Patient p1 = new Patient("001", "Ali Mohamed", "ali@gmail.com", "0100000001");

        Doctor d1 = new Doctor("101", "Hossam", "hossam@gmail.com", "0111111111", "Cardiology");
        Doctor d2 = new Doctor("102", "Ahmed", "ahmed@gmail.com", "0111111112", "Neurology");
        Doctor d3 = new Doctor("103", "Mohamed", "mohamed@gmail.com", "0111111113", "Pulmonology");
        Doctor d4 = new Doctor("104", "Malak", "malak@gmail.com", "0111111114", "Gastroenterology");

        Nurse n1 = new Nurse("201", "Nour", "nour@gmail.com", "0122222222");
        Admin a1 = new Admin("301", "Mona", "mona@gmail.com", "0133333333");

        hm.addPatient(p1);
        hm.addDoctor(d4);
        hm.addNurse(n1);
        hm.addAdmin(a1);
        hm.addRoom(new Room("R-1", "General"));
        hm.addRoom(new Room("R-2", "ICU"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Book Appointment");
            System.out.println("3. Write Prescription");
            System.out.println("4. View Patients");
            System.out.println("5. View Appointments");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter id: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine().trim();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine().trim();
                    Patient p = new Patient(id, name, email, phone);
                    hm.addPatient(p);
                    System.out.println("Patient added: " + p);
                    break;
                case "2":
                    System.out.println("Choose patient by id (or enter id):");
                    hm.listPatients();
                    System.out.print("Patient id: ");
                    String pid = sc.nextLine().trim();
                    Patient sp = hm.findPatientById(pid);
                    if (sp == null) {
                        System.out.println("Patient not found.");
                        break;
                    }
                    System.out.println("Choose doctor by id (or enter id):");
                    hm.listDoctors();
                    System.out.print("Doctor id: ");
                    String did = sc.nextLine().trim();
                    Doctor sd = hm.findDoctorById(did);
                    if (sd == null) {
                        System.out.println("Doctor not found.");
                        break;
                    }
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine().trim();
                    System.out.print("Time (HH:MM): ");
                    String time = sc.nextLine().trim();


                    Random random = new Random();
                    int randomNumber = 100 + random.nextInt(900); // يولد رقم من 100 إلى 999
                    String aid = "A-" + randomNumber;

                    System.out.println(aid);

                    Appointment a = new Appointment(aid, sp, sd, date, time);
                    sp.addAppointment(a);
                    sd.addAppointment(a);
                    hm.addAppointment(a);
                    System.out.println("Appointment booked: " + a);
                    break;
                case "3":
                    System.out.println("Choose doctor by id:");
                    hm.listDoctors();
                    System.out.print("Doctor id: ");
                    String docId = sc.nextLine().trim();
                    Doctor doc = hm.findDoctorById(docId);
                    if (doc == null) { System.out.println("Doctor not found."); break; }
                    System.out.println("Choose patient by id:");
                    hm.listPatients();
                    System.out.print("Patient id: ");
                    String patId = sc.nextLine().trim();
                    Patient pat = hm.findPatientById(patId);
                    if (pat == null) { System.out.println("Patient not found."); break; }
                    System.out.print("Medicine name: ");
                    String med = sc.nextLine().trim();
                    System.out.print("Dosage: ");
                    String dosage = sc.nextLine().trim();
                    System.out.print("Duration: ");
                    String duration = sc.nextLine().trim();
                    doc.writePrescription(pat, med, dosage, duration);
                    System.out.println("Prescription written.");
                    break;
                case "4":
                    hm.listPatients();
                    break;
                case "5":
                    hm.listAppointments();
                    break;
                case "6":
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
