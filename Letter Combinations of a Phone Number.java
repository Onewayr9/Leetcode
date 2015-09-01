public class Solution {
    public List<String> letterCombinations(String digits) {
        digits.replaceAll("1","");
        digits.replaceAll("\\*","");
        digits.replaceAll("0","");
        digits.replaceAll("#","");
        List<String> ans = new ArrayList<String>();
        if(digits.length()==0) return ans;
        else{
            int len = digits.length();
            String temp = "";
            combin(len,temp,digits,ans);
        }
        return ans;
    }
    public void combin(int len,String temp,String digits,List<String> ans){
        char[][] map = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        if(len==1) {
            int num = digits.charAt(0) - '2';
            for(int i=0;i<map[num].length;i++){
                ans.add(temp+map[num][i]);
            }
        }
        else{
            int num = digits.charAt(0) - '2';
            for(int i=0;i<map[num].length;i++){
                combin(len-1,temp+map[num][i],digits.substring(1),ans);
            }
        }
    }
}