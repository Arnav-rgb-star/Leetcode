class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {

        int a[] = new int[Math.max(upper+1,nums.length)]; 
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=lower && nums[i]<=upper) a[nums[i]]++;
        }
        int l=lower;
        int r=lower;

        List<List<Integer>> ans = new ArrayList<>();

        while(r<=upper){

            while(r<=upper && a[r]>0){
                ++r;
            }
            if(r>upper) break;

            l = r;
                while(r <= upper && a[r] == 0) ++r;
                List<Integer> list = new ArrayList<>();
                list.add(l);
                list.add(r - 1);

                ans.add(list);
        }
        return ans;
    }
}