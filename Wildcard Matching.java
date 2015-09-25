public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0,j = 0;
        int starIndex = -1, iStart = -1;
        while(i<s.length()){
            if(j<p.length()&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j))){
                i++;
                j++;
            }else if(j<p.length()&&p.charAt(j)=='*'){
                starIndex = j;
                iStart = i;
                j++;
            }else if(starIndex!=-1){
                j = starIndex+1;
                i = ++iStart;
            }else{
                return false;
            }
        }
        while(j<p.length()&&p.charAt(j)=='*')
            j++;
        return j==p.length();
    }
}