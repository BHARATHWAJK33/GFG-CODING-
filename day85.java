class Solution {
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Node cur = root;
        
        while (cur != null) {
            if (cur.left == null) {
                // No left child: visit and move right
                res.add(cur.data);
                cur = cur.right;
            } else {
                // Find the right‑most node in left subtree
                Node pred = cur.left;
                while (pred.right != null && pred.right != cur)
                    pred = pred.right;
                
                if (pred.right == null) {
                    // First time here: thread predecessor to current
                    pred.right = cur;
                    cur = cur.left;
                } else {
                    // Thread exists: restore tree, visit current, go right
                    pred.right = null;
                    res.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
