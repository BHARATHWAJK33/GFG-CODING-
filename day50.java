class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
         int count = 0;
        int prefixXor = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            prefixXor ^= num;

            // Case 1: XOR from beginning is k
            if (prefixXor == k) {
                count++;
            }

            // Case 2: prefixXor ^ k exists in map
            int required = prefixXor ^ k;
            if (freqMap.containsKey(required)) {
                count += freqMap.get(required);
            }

            // Update frequency map
            freqMap.put(prefixXor, freqMap.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}
