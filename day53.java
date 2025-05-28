class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
           List<Integer> result = new ArrayList<>();
        int n = arr.length;

        if (n < 2) return result; // If array has fewer than 2 elements, return empty list

        Arrays.sort(arr); // Sort the array to use two-pointer approach

        int left = 0, right = n - 1;
        int closestDiff = Integer.MAX_VALUE;
        int maxAbsDiff = -1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum - target);
            int absDiff = Math.abs(arr[left] - arr[right]);

            if (diff < closestDiff || (diff == closestDiff && absDiff > maxAbsDiff)) {
                // Update closest pair
                result.clear();
                result.add(arr[left]);
                result.add(arr[right]);
                closestDiff = diff;
                maxAbsDiff = absDiff;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
