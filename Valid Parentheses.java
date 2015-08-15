public class Solution {
    public boolean isValid(String s) {
        Stack<Character> store = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                store.push(s.charAt(i));
            if(s.charAt(i)==')'){
                if(!store.empty()&&store.peek()=='(')
                    store.pop();
                else return false;
            }else if(s.charAt(i)==']'){
                if(!store.empty()&&store.peek()=='[')
                    store.pop();
                else return false;
            }else if(s.charAt(i)=='}'){
                if(!store.empty()&&store.peek()=='{')
                    store.pop();
                else return false;
            }
        }
        if(store.empty())
            return true;
        else return false;
    }
}