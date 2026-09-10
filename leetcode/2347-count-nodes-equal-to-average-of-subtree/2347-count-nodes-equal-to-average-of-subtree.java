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
    int result=0;

      int[] solve(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] p1 = solve(root.left);
        int[] p2 = solve(root.right);

        int totalSum = p1[0] + p2[0] + root.val;
        int totalCount = p1[1] + p2[1] + 1;

        int avg = totalSum / totalCount;

        if (avg == root.val) {
            result += 1;
        }

        return new int[]{totalSum, totalCount};
    }


    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return result;
        
    }
}