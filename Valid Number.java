public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length()==0) return false;
        boolean e = false;
        boolean point = false;
        boolean temp = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='e'){
                if(e||i==0||i==s.length()-1||!temp){
                    return false;
                }
                e = true;
            }else if(s.charAt(i)=='.'){
                if(e||point||s.length()==1){
                    return false;
                }
                point = true;
            }else if(s.charAt(i)=='-'||s.charAt(i)=='+'){
                if((i!=0&&s.charAt(i-1)!='e')||s.length()==1||(i<s.length()-1&&s.charAt(i+1)=='e')){
                    return false;
                }
                temp = false;
            }else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                temp = true;
                continue;
            }else{
                return false;
            }
        }
        return temp;
    }
}