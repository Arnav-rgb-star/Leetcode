class Solution {
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        int count[]=new int[101];

        for(int i=0;i<n;i++) count[nums[i]]++;
        int sum=0;
        for(int i=0;i<count.length;i++){
            if(count[i]==1) sum+=i;
        }
        return sum;
    }
}