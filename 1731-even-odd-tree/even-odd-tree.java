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
    public boolean isEvenOddTree(TreeNode root) {
        boolean possible = true;
        
        if(root==null) return false;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int d=0;
        while(!q.isEmpty()){
            int n=q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for(int i=0;i<n;i++){
                TreeNode node = q.poll();

                level.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            } 
            int prev;
            if(d%2==1){
                prev = (int)1e7;
                for(int i=0;i<level.size();i++){
                    int ele = level.get(i);
                    if(ele%2==0){
                        if(prev > ele) prev=ele;
                        else{
                            return false;
                        }
                    }else return false;
                }
            }else{
                prev = -1;
                for(int i=0;i<level.size();i++){
                    int ele = level.get(i);
                    if(ele%2==1){
                        if(prev < ele) prev=ele;
                        else{
                            return false;
                        }
                    }else return false;
                }
            }
            ++d;
        }
        return possible;
    }
}