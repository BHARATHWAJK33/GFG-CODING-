class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0;
            int sum = bit1 + bit2 + carry;
            carry = sum / 2;
            result.append(sum % 2);
            i--;
            j--;
        }
        result.reverse();
        int k = 0;
        while (k < result.length() && result.charAt(k) == '0') {
            k++;
        }
        if (k == result.length()) {
            return "0";
        }
        return result.substring(k);
    }
}
