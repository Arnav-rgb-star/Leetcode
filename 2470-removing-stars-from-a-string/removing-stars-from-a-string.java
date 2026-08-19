class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            
            if(stack.size()>0 && s.charAt(i)=='*') stack.pollLast();
            else stack.offer(s.charAt(i));
            
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) sb.append(stack.pop());

        String str = sb.toString();
        return str;
    }
}