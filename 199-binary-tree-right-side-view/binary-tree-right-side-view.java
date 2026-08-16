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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;

        Deque<TreeNode> q = new ArrayDeque<>();

        Map<Integer,Integer> m = new TreeMap<>();

        q.offer(root);

        int level=0;

        while(!q.isEmpty()){
            int n = q.size();

            for(int i=0;i<n;i++){
                TreeNode node = q.pop();


                if(i== n-1){
                    m.put(level,node.val);
                } 
                if(node.left!=null){
                    q.offer(node.left);
                    
                }
                if(node.right!=null){
                    q.offer(node.right);
                    
                }
            }
            ++level;
        }
        for(Map.Entry<Integer,Integer> entry : m.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}