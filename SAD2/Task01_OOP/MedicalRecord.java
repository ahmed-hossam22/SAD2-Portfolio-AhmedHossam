import java.util.ArrayList;

public class MedicalRecord {
    private String recordId;
    private Patient patient;
    private ArrayList<String> history = new ArrayList<>();

    public MedicalRecord(Patient patient) {
        this.patient = patient;
        this.recordId = "MR-" + patient.getName().replaceAll(" ", "");
        history.add("Medical record created for " + patient.getName());
    }

    public void addEntry(String entry) {
        history.add(entry);
    }

    public void viewRecord() {
        System.out.println("---- Record (" + recordId + ") ----");
        for (String e : history) {
            System.out.println("- " + e);
        }
        System.out.println("-----------------------------");
    }

    @Override
    public String toString() {
        return "MedicalRecord " + recordId + " for " + patient.getName();
    }
}