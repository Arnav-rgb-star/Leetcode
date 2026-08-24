class Solution {
    int prefix[];
    
    int f(int i){
        if(i==prefix.length-1) return prefix[i];
        
        int notTake = f(i+1);
        int take = prefix[i]-notTake;
        
        return Math.max(take,notTake);
    }
    public int stoneGameVIII(int[] stones) {
        
        prefix = new int [stones.length];

        prefix[0]=stones[0];
        
        for(int i=1;i<stones.length;i++) prefix[i]=prefix[i-1]+stones[i];
        return f(1);
    }
}