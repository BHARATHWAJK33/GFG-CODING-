class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
         ArrayList<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // Sort to handle duplicates
        backtrack(chars, used, new StringBuilder(), result);
        return result;
    }

    private void backtrack(char[] chars, boolean[] used, StringBuilder current, ArrayList<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip used characters
            if (used[i]) continue;

            // Skip duplicates: only use the first occurrence in each recursion level
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // Choose
            used[i] = true;
            current.append(chars[i]);

            // Explore
            backtrack(chars, used, current, result);

            // Un-choose
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
    } 
    }
}
