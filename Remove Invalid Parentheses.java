public class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        helper("",0,0,s);
        return ans;
    }
    public void helper(String temp,int left,int right,String s){
        if(s.length()==0){
            if(left==right){
                if(ans.size()==0||temp.length()==ans.get(0).length()){
                    if(!ans.contains(temp)) ans.add(temp);
                }else if(temp.length()>ans.get(0).length()){
                    ans.clear();
                    ans.add(temp);
                }
            }
            return;
        }
        if(s.charAt(0)=='('){
            helper(temp+'(',left+1,right,s.substring(1));
            helper(temp,left,right,s.substring(1));
        }else if(s.charAt(0)==')'){
            if(left>right){
                helper(temp+')',left,right+1,s.substring(1)); 
            }
            helper(temp,left,right,s.substring(1));
        }else{
            helper(temp+s.charAt(0),left,right,s.substring(1));
        }
    }
}