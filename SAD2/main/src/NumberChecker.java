public class NumberChecker {

    public static boolean checkNumber(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }

        if (n == 0) {
            return false;
        }

        return n % 2 == 0;
    }
}
