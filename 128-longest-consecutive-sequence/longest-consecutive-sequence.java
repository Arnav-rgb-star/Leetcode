class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max=0;

        for(int i=0;i<nums.length;i++) set.add(nums[i]);
        for(int num : set){
            if(!set.contains(num - 1)){
                int x = num;
                int len = 0;

                while(set.contains(x)){
                    len++;
                    x++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}