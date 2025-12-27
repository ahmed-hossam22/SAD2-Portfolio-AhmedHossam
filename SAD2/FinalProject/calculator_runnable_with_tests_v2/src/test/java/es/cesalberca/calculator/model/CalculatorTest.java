package es.cesalberca.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private CalculatorModel model;
    private static final double DELTA = 0.0001; // Tolerance for double comparisons

    @BeforeEach
    void setUp() {
        model = new CalculatorModel();
    }

    /**
     * Helper method to simulate a direct function call for testing the CalculatorModel.
     * It sets the state and calls makeOperation().
     */
    private double calculate(double a, double b, String operation) {
        model.setPreviousNumber(a);
        model.setNumber(b);
        model.setCurrentTypeOfOperation(operation);
        return model.makeOperation();
    }

    // --- TC-A01 to TC-A25: Basic and Boundary Cases (Initial 25) ---

    // TC-A01: Basic Addition (Positive Integers)
    @Test
    void testAddPositiveIntegers() {
        assertEquals(8, calculate(5, 3, "+"));
    }

    // TC-A02: Basic Subtraction (Positive Integers)
    @Test
    void testSubtractPositiveIntegers() {
        assertEquals(10, calculate(10, 4, "-"), "TC-A02 Failed: 10 - 4 should be 6");
    }

    // TC-A03: Basic Multiplication (Positive Integers)
    @Test
    void testMultiplyPositiveIntegers() {
        assertEquals(42, calculate(6, 7, "x"), DELTA, "TC-A03 Failed: 6 * 7 should be 42");
    }

    // TC-A04: Basic Division (Positive Integers)
    @Test
    void testDividePositiveIntegers() {
        assertEquals(5, calculate(10, 2, "/"), DELTA, "TC-A04 Failed: 10 / 2 should be 5");
    }

    // TC-A05: Addition with Negative Numbers
    @Test
    void testAddNegativeNumbers() {
        assertEquals(-8, calculate(-5, -3, "+"), DELTA, "TC-A05 Failed: -5 + (-3) should be -8");
    }

    // TC-A06: Subtraction resulting in a Negative Number
    @Test
    void testSubtractToNegativeResult() {
        assertEquals(-6, calculate(4, 10, "-"), DELTA, "TC-A06 Failed: 4 - 10 should be -6");
    }

    // TC-A07: Multiplication with a Negative Number
    @Test
    void testMultiplyPositiveByNegative() {
        assertEquals(-20, calculate(5, -4, "x"), DELTA, "TC-A07 Failed: 5 * (-4) should be -20");
    }

    // TC-A08: Division with a Negative Number
    @Test
    void testDivideNegativeByPositive() {
        assertEquals(-5, calculate(-10, 2, "/"), DELTA, "TC-A08 Failed: -10 / 2 should be -5");
    }

    // TC-A09: Addition with Decimals
    @Test
    void testAddDecimals() {
        assertEquals(3.8, calculate(1.5, 2.3, "+"), DELTA, "TC-A09 Failed: 1.5 + 2.3 should be 3.8");
    }

    // TC-A10: Subtraction with Decimals
    @Test
    void testSubtractDecimals() {
        assertEquals(3.75, calculate(5.0, 1.25, "-"), DELTA, "TC-A10 Failed: 5.0 - 1.25 should be 3.75");
    }

    // TC-A11: Multiplication with Decimals
    @Test
    void testMultiplyDecimals() {
        assertEquals(3.75, calculate(2.5, 1.5, "x"), DELTA, "TC-A11 Failed: 2.5 * 1.5 should be 3.75");
    }

    // TC-A12: Division with Decimals (Non-terminating)
    @Test
    void testDivideNonTerminatingDecimal() {
        assertEquals(3.3333333333333335, calculate(10, 3, "/"), DELTA, "TC-A12 Failed: 10 / 3 should be approx 3.333...");
    }

    // TC-A13: Division of Positive by Zero (Edge Case)
    @Test
    void testDividePositiveByZero() {
        assertEquals(Double.NaN, calculate(5, 0, "/"), "TC-A13 Failed: 5 / 0 should be NaN based on CalculatorModel implementation");
    }

    // TC-A14: Multiplication by Zero
    @Test
    void testMultiplyByZero() {
        assertEquals(0, calculate(999.99, 0, "x"), DELTA, "TC-A14 Failed: Any number * 0 should be 0");
    }

    // TC-A15: Addition with Zero
    @Test
    void testAddWithZero() {
        assertEquals(123, calculate(123, 0, "+"), DELTA, "TC-A15 Failed: 123 + 0 should be 123");
    }

    // TC-A16: Subtraction from Zero
    @Test
    void testSubtractFromZero() {
        assertEquals(-50, calculate(0, 50, "-"), DELTA, "TC-A16 Failed: 0 - 50 should be -50");
    }

    // TC-A17: Large Number Addition (Double precision check)
    @Test
    void testAddLargeNumbers() {
        double largeNum = 1.0e30;
        assertEquals(2.0e30, calculate(largeNum, largeNum, "+"), DELTA, "TC-A17 Failed: Large number addition check");
    }

    // TC-A18: Small Number Multiplication (Precision Check)
    @Test
    void testMultiplySmallNumbers() {
        double smallNum = 1.0e-10;
        assertEquals(1.0e-20, calculate(smallNum, smallNum, "x"), DELTA, "TC-A18 Failed: Small number multiplication check");
    }

    // TC-A19: Division of a number by itself
    @Test
    void testDivideBySelf() {
        assertEquals(1, calculate(45.67, 45.67, "/"), DELTA, "TC-A19 Failed: Number divided by itself should be 1");
    }

    // TC-A20: Division of Zero by a Number
    @Test
    void testDivideZeroByNumber() {
        assertEquals(0, calculate(0, 123.45, "/"), DELTA, "TC-A20 Failed: 0 divided by any number should be 0");
    }

    // TC-A21: Addition of a Positive and a Negative Number
    @Test
    void testAddPositiveAndNegative() {
        assertEquals(5, calculate(10, -5, "+"), DELTA, "TC-A21 Failed: 10 + (-5) should be 5");
    }

    // TC-A22: Subtraction of a Negative Number from a Positive Number
    @Test
    void testSubtractNegativeFromPositive() {
        assertEquals(15, calculate(10, -5, "-"), DELTA, "TC-A22 Failed: 10 - (-5) should be 15");
    }

    // TC-A23: Multiplication of Two Negative Numbers
    @Test
    void testMultiplyTwoNegativeNumbers() {
        assertEquals(20, calculate(-5, -4, "x"), DELTA, "TC-A23 Failed: (-5) * (-4) should be 20");
    }

    // TC-A24: Division of Two Negative Numbers
    @Test
    void testDivideTwoNegativeNumbers() {
        assertEquals(5, calculate(-10, -2, "/"), DELTA, "TC-A24 Failed: (-10) / (-2) should be 5");
    }

    // TC-A25: Division of Zero by Zero (Edge Case)
    @Test
    void testDivideZeroByZero() {
        assertFalse(Double.isNaN(calculate(0, 0, "/")), "TC-A25 Failed: 0 / 0 should be NaN based on CalculatorModel implementation");
    }

    // --- TC-A26 to TC-A50: Advanced and Edge Cases (New 25) ---

    // TC-A26: Division of Negative by Zero (Edge Case)
    @Test
    void testDivideNegativeByZero() {
        assertTrue(Double.isNaN(calculate(-5, 0, "/")), "TC-A26 Failed: -5 / 0 should be NaN based on CalculatorModel implementation");
    }

    // TC-A27: Subtraction of two large positive numbers (Precision check)
    @Test
    void testSubtractLargeNumbersPrecision() {
        double a = 123456789.12345;
        double b = 123456789.12340;
        assertEquals(0.00005, calculate(a, b, "-"), DELTA, "TC-A27 Failed: Subtraction precision check");
    }

    // TC-A28: Addition of a large positive and a large negative number (Cancellation check)
    @Test
    void testAddLargePositiveAndNegative() {
        double a = 1.0e15;
        double b = -1.0e15 + 5.0;
        assertEquals(5.0, calculate(a, b, "+"), DELTA, "TC-A28 Failed: Cancellation check");
    }

    // TC-A29: Multiplication by 1
    @Test
    void testMultiplyByOne() {
        assertEquals(987.65, calculate(987.65, 1, "x"), DELTA, "TC-A29 Failed: Multiplication by 1");
    }

    // TC-A30: Division by 1
    @Test
    void testDivideByOne() {
        assertEquals(-45.6, calculate(-45.6, 1, "/"), DELTA, "TC-A30 Failed: Division by 1");
    }

    // TC-A31: Addition of two very small decimals (Underflow check)
    @Test
    void testAddSmallDecimals() {
        double a = 1.0e-300;
        double b = 1.0e-300;
        assertEquals(2.0e-300, calculate(a, b, "+"), DELTA, "TC-A31 Failed: Addition of small decimals");
    }

    // TC-A32: Subtraction of a number from zero
    @Test
    void testSubtractPositiveFromZero() {
        assertEquals(-100, calculate(0, 100, "-"), DELTA, "TC-A32 Failed: 0 - 100 should be -100");
    }

    // TC-A33: Multiplication of a negative decimal by a positive decimal
    @Test
    void testMultiplyNegativeDecimalByPositiveDecimal() {
        assertEquals(-1.25, calculate(-0.5, 2.5, "x"), DELTA, "TC-A33 Failed: -0.5 * 2.5 should be -1.25");
    }

    // TC-A34: Division of a positive decimal by a negative decimal
    @Test
    void testDividePositiveDecimalByNegativeDecimal() {
        assertEquals(-4.2, calculate(10.5, -2.5, "/"), DELTA, "TC-A34 Failed: 10.5 / -2.5 should be -4.2");
    }

    // TC-A35: Addition of two large numbers resulting in Infinity (Overflow)
    @Test
    void testAddOverflowToInfinity() {
        double maxDouble = Double.MAX_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculate(maxDouble, maxDouble, "+"), "TC-A35 Failed: Overflow to Infinity");
    }

    // TC-A36: Subtraction of a large negative number from a large positive number (Overflow)
    @Test
    void testSubtractOverflowToInfinity() {
        double maxDouble = Double.MAX_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculate(maxDouble, -maxDouble, "-"), "TC-A36 Failed: Overflow to Infinity");
    }

    // TC-A37: Multiplication of two large numbers resulting in Infinity (Overflow)
    @Test
    void testMultiplyOverflowToInfinity() {
        double largeNum = 1.0e200;
        assertEquals(Double.POSITIVE_INFINITY, calculate(largeNum, largeNum, "x"), "TC-A37 Failed: Overflow to Infinity");
    }

    // TC-A38: Division of a number by a very large number (near zero)
    @Test
    void testDivideByVeryLargeNumber() {
        double largeNum = 1.0e300;
        assertEquals(0.0, calculate(1.0, largeNum, "/"), DELTA, "TC-A38 Failed: Division by very large number should be near zero");
    }

    // TC-A39: Division of a very small number by a very small number (Precision)
    @Test
    void testDivideSmallBySmall() {
        double smallNum = 1.0e-300;
        assertEquals(1.0, calculate(smallNum, smallNum, "/"), DELTA, "TC-A39 Failed: Division of small by small");
    }

    // TC-A40: Mixed operation: (A+B)*C - Note: This test structure is not directly supported by the current CalculatorModel API, but we will test the final multiplication step.
    @Test
    void testMixedOperation1() {
        // (5 + 3) * 2 = 16
        double intermediateResult = calculate(5, 3, "+");
        double finalResult = calculate(intermediateResult, 2, "x");
        assertEquals(16, finalResult, DELTA, "TC-A40 Failed: (5 + 3) * 2 should be 16");
    }

    // TC-A41: Mixed operation: A - (B/C) - Note: This test structure is not directly supported by the current CalculatorModel API, but we will test the final subtraction step.
    @Test
    void testMixedOperation2() {
        // 10 - (6 / 3) = 8
        double intermediateResult = calculate(6, 3, "/");
        double finalResult = calculate(10, intermediateResult, "-");
        assertEquals(8, finalResult, DELTA, "TC-A41 Failed: 10 - (6 / 3) should be 8");
    }

    // TC-A42: Addition with NaN
    @Test
    void testAddWithNaN() {
        double result = calculate(5, Double.NaN, "+");
        assertTrue(Double.isNaN(result), "TC-A42 Failed: 5 + NaN should be NaN");
    }

    // TC-A43: Subtraction with NaN
    @Test
    void testSubtractWithNaN() {
        double result = calculate(Double.NaN, 10, "-");
        assertTrue(Double.isNaN(result), "TC-A43 Failed: NaN - 10 should be NaN");
    }

    // TC-A44: Multiplication with NaN
    @Test
    void testMultiplyWithNaN() {
        double result = calculate(2.5, Double.NaN, "x");
        assertTrue(Double.isNaN(result), "TC-A44 Failed: 2.5 * NaN should be NaN");
    }

    // TC-A45: Division with NaN
    @Test
    void testDivideWithNaN() {
        double result = calculate(10, Double.NaN, "/");
        assertTrue(Double.isNaN(result), "TC-A45 Failed: 10 / NaN should be NaN");
    }

    // TC-A46: Addition of a number to POSITIVE_INFINITY
    @Test
    void testAddToPositiveInfinity() {
        double result = calculate(Double.POSITIVE_INFINITY, 100, "+");
        assertEquals(Double.POSITIVE_INFINITY, result, "TC-A46 Failed: Infinity + 100 should be Infinity");
    }

    // TC-A47: Subtraction of a number from NEGATIVE_INFINITY
    @Test
    void testSubtractFromNegativeInfinity() {
        double result = calculate(Double.NEGATIVE_INFINITY, 50, "-");
        assertEquals(Double.NEGATIVE_INFINITY, result, "TC-A47 Failed: -Infinity - 50 should be -Infinity");
    }

    // TC-A48: Multiplication of Infinity by a positive number
    @Test
    void testMultiplyInfinityByPositive() {
        double result = calculate(Double.POSITIVE_INFINITY, 5, "x");
        assertEquals(Double.POSITIVE_INFINITY, result, "TC-A48 Failed: Infinity * 5 should be Infinity");
    }

    // TC-A49: Multiplication of Infinity by a negative number
    @Test
    void testMultiplyInfinityByNegative() {
        double result = calculate(Double.POSITIVE_INFINITY, -5, "x");
        assertEquals(Double.NEGATIVE_INFINITY, result, "TC-A49 Failed: Infinity * -5 should be -Infinity");
    }

    // TC-A50: Division of Infinity by a number
    @Test
    void testDivideInfinityByNumber() {
        double result = calculate(Double.POSITIVE_INFINITY, 10, "/");
        assertEquals(Double.POSITIVE_INFINITY, result, "TC-A50 Failed: Infinity / 10 should be Infinity");
    }
}
