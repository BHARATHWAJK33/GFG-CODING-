class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        // ArrayList<Integer> res=new ArrayList<>();
        // int row=mat.length;
        // int col=mat[0].length;
        // int top=0
        // return res;
        ArrayList<Integer> result = new ArrayList<>();
        if (mat == null || mat.length == 0) return result;
        int n = mat.length, m = mat[0].length;
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        while (top <= bottom && left <= right) {
            // Traverse left to right
            for (int i = left; i <= right; i++)
                result.add(mat[top][i]);
            top++;

            // Traverse top to bottom
            for (int i = top; i <= bottom; i++)
                result.add(mat[i][right]);
            right--;

            // Traverse right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    result.add(mat[bottom][i]);
                bottom--;
            }

            // Traverse bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(mat[i][left]);
                left++;
            }
        }

        return result;
    }
}
