
class Solution {
    // Helper function to validate BST with range
    boolean isBSTUtil(Node node, long min, long max) {
        if (node == null) return true;

        // The current node must be in the range (min, max)
        if (node.data <= min || node.data >= max) return false;

        // Recursively check left and right subtrees
        return isBSTUtil(node.left, min, node.data) &&
               isBSTUtil(node.right, node.data, max);
    }

    // Main function to be called
    boolean isBST(Node root) {
        // Call helper with full valid range
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
