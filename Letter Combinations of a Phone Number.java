public class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return ans;
        }
        combine("",digits);
        return ans;
    }
    public void combine(String temp,String digits){
        if(digits.length()==0){
            ans.add(temp);
            return;
        }
        char[][] dict = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        for(char c:dict[digits.charAt(0)-'2']){
            combine(temp+c,digits.substring(1));
        }
    }
}