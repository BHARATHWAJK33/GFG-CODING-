class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if (node == null) {
            return -1;  // Return -1 for edges-based height
        }
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
