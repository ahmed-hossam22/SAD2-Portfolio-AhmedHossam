import java.util.ArrayList;
import java.util.List;

public class DoctorSchedule {
    private List<String> availableTimes;

    public DoctorSchedule() {
        this.availableTimes = new ArrayList<>();
    }

    public DoctorSchedule(List<String> times) {
        this.availableTimes = new ArrayList<>(times);
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public boolean removeTime(String time) {
        return availableTimes.remove(time);
    }

    public void addTime(String time) {
        if (!availableTimes.contains(time)) availableTimes.add(time);
    }

    @Override
    public String toString() {
        if (availableTimes.isEmpty()) return "(no available times)";
        return String.join(", ", availableTimes);
    }
}
