class Solution {
    public int kthElement(int a[], int b[], int k) {

        int i = 0, j = 0, count = 0, result = 0;

        for (int step = 0; step < k; step++) {
            if (i < a.length && (j >= b.length || a[i] <= b[j])) {
                result = a[i];
                i++;
            } else if (j < b.length) {
                result = b[j];
                j++;
            }
        }

        return result;
    }
}
