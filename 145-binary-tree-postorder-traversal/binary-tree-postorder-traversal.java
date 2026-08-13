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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<TreeNode> queue = new Stack<>();
        Stack<TreeNode> queue1 = new Stack<>();
        queue.push(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.pop();
            queue1.push(node);

            if(node.left!=null) queue.push(node.left);
            if(node.right!=null) queue.push(node.right);

        }
        while(!queue1.isEmpty()) ans.add(queue1.pop().val);
        return ans;
    }
}