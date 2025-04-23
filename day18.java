
class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
     
        ArrayList<Integer> result = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            if (txt.substring(i, i + m).equals(pat)) {
                result.add(i);
            }
        }

        return result;
    }
}
