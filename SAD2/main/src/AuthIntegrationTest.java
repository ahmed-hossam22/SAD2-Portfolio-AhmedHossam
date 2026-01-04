import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AuthIntegrationTest {

    @Test
    void testSuccessLogin() {
        assertEquals("Login successful",
                AuthService.signIn("alice", "password123"));
    }

    @Test
    void testWrongPassword() {
        assertEquals("Invalid password",
                AuthService.signIn("alice", "wrongpass"));
    }

    @Test
    void testUserNotFound() {
        assertEquals("User not found",
                AuthService.signIn("charlie", "nopass"));
    }
}
