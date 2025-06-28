class Solution {

    // helper state shared across recursive calls
    private static int preIdx;                           // pointer inside preorder[]
    private static java.util.Map<Integer, Integer> pos;  // value → index in inorder[]

    /*  Constructs the binary tree from inorder & preorder traversals.
        Returns the root node.  The judge will later print it in post‑order. */
    public static Node buildTree(int[] inorder, int[] preorder) {

        // 1️⃣  build a quick lookup table for inorder positions
        pos = new java.util.HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            pos.put(inorder[i], i);
        }

        preIdx = 0;                                      // reset global pointer
        return build(preorder, 0, inorder.length - 1);   // construct & return root
    }

    // Recursively builds subtree spanning inorder[lo … hi]
    private static Node build(int[] preorder, int lo, int hi) {
        if (lo > hi) return null;                        // empty segment → no node

        int rootVal = preorder[preIdx++];                // pick current root
        Node root   = new Node(rootVal);

        int mid = pos.get(rootVal);                      // root index in inorder
        root.left  = build(preorder, lo,     mid - 1);   // left subtree
        root.right = build(preorder, mid + 1, hi);       // right subtree
        return root;
    }
}
