class Solution {

    public int sumK(Node root, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);                     // empty‑prefix base
        return dfs(root, 0, k, freq);
    }

    private int dfs(Node node, int currSum, int k,
                    Map<Integer, Integer> freq) {

        if (node == null) return 0;

        currSum += node.data;

        int pathsHere = freq.getOrDefault(currSum - k, 0);

        freq.put(currSum, freq.getOrDefault(currSum, 0) + 1);

        pathsHere += dfs(node.left,  currSum, k, freq);
        pathsHere += dfs(node.right, currSum, k, freq);

        freq.put(currSum, freq.get(currSum) - 1); // backtrack
        return pathsHere;
    }
}
