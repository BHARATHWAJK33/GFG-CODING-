class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
         int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        // Fill left array
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = arr[i - 1] * left[i - 1];
        }

        // Fill right array
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = arr[i + 1] * right[i + 1];
        }

        // Construct result
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
