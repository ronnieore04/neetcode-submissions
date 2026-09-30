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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        return isInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isInRange(TreeNode node, int leftBound, int rightBound) {
        if (node == null) return true;
        if (node.val <= leftBound) return false;
        if (node.val >= rightBound) return false;
        return isInRange(node.left, leftBound, node.val) && 
               isInRange(node.right, node.val, rightBound);
    }
}

//        0
//      /   \
//  -1000   1000
//          /
//         0
