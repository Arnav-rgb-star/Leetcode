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

    TreeNode findIP(TreeNode node){
        TreeNode ip = node.left;
        while(ip.right!=null && ip.right!=node) ip = ip.right;
        return ip;
    }
    int morris(TreeNode root,int k){
        int cnt=0;
        int v = 0;

        TreeNode node = root;

        while(node!=null){
            if(node.left==null){
                ++cnt;
                if(cnt==k) return node.val;
                node=node.right;
            }else{
                TreeNode ip = findIP(node);
                if(ip.right==null){

                    ip.right = node;
                    node = node.left;
                }else{
                    ++cnt;
                    if(cnt==k) return node.val;
                    ip.right=null;
                    node = node.right;
                }
            }
        }
        return v;
    }

    public int kthSmallest(TreeNode root, int k) {
        int val = morris(root,k);
        return val;
    }
}