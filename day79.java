class Solution {
    static int n, m;
    static boolean[][] visited;

    static public boolean isWordExist(char[][] mat, String word) {
        n = mat.length;
        m = mat[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean dfs(char[][] mat, String word, int index, int row, int col) {
        // base case: entire word matched
        if (index == word.length()) return true;

        // boundary and character match check
        if (row < 0 || row >= n || col < 0 || col >= m ||
            visited[row][col] || mat[row][col] != word.charAt(index)) {
            return false;
        }

        // mark visited
        visited[row][col] = true;

        // explore 4 directions
        boolean found = dfs(mat, word, index + 1, row - 1, col) ||
                        dfs(mat, word, index + 1, row + 1, col) ||
                        dfs(mat, word, index + 1, row, col - 1) ||
                        dfs(mat, word, index + 1, row, col + 1);

        // backtrack
        visited[row][col] = false;

        return found;
    }
}
