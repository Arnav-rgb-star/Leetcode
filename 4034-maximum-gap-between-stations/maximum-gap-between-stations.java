class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int l[] = new int[n];
        int r[] = new int[n];
        if (n == 1) return 0;

        int j=0;
        for(int i=0;i<n;i++){
            while(skill.charAt(i)!=station.charAt(j)) ++j;
            l[i] = j++;
        }
        j=station.length()-1;
        for(int i=n-1;i>=0;i--){
            while(skill.charAt(i)!=station.charAt(j)) --j;
            r[i] = j--;
        }
        int gap=0;

        for(int i=1;i<n;i++){
            gap = Math.max(gap,(r[i]-l[i-1]));
        }
        return gap;
    }
}