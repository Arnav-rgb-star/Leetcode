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
    public int amountOfTime(TreeNode root, int start) {

        int time=-1;
        if(root==null) return 0;

        Deque<TreeNode> d = new ArrayDeque<>();
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        TreeNode targetNode=null;

        d.offer(root);

        while(!d.isEmpty()){

            int n = d.size();
            for(int i=0;i<n;i++){
                TreeNode current = d.pop();

                if(current.val== start) targetNode = current;

                if(current.left!=null){
                    parent.put(current.left,current);
                    d.offer(current.left);
                }

                if(current.right!=null){
                    parent.put(current.right,current);
                    d.offer(current.right);
                }
            }
        }

        d.offer(targetNode);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(targetNode);
        
        while(!d.isEmpty()){

            int n = d.size();
            for(int i=0;i<n;i++){
                TreeNode current = d.pop();

                if(current.left!=null && visited.add(current.left)) d.offer(current.left);

                if(current.right!=null && visited.add(current.right)) d.offer(current.right);
                
                TreeNode par = parent.get(current);
                if(par!=null && visited.add(par)) d.offer(par);
            }
            ++time;
        }
        return time;
    }
}