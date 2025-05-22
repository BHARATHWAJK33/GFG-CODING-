class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        // Arrays.sort(arr);
        // int count=0;
        // for(int i=0;i<arr.length-1;i++){
        //     if(arr[i]==arr[i+1]-1)count++;
        // }
        // return count;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : arr) {
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive elements
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
