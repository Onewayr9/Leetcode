public class Solution {
    public String convert(String s, int numRows) {
        String ans = "";
        if(numRows==1)
            return s;
        else{
            for(int i=0;(2*numRows-2)*i<s.length();i++){
                ans = ans + s.charAt((2*numRows-2)*i) + "";
            }
            for(int i=1;i<numRows-1;i++){
                int j = i;
                for(int k=0;j+(2*numRows-2)*k<s.length();k++){
                    ans = ans + s.charAt(j+(2*numRows-2)*k) + "";
                    if(2*numRows-2-j+(2*numRows-2)*k<s.length())
                        ans = ans + s.charAt(2*numRows-2-j+(2*numRows-2)*k) + "";
                }
            }
            for(int i=0;numRows-1+(2*numRows-2)*i<s.length();i++){
                ans = ans + s.charAt(numRows-1+(2*numRows-2)*i) + "";
            }
        }
        return ans;
    }
}