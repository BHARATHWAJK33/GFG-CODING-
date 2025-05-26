class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    // Case when all elements between left and right are the same
                    if (arr[left] == arr[right]) {
                        int total = right - left + 1;
                        count += (total * (total - 1)) / 2;
                        break;
                    } else {
                        int l = 1, r = 1;
                        // Count duplicates on the left
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            l++;
                            left++;
                        }
                        // Count duplicates on the right
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            r++;
                            right--;
                        }
                        count += l * r;
                        left++;
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
