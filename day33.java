class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
          Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid;   // possible, try for bigger min distance
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

        // code here
        private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1;
        int lastPlaced = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= dist) {
                count++;
                lastPlaced = stalls[i];
            }
            if (count == k) return true;
        }
        
        return false;
    }
      
}
