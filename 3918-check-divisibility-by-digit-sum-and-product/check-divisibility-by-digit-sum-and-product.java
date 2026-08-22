class Solution {
    public boolean checkDivisibility(int n) {
        int k = n;
        int sum=0;
        int p=1;

        while(k!=0){
            sum+=(k%10);
            p*=(k%10);
            k/=10;
        }
        if(n%(sum+p)==0) return true;
        else return false;
    }
}