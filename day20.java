
class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        
        int n = s1.length();
        if (n != s2.length()) return false;

        for (int i = 0; i < n; i++) {
            // Left rotation by i
            String rotated = s1.substring(i) + s1.substring(0, i);
            if (rotated.equals(s2)) return true;
        }
        return false;
}
}
