/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        ans = new ArrayList<>();
        if(root==null) return ans;

        Deque<TreeNode> d = new ArrayDeque<>();
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        TreeNode targetNode=null;

        d.offer(root);

        while(!d.isEmpty()){

            int n = d.size();
            for(int i=0;i<n;i++){
                TreeNode current = d.pop();

                if(current==target) targetNode = current;

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

        int dist=0;

        while(!d.isEmpty() && dist<k){

            int n = d.size();
            for(int i=0;i<n;i++){
                TreeNode current = d.pop();

                if(current.left!=null && visited.add(current.left)) d.offer(current.left);

                if(current.right!=null && visited.add(current.right)) d.offer(current.right);
                
                TreeNode par = parent.get(current);
                if(par!=null && visited.add(par)) d.offer(par);
            }
            ++dist;
        }
        while(!d.isEmpty()) ans.add(d.poll().val);

        return ans;
    }
}