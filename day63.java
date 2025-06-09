class Solution {
    public int maxLen(int[] nums) {
        // Your code here
         for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] == 0) ? -1 : 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLength = 0;

        // Initialize the map with sum 0 at index -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
