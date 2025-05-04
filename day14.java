class Solution {
    public int myAtoi(String s) {
        // Your code here
         int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        int idx = 0;
        int n = s.length();
        int sign = 1;
        long result = 0;
        while (idx < n && s.charAt(idx) == ' ') {
            idx++;
        }
        if (idx < n && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            sign = (s.charAt(idx) == '-') ? -1 : 1;
            idx++;
        }
        while (idx < n && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            int digit = s.charAt(idx) - '0';
            result = result * 10 + digit;
            if (sign == 1 && result > INT_MAX) {
                return INT_MAX;
            }
            if (sign == -1 && -result < INT_MIN) {
                return INT_MIN;
            }

            idx++;
        }

        return (int) (sign * result);
    }
}
