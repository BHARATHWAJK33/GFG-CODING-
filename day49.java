class Solution {
    public int countSubarrays(int arr[], int k) {
        //
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        for (int num : arr) {
            sum += num;

            if (sum == k) {
                count++;
            }

            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
        
    }
}
