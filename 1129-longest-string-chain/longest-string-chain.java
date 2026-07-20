class Solution {
    boolean compare(String a,String b){
        if(a.length()!=b.length()+1) return false;
        int l=0;
        int r=0;

        while(l<a.length()){
            if(r<b.length() && a.charAt(l)==b.charAt(r)){
                ++l;
                ++r;
            }else ++l;
        }
        if(l==a.length() && r==b.length()) return true;
        else return false;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        int n = words.length;
        int dp[]= new int[n+1];
        int max=0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(compare(words[i],words[j]) && dp[i]<(1+dp[j])){
                    dp[i]=(1+dp[j]);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max+1;
    }
}