class Solution {
    public int minimumPushes(String word) {
        int count[]=new int[26];

        for(int i=0;i<word.length();i++) count[word.charAt(i)-'a']++;

        Arrays.sort(count);
        int pad=0;
        int m=1;
        int sum=0;

        for(int i=25;i>=0;i--){
            pad++;
            sum+= count[i]*m;
            if(pad%8==0) ++m;
        }
        return sum;
    }
}