class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
                ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        solve(n, 0, current, result);
        return result;
    }

    private void solve(int n, int col, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int row = 1; row <= n; row++) {
            if (isSafe(current, row, col)) {
                current.add(row);
                solve(n, col + 1, current, result);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }

    private boolean isSafe(ArrayList<Integer> current, int row, int col) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = current.get(prevCol);
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false; // same row or diagonal
            }
        }
        return true;

    }
}
