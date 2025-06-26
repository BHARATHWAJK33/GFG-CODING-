class Solution {
    int maxDiameter = 0;

    int diameter(Node root) {
        height(root);
        return maxDiameter;
    }

    // Helper method to compute height and update diameter
    private int height(Node node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update the diameter at this node
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of the tree rooted at current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
