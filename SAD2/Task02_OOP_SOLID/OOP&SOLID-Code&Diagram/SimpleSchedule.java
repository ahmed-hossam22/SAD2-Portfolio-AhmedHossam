import java.util.ArrayList;
import java.util.List;

public class SimpleSchedule implements Schedule {
    private List<String> availableTimes;

    public SimpleSchedule() {
        this.availableTimes = new ArrayList<>();
    }

    public SimpleSchedule(List<String> times) {
        this.availableTimes = new ArrayList<>(times);
    }

    @Override
    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    @Override
    public boolean removeTime(String time) {
        return availableTimes.remove(time);
    }

    @Override
    public void addTime(String time) {
        if (!availableTimes.contains(time)) availableTimes.add(time);
    }

    @Override
    public String toString() {
        if (availableTimes.isEmpty()) return "(no available times)";
        return String.join(", ", availableTimes);
    }
}
