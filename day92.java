class Solution {
    Node first, middle, last, prev;

    public void correctBST(Node root) {
        // Initialize pointers
        first = middle = last = prev = null;

        // Step 1: Perform inorder traversal to find the two nodes
        inorderTraverse(root);

        // Step 2: Fix the swapped nodes
        if (first != null && last != null) {
            // Non-adjacent nodes swapped
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            // Adjacent nodes swapped
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    // Helper method for inorder traversal
    private void inorderTraverse(Node root) {
        if (root == null) return;

        inorderTraverse(root.left);

        // Find the nodes that are not in order
        if (prev != null && root.data < prev.data) {
            // First violation
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                // Second violation
                last = root;
            }
        }

        prev = root;

        inorderTraverse(root.right);
    }
}
