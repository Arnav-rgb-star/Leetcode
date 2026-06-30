class Solution {
    public void rev(int a[],int s,int e){
        int n = a.length;
        int m = s + (e-s)/2;
        for(int i=s;i<=m;i++){
            int temp=a[s+e-i];
            a[s+e-i]=a[i];
            a[i]=temp;
        }
    }
    public void nextPermutation(int[] nums) {
        int index=-1;
        int n = nums.length;
        for(int i=(n-2);i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index== -1){
            rev(nums,0,n-1);
            return;
        }
        for(int i=(n-1);i>=index;i--){
            if(nums[i]>nums[index]){
                int temp=nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        rev(nums,index+1,n-1);
        return;
    }
}