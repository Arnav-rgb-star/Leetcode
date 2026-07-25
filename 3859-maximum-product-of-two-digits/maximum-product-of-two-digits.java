class Solution {
    public int maxProduct(int n) {
        int max=n%10;
        n/=10;
        int smax=n%10;;

        while(n>0){
            int d = n%10;
            if(d>=max){
                smax=max;
                max=d;
            }else if(d>smax && d<max){
                smax=d;
            }
            n/=10;
        }

        return max*smax;
    }
}