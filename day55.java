
class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
         int n = arr.length;
        Arrays.sort(arr);
        int count = 0;

        // Fix the third side one by one (from largest to smallest)
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    // All elements from i to j-1 will form a triangle with j and k
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}
