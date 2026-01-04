import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class Booktest {

    static Book book1;
    static Book book2;

    // 🔹 Runs ONCE before all tests
    @BeforeAll
    static void setUpClass() {
        System.out.println("setUpClass method: Runs before all tests...");
    }

    // 🔹 Runs BEFORE EACH test
    @BeforeEach
    void setUp() {
        System.out.println("Running setUp method...");
        book1 = new Book("Deep Work", 304, 15.0, 0.05);
        book2 = new Book("Grit", 447, 16.0, 0.15);
    }

    // 🔹 Test getReadingTime()
    @Test
    void testReadingTime() {
        System.out.println("Running testReadingTime...");
        assertEquals(304 / 5, book1.getReadingTime());
        assertEquals(447 / 5, book2.getReadingTime());
    }

    // 🔹 Test applyDiscount()
    @Test
    void testDiscount() {
        System.out.println("Running testDiscount...");
        assertEquals(15 - (15 * 0.05), book1.applyDiscount());
        assertEquals(16 - (16 * 0.15), book2.applyDiscount());
    }

    // 🔹 Runs AFTER EACH test
    @AfterEach
    void tearDown() {
        System.out.println("Running tearDown method...");
    }

    // 🔹 Runs ONCE after all tests
    @AfterAll
    static void tearDownClass() {
        System.out.println("tearDownClass method: Runs after all tests...");
    }
}
