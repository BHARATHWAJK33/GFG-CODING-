
class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
           int n = arr.length;
        if (k > n) return -1;

        int low = getMax(arr);
        int high = getSum(arr);
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
    private static boolean isPossible(int[] arr, int k, int maxPages) {
        int students = 1;
        int pages = 0;

        for (int book : arr) {
            if (pages + book > maxPages) {
                students++;
                pages = book;
                if (students > k) return false;
            } else {
                pages += book;
            }
        }

        return true;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
