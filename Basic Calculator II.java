public class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> operation = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
        		continue;
        	if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                sb.append(s.charAt(i));
                if(i==s.length()-1)
                    num.push(Integer.valueOf(sb.toString()));
            }else{
                if(sb.length()>0){
                    num.push(Integer.valueOf(sb.toString()));
                    sb = new StringBuilder();
                }if(!operation.isEmpty()){
                    if(operation.peek()=='*'){
                        num.push(num.pop()*num.pop());
                        operation.pop();
                    }else if(operation.peek()=='/'){
                        int num1 = num.pop();
                        int num2 = num.pop();
                        num.push(num2/num1);
                        operation.pop();
                    }
                }
                operation.push(s.charAt(i));
            }
        }
        int ans = 0;
        if(!operation.isEmpty()){
            if(operation.peek()=='*'){
                num.push(num.pop()*num.pop());
                operation.pop();
            }else if(operation.peek()=='/'){
                int num1 = num.pop();
                int num2 = num.pop();
                num.push(num2/num1);
                operation.pop();
            }
        }
        while(!operation.isEmpty()){
        	//System.out.println(operation.peek());
            if(operation.peek()=='+')
                ans += num.pop();
            else if(operation.peek()=='-')
                ans -= num.pop();
            operation.pop();
        }
        ans += num.pop();
        return ans;
    }
}