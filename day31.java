class Solution {

    public int peakElement(int[] arr) {
        // code here
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean left = true;
            boolean right = true;
            if (i > 0 && arr[i] <= arr[i - 1])
                left = false;
            if (i < n - 1 && arr[i] <= arr[i + 1])
                right = false;
            if (left && right) {
                return i;
            }
        }
        return 0;
    }
}
