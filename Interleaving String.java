/**Backtracking, the worst case time complexity is O(2^n), cannot get AC*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        return isInterleave(c1,c2,c3,0,c1.length,0,c2.length,0,c3.length);
    }
    public boolean isInterleave(char[] c1,char[] c2,char[] c3,int c1begin,int c1len,int c2begin,int c2len,int c3begin,int len){
        if(c3begin==len){
            return true;
        }else{
            if((c1begin<c1len&&c3[c3begin]!=c1[c1begin])&&(c2begin<c2len&&c3[c3begin]!=c2[c2begin])){
                return false;
            }
            if((c1begin<c1len&&c3[c3begin]==c1[c1begin]&&isInterleave(c1,c2,c3,c1begin+1,c1len,c2begin,c2len,c3begin+1,len))||(c2begin<c2len&&c3[c3begin]==c2[c2begin]&&isInterleave(c1,c2,c3,c1begin,c1len,c2begin+1,c2len,c3begin+1,len))){
                return true;
            }else{
                return false;
            }
        }
    }
}
/**DP, the worst case time complexity is O(MN), Accepted*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len_1 = s1.length();
        int len_2 = s2.length();
        if(len_1+len_2!=s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[len_1+1][len_2+1];
        dp[0][0] = true;
        for(int i=0;i<=len_1;i++){
            for(int j=0;j<=len_2;j++){
                if(i>0&&j>0){
                    dp[i][j] = (dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)))||(dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
                }else if(i>0){
                    dp[i][j] = dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1));
                }else if(j>0){
                    dp[i][j] = dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1));
                }
            }
        }
        return dp[len_1][len_2];
    }
}