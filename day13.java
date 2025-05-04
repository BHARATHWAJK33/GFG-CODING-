class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
         int n = arr.length;
        int shift = segregate(arr);
        int[] positiveArr = Arrays.copyOfRange(arr, shift, n);
        return findMissingFromPositive(positiveArr);
    }
    private static int segregate(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }
    private static int findMissingFromPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val - 1 < n && arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
