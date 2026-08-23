/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public void dfs(TreeNode root,StringBuilder str){
        if(root==null){
            str.append("*,");
            return;
        }
        str.append(root.val + ",");
        dfs(root.left,str);
        dfs(root.right,str);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();

        dfs(root,str);
        return str.toString();
    }
    int i=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null){
            return null;
        }
        i=0;
        String s[] = data.split(",");
        return build(s);
    }
    TreeNode build(String[] s){
        String val = s[i++];

        if(val.equals("*")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = build(s);
        node.right = build(s);

        return node;
    } 
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));