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

    int count(TreeNode node,int target,long sum){
        if(node==null) return 0;
        
        int ans=0;
        sum+=node.val;
        if(sum==target) ans=1;

        ans+=count(node.left,target,sum);
        ans+=count(node.right,target,sum);

        return ans;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;

        int tree = count(root,targetSum,0L);
        int left = pathSum(root.left,targetSum);
        int right = pathSum(root.right,targetSum);

        return tree+left+right;
    }
}