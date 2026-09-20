class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int start[] = new int[26];
        int end[] = new int [26];

        Arrays.fill(start,-1);
        Arrays.fill(end,-1);

        for(int i=0;i<s.length();i++){
            int x = s.charAt(i)-'a';
            if(start[x]==-1) start[x] = i;

            end[x] = Math.max(end[x],i);
        }
        List<String> ans = new ArrayList<>();

        int k=-1;

        for(int i=0;i<s.length();i++){
            
            int x = s.charAt(i) -'a';
            
            if(i!=start[x])  continue;
            boolean valid = true;
            int r = end[x];

            for(int j=i;j<=r;j++){
                int y = s.charAt(j)-'a';

                if(start[y]<i){
                    valid = false;
                    break;
                }
                r = Math.max(r,end[y]);
            }
            
            if(!valid) continue;

            if(start[x]<=k){
                ans.remove(ans.size()-1);
            }

            ans.add(s.substring(start[x],r+1));
            k = r;
        }
        return ans;
    }
}