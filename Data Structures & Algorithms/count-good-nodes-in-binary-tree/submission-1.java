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

        return ((node.val >= currMax) ? 1 : 0) + 
            dfs(node.left, Math.max(node.val, currMax)) +
            dfs(node.right, Math.max(node.val, currMax));
    }
}
