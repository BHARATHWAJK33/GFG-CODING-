class Solution {
    private int globalMax;

    // Main entry point; call this with the root node.
    int findMaxSum(Node root) {
        globalMax = Integer.MIN_VALUE;   // works even if all values are negative
        dfs(root);
        return globalMax;
    }

    // Returns the best “downward” path sum that starts at 'curr'
    // and goes to at most one child.
    private int dfs(Node curr) {
        if (curr == null) return 0;

        int leftDown  = dfs(curr.left);   // best downward path in left subtree
        int rightDown = dfs(curr.right);  // best downward path in right subtree

        // If a child path is negative, drop it (take 0 instead)
        int bestDownFromCurr = curr.data + Math.max(0, Math.max(leftDown, rightDown));

        // Candidate path that passes THROUGH curr using both children
        int throughCurr = curr.data + Math.max(0, leftDown) + Math.max(0, rightDown);

        // Update the answer seen so far
        globalMax = Math.max(globalMax, throughCurr);

        return bestDownFromCurr; // sent upward to parent
    }
}
