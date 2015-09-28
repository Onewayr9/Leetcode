public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len!=s2.length()){
            return false;
        }
        if(len==0){
            return true;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        boolean[][][] ans = new boolean[len][len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                ans[0][i][j] = (c1[i]==c2[j]);
            }
        }
        for(int k=1;k<len;k++){
            for(int i=0;i<len-k;i++){
                for(int j=0;j<len-k;j++){
                    boolean temp = false;
                    for(int m=1;m<=k&&!temp;m++){
                        temp = (ans[m-1][i][j]&&ans[k-m][i+m][j+m])||(ans[m-1][i][j+k-m+1]&&ans[k-m][i+m][j]);
                    }
                    ans[k][i][j] = temp;
                }
            }
        }
        return ans[len-1][0][0];
    }
}