class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[]=new int[n];
        List<Integer> div = new ArrayList<>();
        Arrays.sort(nums);

        Arrays.fill(dp,1);
        int lis=0;
        int max=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<(1+dp[j])){
                    dp[i] = 1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                lis=i;
            }
        }
        while(hash[lis] != lis){
            div.add(nums[lis]);
            lis = hash[lis];
        }
        div.add(nums[lis]);
        Collections.reverse(div);
        return div;
    }
}