class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int prefix[] = new int[n+1];
        int suffix[] = new int[n+1];

        for(int i=1;i<=n;i++) prefix[i]=prefix[i-1]+nums[i-1];
        for(int i=n-1;i>=0;i--) suffix[i] = suffix[i+1]+nums[i];

        int ans = (int)1e6;

        for(int i=0;i<=n;i++){
            int target = x - prefix[i];

            if(target<0) break;

            int l=i;
            int r = n;

            while(l<=r){
                int m = l+(r-l)/2;
                if(suffix[m]==target){
                    ans = Math.min(ans,i+n-m);
                    break;
                }else if(suffix[m]>target){
                    l=m+1;
                }else r=m-1;
            }
        }

        if(ans!=(int)1e6) return ans;
        else return -1;
    }
}