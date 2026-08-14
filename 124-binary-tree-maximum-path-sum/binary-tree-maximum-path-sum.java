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

    int f(TreeNode node, int d[]){
        if(node==null) return 0;

        int l = Math.max(0,f(node.left,d));
        int r = Math.max(0,f(node.right,d));

        d[0] = Math.max(d[0],node.val+l+r); 

        return node.val + Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        int d[] = new int[]{Integer.MIN_VALUE};;
        

        int k = f(root,d);
        return d[0];
    }
}