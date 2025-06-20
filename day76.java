class Solution {
    double power(double b, int e) {
        // code here
        if (e == 0) return 1.0;

        long exp = e;  // To handle Integer.MIN_VALUE
        if (exp < 0) {
            b = 1 / b;
            exp = -exp;
        }

        double result = 1.0;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result *= b;
            }
            b *= b;
            exp /= 2;
        }

        return result;
    }
}
