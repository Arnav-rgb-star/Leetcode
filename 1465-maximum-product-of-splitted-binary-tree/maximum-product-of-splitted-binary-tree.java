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
    long sum;
    long left;
    long max;
    void dfs(TreeNode node){
        if(node==null) return ;

        sum+=node.val;
        dfs(node.left);
        dfs(node.right);

        return ;
    }

    long dfs1(TreeNode node){
        if(node==null) return 0;

        left=node.val + dfs1(node.right) + dfs1(node.left);;
        
        long product= (sum-left)*left;
        max = Math.max(max,product);
        return left;
    }
    public int maxProduct(TreeNode root) {
        sum=0;
        dfs(root);
        left=0;
        max=0;

        long ans= dfs1(root);
        return (int)(max % 1000000007);

    }
}