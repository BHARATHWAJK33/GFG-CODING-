class Solution {
    int count = 0;   // To track the number of nodes visited
    int result = -1; // To store the k-th smallest element
    
    public int kthSmallest(Node root, int k) {
        inOrder(root, k);
        return result;
    }
    
    private void inOrder(Node node, int k) {
        if (node == null) return;

        inOrder(node.left, k);
        
        count++;
        if (count == k) {
            result = node.data;
            return;
        }
        
        inOrder(node.right, k);
    }
}
