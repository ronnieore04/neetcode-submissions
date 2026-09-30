/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int currMax) {
        if (node == null) return 0;

        int res = (node.val >= currMax) ? 1 : 0;
        currMax = Math.max(node.val, currMax);
        return res + dfs(node.left, currMax) + dfs(node.right, currMax);
    }
}
