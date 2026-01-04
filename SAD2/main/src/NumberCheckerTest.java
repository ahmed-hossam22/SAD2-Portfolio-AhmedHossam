import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NumberCheckerTest {

    // 1️⃣ رقم زوجي موجب → true
    @Test
    void testEvenPositiveNumber() {
        assertTrue(NumberChecker.checkNumber(4));
    }

    // 2️⃣ رقم فردي موجب → false
    @Test
    void testOddPositiveNumber() {
        assertFalse(NumberChecker.checkNumber(5));
    }

    // 3️⃣ صفر → false
    @Test
    void testZero() {
        assertEquals(true, NumberChecker.checkNumber(0) , "Test Failed");
    }

    // 4️⃣ رقم سالب → Exception
    @Test
    void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumberChecker.checkNumber(-5);
        });
    }

    // 5️⃣ رقم زوجي كبير → true
    @Test
    void testLargeEvenNumber() {
        assertEquals(true, NumberChecker.checkNumber(100));
    }

    // ===============================
    // Test واحد فيه كذا assert (زي السلايد)
    // ===============================
    @Test
    void testAllCasesInOneMethod() {

        // even positive
        assertTrue(NumberChecker.checkNumber(4));

        // odd positive
        assertFalse(NumberChecker.checkNumber(5));

        // zero
        assertFalse(NumberChecker.checkNumber(0));

        // large even
        assertTrue(NumberChecker.checkNumber(100));

        // negative → exception
        assertThrows(IllegalArgumentException.class, () -> {
            NumberChecker.checkNumber(-3);
        });
    }
}
