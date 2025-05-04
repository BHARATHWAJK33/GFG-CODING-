class Solution {

    public  int maxSubarraySum(int[] arr) {
        int maxCurrent = arr[0], maxGlobal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }
    public  int minSubarraySum(int[] arr) {
        int minCurrent = arr[0], minGlobal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minCurrent = Math.min(arr[i], minCurrent + arr[i]);
            minGlobal = Math.min(minGlobal, minCurrent);
        }
        return minGlobal;
    }
    public  int circularSubarraySum(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int maxSum = maxSubarraySum(arr); 
        int minSum = minSubarraySum(arr); 
        if (totalSum == minSum) {
            return maxSum;
        }
        return Math.max(maxSum, totalSum - minSum);
    }
}