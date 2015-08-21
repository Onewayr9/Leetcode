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
                }
                if(s.charAt(i)!=')'){
                    operation.push(s.charAt(i));
                }else{
                    int temp = 0;
                    while(operation.peek()!='('){
                        if(operation.peek()=='+')
                            temp += num.pop();
                        else if(operation.peek()=='-')
                            temp -= num.pop();
                        operation.pop();
                    }
                    operation.pop();
                    temp += num.pop();
                    num.push(temp);
                }
            }
        }
        int ans = 0;
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