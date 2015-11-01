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
/*Dynamic Programming*/
public boolean isMatch(String s, String p) {
        boolean[][] ans = new boolean[s.length()+1][p.length()+1];
        ans[0][0] = true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                ans[0][i] = ans[0][i-1];
            }
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)=='?'){
                    ans[i][j] = ans[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    ans[i][j] = ans[i-1][j]||ans[i-1][j-1]||ans[i][j-1];
                }else{
                    ans[i][j] = ans[i-1][j-1]&&(s.charAt(i-1)==p.charAt(j-1));
                }
            }
        }
        return ans[s.length()][p.length()];
    }