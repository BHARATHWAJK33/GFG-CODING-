class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
       LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

        for (String word : arr) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (ArrayList<String> group : map.values()) {
            result.add(group);
        }

        return result;
    }
}
