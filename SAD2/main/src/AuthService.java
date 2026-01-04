public class AuthService {

    public static String signIn(String username, String password) {
        String storedPassword = Database.getUserPassword(username);

        if (storedPassword == null) {
            return "User not found";
        } else if (storedPassword.equals(password)) {
            return "Login successful";
        } else {
            return "Invalid password";
        }
    }
}
