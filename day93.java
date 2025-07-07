class Solution {
    Node LCA(Node root, Node n1, Node n2) {
        if (root == null) return null;

        // Compare node values, not the node objects
        if (n1.data < root.data && n2.data < root.data) {
            return LCA(root.left, n1, n2);
        }

        if (n1.data > root.data && n2.data > root.data) {
            return LCA(root.right, n1, n2);
        }

        // This is the LCA node
        return root;
    }
}

