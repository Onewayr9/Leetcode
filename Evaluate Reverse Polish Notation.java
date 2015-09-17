public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        else{
            Stack<Integer> stack = new Stack<Integer>();
            for(int i = 0;i<tokens.length;i++){
                if(tokens[i].equals("+")){
                    stack.push(stack.pop()+stack.pop());
                }else if(tokens[i].equals("-")){
                    stack.push(0-stack.pop()+stack.pop());
                }else if(tokens[i].equals("*")){
                    stack.push(stack.pop()*stack.pop());
                }else if(tokens[i].equals("/")){
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend/divisor);
                }else stack.push(Integer.parseInt(tokens[i]));
            }
            return stack.pop();
        }
    }
}