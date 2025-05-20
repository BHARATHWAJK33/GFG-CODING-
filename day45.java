
class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here 
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        // Use another set to store result (intersection)
        Set<Integer> resultSet = new HashSet<>();
        for (int num : b) {
            if (setA.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert result set to ArrayList
        return new ArrayList<>(resultSet);
    }
}
