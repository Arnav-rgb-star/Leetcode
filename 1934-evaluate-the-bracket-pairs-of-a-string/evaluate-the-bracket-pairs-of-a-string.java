class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> mp = new HashMap<>();

        int n = knowledge.size();
        for(int i=0;i<n;i++){
            mp.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        int i=0;
        int b=0;

        StringBuilder ans = new StringBuilder();
        while(i<s.length()){
            if(s.charAt(i)=='('){
                ++i;
                StringBuilder sb = new StringBuilder();

                while (s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }
                ans.append(mp.getOrDefault(sb.toString(), "?"));
                ++i;
            }else{
                ans.append(s.charAt(i));
                ++i;
            }
        }
        return ans.toString();
    }
}