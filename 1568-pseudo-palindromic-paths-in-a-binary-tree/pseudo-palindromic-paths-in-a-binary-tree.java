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

    int freq[]; 
    int cnt;

    int check(int a[]){

        int odd=0;
        for(int i=1;i<=9;i++){
            if(a[i]%2==1) ++odd;
        }
        if(odd<=1) return 1;
        else return 0;
    }

    void dfs(TreeNode node){

        if(node.left==null && node.right==null){
            freq[node.val]++;
            cnt+=check(freq);
            freq[node.val]--;

            return ;
        }

        freq[node.val]++;
        if(node.left!=null) dfs(node.left);
        if(node.right!=null) dfs(node.right);

        freq[node.val]--;
        return ;
    }
    public int pseudoPalindromicPaths(TreeNode root) {
        cnt=0;
        freq = new int[11];

        dfs(root);
        return cnt;
    }
}