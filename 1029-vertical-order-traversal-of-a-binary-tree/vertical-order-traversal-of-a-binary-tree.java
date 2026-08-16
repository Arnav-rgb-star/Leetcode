class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer,ArrayList<Integer>> m=new TreeMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;

        Deque<TreeNode> q=new ArrayDeque<>();
        Deque<Integer> col=new ArrayDeque<>();
        q.offer(root);
        col.offer(0);

        while(!q.isEmpty()){
            int n = q.size();

            Map<Integer,ArrayList<Integer>> row=new HashMap<>();

            for(int i=0;i<n;i++){

                TreeNode node=q.pop();
                int c=col.poll();

                if(!row.containsKey(c)){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(node.val);
                    row.put(c,list);
                }else{
                    ArrayList<Integer> list=row.get(c);
                    list.add(node.val);
                }

                if(node.left!=null){
                    q.offer(node.left);
                    col.offer(c-1);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    col.offer(c+1);
                }
            }

            for(Map.Entry<Integer,ArrayList<Integer>> entry:row.entrySet()){

                int c = entry.getKey();
                ArrayList<Integer> v =entry.getValue();
                
                Collections.sort(v);

                if(!m.containsKey(c)){
                    m.put(c,new ArrayList<>());
                }

                ArrayList<Integer> f= m.get(c);
                f.addAll(v);
            }
        }

        for(Map.Entry<Integer,ArrayList<Integer>> entry:m.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}