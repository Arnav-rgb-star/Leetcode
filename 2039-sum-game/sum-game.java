class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int l=0;
        int r=0;
        int x=0;
        int y=0;

        for(int i=0;i<n/2;i++){
            if(num.charAt(i) !='?') l+=(num.charAt(i)-'0');
            else ++x;
        }

        for(int i=n/2;i<n;i++){
            if(num.charAt(i) !='?') r+=(num.charAt(i)-'0');
            else ++y;
        }

        if((x+y)%2==1) return true;

        int d = l-r;
        int v = 9*(y-x);
        v/=2;
        if(v==d) return false;
        else return true;  
    }
}