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
    TreeNode insert(TreeNode root,int k){
        if(root==null) return new TreeNode(k);

        if(root.val>k) root.left = insert(root.left,k);
        if(root.val<k) root.right = insert(root.right,k);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1;i<preorder.length;i++){
            root = insert(root,preorder[i]);
        }
        return root;
    }
}