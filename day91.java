class Solution {
    public boolean findTarget(Node root, int target) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, target);
    }

    private boolean dfs(Node node, HashSet<Integer> set, int target) {
        if (node == null) return false;

        if (set.contains(target - node.data)) {
            return true;
        }

        set.add(node.data);

        return dfs(node.left, set, target) || dfs(node.right, set, target);
    }
}
