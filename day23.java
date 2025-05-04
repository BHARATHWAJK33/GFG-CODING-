class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        // int count=0;
        // for(int i=0;i<arr.length-1;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]>arr[j]) count+=1;
        //     }
            
        // }
        // return count;
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) / 2;
        int count = 0;
        count += mergeSort(arr, l, mid);
        count += mergeSort(arr, mid + 1, r);
        count += merge(arr, l, mid, r);
        return count;
    }

    static int merge(int[] arr, int l, int m, int r) {
        int[] left = java.util.Arrays.copyOfRange(arr, l, m + 1);
        int[] right = java.util.Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, count = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += (left.length - i);  // Count inversions
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];

        return count;
        
    }
}
