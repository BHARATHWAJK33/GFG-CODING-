class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
    // Function to merge arrays without using extra space
        int n = a.length, m = b.length;
        int gap = nextGap(n + m);

        while (gap > 0) {
            int i = 0, j;

            // Compare elements in a[]
            while (i + gap < n) {
                if (a[i] > a[i + gap]) {
                    int temp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = temp;
                }
                i++;
            }

            // Compare elements between a[] and b[]
            j = gap > n ? gap - n : 0;
            while (i < n && j < m) {
                if (a[i] > b[j]) {
                    int temp = a[i];
                    a[i] = b[j];
                    b[j] = temp;
                }
                i++;
                j++;
            }

            // Compare elements in b[]
            for (j = 0; j + gap < m; j++) {
                if (b[j] > b[j + gap]) {
                    int temp = b[j];
                    b[j] = b[j + gap];
                    b[j + gap] = temp;
                }
            }

            gap = nextGap(gap);
        }
}
     public int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
}
