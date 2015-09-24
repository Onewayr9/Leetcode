public class Solution {
    public int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<int[]>();
        int result = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                int[] a = {i,0};
                stack.push(a);
            }else{
                if(stack.empty()||stack.peek()[1]==1){
                    int[] a = {i,1};
                    stack.push(a);
                }else{
                    stack.pop();
                    int currentLen = 0;
                    if(stack.empty()){
                        currentLen = i+1;
                    }else{
                        currentLen = i-stack.peek()[0];
                    }
                    result = Math.max(result,currentLen);
                }
            }
        }
        return result;
    }
}