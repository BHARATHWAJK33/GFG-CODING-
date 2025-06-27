class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
         if (node == null) return;

        // Recursively call mirror for left and right subtrees
        mirror(node.left);
        mirror(node.right);

        // Swap left and right children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
