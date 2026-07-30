class Solution {
    
    int func(int nums[],int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int l=0;
        int cnt=0;
        for(int r=0;r<nums.length;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            while(map.size()>k){
                int freq = map.get(nums[l]);
                if(freq==1) map.remove(nums[l]);
                else map.put(nums[l],freq-1);

                ++l;
            }
            if(map.size()<=k) cnt+=(r-l+1);
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k)-func(nums,k-1);
    }
}