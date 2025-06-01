class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
         ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // Add the current element to the map
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);

            // When the window size exceeds k, remove the oldest element
            if (i >= k) {
                int old = arr[i - k];
                freqMap.put(old, freqMap.get(old) - 1);
                if (freqMap.get(old) == 0) {
                    freqMap.remove(old);
                }
            }

            // Add the count of distinct elements once the first full window is ready
            if (i >= k - 1) {
                result.add(freqMap.size());
            }
        }

        return result;
    }
}
