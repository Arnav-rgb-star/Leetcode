class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();

        if(n==k) return "0";
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && k>0 && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;                  
            }

            stack.push(num.charAt(i)); 
        }
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty() && stack.peekLast()=='0') stack.pollLast();
        if(stack.isEmpty()) return "0";
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        
        return sb.toString();
    }
}