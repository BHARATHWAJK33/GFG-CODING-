
class Solution {

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // 1️⃣ Root (but add it only once)
        if (!isLeaf(root)) res.add(root.data);

        // 2️⃣ Left boundary (excluding leaves)
        addLeftBoundary(root.left, res);

        // 3️⃣ Leaf nodes (left ➜ right)
        addLeaves(root, res);

        // 4️⃣ Right boundary (excluding leaves, collected in reverse)
        addRightBoundary(root.right, res);

        return res;
    }

    /* ---------- helpers ---------- */

    private boolean isLeaf(Node n) {
        return n != null && n.left == null && n.right == null;
    }

    private void addLeftBoundary(Node cur, ArrayList<Integer> res) {
        while (cur != null) {
            if (!isLeaf(cur)) res.add(cur.data);
            // Prefer left child, otherwise right child
            cur = (cur.left != null) ? cur.left : cur.right;
        }
    }

    private void addRightBoundary(Node cur, ArrayList<Integer> res) {
        ArrayList<Integer> tmp = new ArrayList<>();
        while (cur != null) {
            if (!isLeaf(cur)) tmp.add(cur.data);
            // Prefer right child, otherwise left child
            cur = (cur.right != null) ? cur.right : cur.left;
        }
        // add in reverse order
        for (int i = tmp.size() - 1; i >= 0; --i)
            res.add(tmp.get(i));
    }

    private void addLeaves(Node cur, ArrayList<Integer> res) {
        if (cur == null) return;
        if (isLeaf(cur)) {
            res.add(cur.data);
            return;
        }
        addLeaves(cur.left,  res);
        addLeaves(cur.right, res);
    }
}
