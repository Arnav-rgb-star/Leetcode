class Solution {
    public int totalNumbers(int[] digits) {
        int freq[] = new int[10];

        for(int d=0;d<digits.length;d++) freq[digits[d]]++;

        int ans=0;

        for(int i=0;i<=8;i+=2){
            if(freq[i]==0) continue;
            
            freq[i]--;
            for(int j=0;j<=9;j++){
                if(freq[j]==0) continue;

                --freq[j];

                for(int k=1;k<=9;k++){
                    if(freq[k]==0) continue;

                    ++ans;
                }
                ++freq[j];
            }
            ++freq[i];
        }
        return ans;
    }
}