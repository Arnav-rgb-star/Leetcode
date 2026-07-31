class Solution {
    public String minWindow(String s, String t) {
        int hash[]=new int[256];
        int idx=-1;
        int len=1000000;
        int n = s.length();
        int m = t.length();
        int cnt=0;
        int l=0;
        for(int i=0;i<m;i++) hash[t.charAt(i)]++;

        for(int r=0;r<n;r++){
            hash[s.charAt(r)]--;
            if(hash[s.charAt(r)] >= 0) ++cnt;
            while(cnt==m){
                if(r-l+1 <len){
                    len=(r-l+1);
                    idx=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) --cnt;;
                ++l;
            }
        }
        if(idx==-1) return "";
        String str = s.substring(idx,idx+len);
        return  str;
    }
}