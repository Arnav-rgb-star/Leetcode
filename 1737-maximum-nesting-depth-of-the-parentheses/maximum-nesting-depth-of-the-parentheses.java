class Solution {
    public int maxDepth(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push(s.charAt(i));
            max = Math.max(stack.size(),max);
            if(s.charAt(i)==')') stack.pop();
        }
        return max;
    }
}