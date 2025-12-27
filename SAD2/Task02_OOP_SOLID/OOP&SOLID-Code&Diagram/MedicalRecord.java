import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    private List<String> entries;

    public MedicalRecord() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(String entry) {
        entries.add(entry);
    }

    public List<String> getEntries() {
        return entries;
    }

    @Override
    public String toString() {
        if (entries.isEmpty()) return "(no medical history)";
        StringBuilder sb = new StringBuilder();
        for (String e : entries) {
            sb.append("- ").append(e).append("\n");
        }
        return sb.toString();
    }
}
