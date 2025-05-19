class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
         Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;
            // If complement exists in map, it forms valid pairs with current number
            count += freq.getOrDefault(complement, 0);
            // Update the frequency of current number
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
