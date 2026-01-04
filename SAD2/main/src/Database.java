import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("alice", "password123");
        users.put("bob", "securepass");
    }

    public static String getUserPassword(String username) {
        return users.get(username);
    }
}
