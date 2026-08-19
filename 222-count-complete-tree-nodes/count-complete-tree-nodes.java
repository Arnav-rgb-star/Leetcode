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
    int getlh(TreeNode root){
        int h=0;

        while(root!=null){
            ++h;
            root=root.left;
        }
        return h;
    }
    int getrh(TreeNode root){
        int h=0;

        while(root!=null){
            ++h;
            root=root.right;
        }
        return h;
    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh = getlh(root);
        int rh = getrh(root);

        if(lh==rh) return (int)((1<<rh) -1);
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}