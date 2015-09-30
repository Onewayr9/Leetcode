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
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int len_1 = c1.length;
        int len_2 = c2.length;
        boolean[][] ans = new boolean[len_1+1][len_2+1];
        ans[0][0] = true;
        for(int i=1;i<=len_1;i++){
            if(c3[i-1]==c1[i-1]){
                ans[i][0] = ans[i-1][0];
            }
        }
        for(int i=1;i<=len_2;i++){
            if(c3[i-1]==c2[i-1]){
                ans[0][i] = ans[0][i-1];
            }
        }
        for(int i=1;i<=len_1;i++){
            for(int j=1;j<=len_2;j++){
                if(c1[i-1]==c3[i+j-1]&&c2[j-1]!=c3[i+j-1]){
                    ans[i][j] = ans[i-1][j];
                }else if(c1[i-1]!=c3[i+j-1]&&c2[j-1]==c3[i+j-1]){
                    ans[i][j] = ans[i][j-1];
                }else if(c1[i-1]==c3[i+j-1]&&c2[j-1]==c3[i+j-1]){
                    ans[i][j] = ans[i-1][j]||ans[i][j-1];
                }
            }
        }
        return ans[len_1][len_2];
    }
}