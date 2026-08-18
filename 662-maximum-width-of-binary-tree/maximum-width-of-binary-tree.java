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
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node ,int idx){
            this.node = node;
            this.index=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,0));

        int max=0;
        while(!q.isEmpty()){
            int n = q.size(); 
            int s=q.peek().index;
            int e=0;
            
            for(int i=0;i<n;i++){
                Pair p = q.pop();

                int current=p.index;
                int index = current-s;
                e=index;

                if(p.node.left!=null) q.offer(new Pair(p.node.left,2*index));
                if(p.node.right!=null) q.offer(new Pair(p.node.right,2*index+1));
                
            }
            max = Math.max(max,e+1);
        }
        return max;
    }
}