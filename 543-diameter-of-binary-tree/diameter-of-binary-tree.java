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

    int f(TreeNode node,int d[]){
        if(node ==null) return 0;

        int l = f(node.left,d);
        int r = f(node.right,d);

        d[0] = Math.max(d[0],l+r);
        return 1 + Math.max(l,r);
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int d[]=new int[1];

        int k = f(root,d);
        return d[0];
    }
}