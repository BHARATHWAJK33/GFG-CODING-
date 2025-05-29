class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int left = 0, right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                if (arr[left] == arr[right]) {
                    int n = right - left + 1;
                    count += (n * (n - 1)) / 2;
                    break;
                } else {
                    int leftVal = arr[left];
                    int rightVal = arr[right];
                    int lCount = 0, rCount = 0;

                    while (left <= right && arr[left] == leftVal) {
                        lCount++;
                        left++;
                    }
                    while (right >= left && arr[right] == rightVal) {
                        rCount++;
                        right--;
                    }

                    count += lCount * rCount;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
