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

    class Pair{
        int sum;
        int n;

        Pair(int sum, int n){
            this.sum = sum;
            this.n = n;
        }
    }
    int total=0;
    Pair f(TreeNode node){

        if(node==null) return new Pair(0,0);
        Pair l = f(node.left);
        Pair r = f(node.right);

        int sum = l.sum + r.sum + node.val;
        int n = l.n + r.n + 1;

        if (sum/n == node.val) ++total;

        return new Pair(sum,n);
    }
    public int averageOfSubtree(TreeNode root) {
        f(root);
        return total;
    }
}