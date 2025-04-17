class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
         if (arr == null || arr.length == 0) return 0;

        int maxProduct = arr[0];
        int currMax = arr[0];
        int currMin = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = currMax;

            currMax = Math.max(Math.max(arr[i], currMax * arr[i]), currMin * arr[i]);
            currMin = Math.min(Math.min(arr[i], temp * arr[i]), currMin * arr[i]);

            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
        
    }
}