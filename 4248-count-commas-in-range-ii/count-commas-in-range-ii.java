class Solution {
    public long countCommas(long n) {

        int d = String.valueOf(n).length();

        if(d<=3){
            return 0;
        }else if(d>3 && d<=6){
            return (n-999);
        }else if(d>6 && d<=9){
            return (n-999)+(n-999999);
        }else if(d>9 && d<=12){
            return (n-999)+(n-999999)+(n-999999999);
        }else if(d>12 && d<=15){
            return (n-999)+(n-999999)+(n-999999999)+(n - 999999999999L);
        }else{
            return (n-999)+(n-999999)+(n-999999999)+(n- 999999999999L)+ (n - 999999999999999L);
        }
    }
}