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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> t = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        if(root== null) return t;
        q.addLast(root);

        int reverse =0;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> current = new ArrayList<>();

            if(reverse==0){
                for(int i=0;i<n;i++){
                    TreeNode node = q.removeFirst();

                    current.add(node.val);
                    if(node.left!=null) q.addLast(node.left);
                    if(node.right!=null) q.addLast(node.right);
                }
            }else{
                for(int i=0;i<n;i++){
                    TreeNode node = q.removeLast();

                    current.add(node.val);
                    if(node.right!=null) q.addFirst(node.right);
                    if(node.left!=null) q.addFirst(node.left);
                }
            }
            t.add(new ArrayList<>(current));
            reverse = 1-reverse;
        }
        return t;
    }
}