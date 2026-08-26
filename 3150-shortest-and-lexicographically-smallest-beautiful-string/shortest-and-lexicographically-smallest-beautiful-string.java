class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i=0;
        int j=s.length()-1;
        int l=s.length()-1;
        int cnt=0;

        for(int r=s.length()-1;r>=0;r--){
            if(s.charAt(r)=='1') ++cnt;

            while(l>r && cnt>k){
                if(s.charAt(l)=='1') --cnt;
                --l;
            }
            while(l>r && s.charAt(l)=='0') --l;

            if(cnt==k){
                if( (j-i)>(l-r) || ((j-i)==(l-r) && s.substring(r,l+1).compareTo(s.substring(i,j+1))<0)){
                    i=r;
                    j=l;
                }

            }
        }
        if(cnt!=k) return "";
        return s.substring(i,j+1);
    }
}