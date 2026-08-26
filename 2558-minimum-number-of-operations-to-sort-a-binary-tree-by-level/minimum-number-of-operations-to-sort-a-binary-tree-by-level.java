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
    public int minimumOperations(TreeNode root) {
        int ops=0;
        if(root ==null) return 0;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> a = new ArrayList<>();

            for(int i=0;i<n;i++){
                TreeNode c = q.poll();
                a.add(c.val);

                if(c.left!=null) q.offer(c.left);
                if(c.right!=null) q.offer(c.right);
            }
            ArrayList<Integer> sorted = new ArrayList<>(a);
            HashMap<Integer,Integer> map = new HashMap<>();

            Collections.sort(sorted);
            for(int i=0;i<n;i++) map.put(a.get(i),i);
            
            for(int i=0;i<n;i++){
                if(a.get(i)==sorted.get(i)) continue;
                int k = map.get(sorted.get(i));
                
                int temp = a.get(k);
                a.set(k,a.get(i));
                a.set(i,temp);

                map.put(a.get(i),i);
                map.put(a.get(k),k);
                ++ops;
            }
        }
        return ops;
    }
}