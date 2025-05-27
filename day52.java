class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        // int count=0;
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr.length;j++){
        //         if(arr[i]+arr[j]<target) count+=1;
        //     }
        // }
        // return count;
        
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int count = 0;

        while (left < right) {
            if (arr[left] + arr[right] < target) {
                count += right - left;  // All pairs from left to right are valid
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
