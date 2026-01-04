import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppIntegrationTest {

    @Test
    void testCustomerCount() {
        App app = new App(100);
        assertEquals(100, app.getCustomersCount());
    }
}
