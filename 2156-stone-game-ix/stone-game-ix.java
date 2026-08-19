class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt[]= new int [3];

        for(int i=0;i<stones.length;i++) cnt[(stones[i]%3)]++;
        
        if((cnt[0]&1) ==0) return (cnt[1]>0 && cnt[2]>0);
        else return Math.abs(cnt[1]-cnt[2])>=3;
    }
}