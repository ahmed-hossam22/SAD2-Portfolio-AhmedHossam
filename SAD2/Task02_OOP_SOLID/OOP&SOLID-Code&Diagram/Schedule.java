import java.util.List;

public interface Schedule {
    List<String> getAvailableTimes();
    boolean removeTime(String time);
    void addTime(String time);
    String toString();
}
