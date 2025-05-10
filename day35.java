
class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int missingCount = 0;
        int current = 1;
        int i = 0;

        while (true) {
            if (i < arr.length && arr[i] == current) {
                i++;
            } else {
                missingCount++;
                if (missingCount == k) {
                    return current;
                }
            }
            current++;
        }
    }
}
