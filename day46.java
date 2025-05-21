class Solution {
    public static int findUnion(int a[], int b[]) {
        // code here
        Set<Integer> unionSet = new HashSet<>();

        // Add elements of first array
        for (int num : a) {
            unionSet.add(num);
        }

        // Add elements of second array
        for (int num : b) {
            unionSet.add(num);
        }

        // Return the number of distinct elements
        return unionSet.size();
    }
}
