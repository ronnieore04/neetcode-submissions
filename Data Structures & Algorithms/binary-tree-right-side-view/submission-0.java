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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<Integer> ret = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rightFound = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (rightFound == false && node != null) {
                    rightFound = true;
                    ret.add(node.val);
                }
                if (node != null) {
                    q.add(node.right);
                    q.add(node.left);
                }
            }
        }
        return ret;
    }
}
