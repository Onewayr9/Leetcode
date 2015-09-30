public class Solution {
    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if(slen<tlen){
            return 0;
        }
        int[][] ans = new int[tlen+1][slen+1];
        for(int i=0;i<=tlen;i++){
            for(int j=i;j<=slen;j++){
                if(i==0){
                    ans[i][j] = 1;
                    continue;
                }
                if(j<i){
                    ans[i][j] = 0;
                }else{
                    if(s.charAt(j-1)==t.charAt(i-1)){
                        ans[i][j] = ans[i][j-1] + ans[i-1][j-1];
                    }else{
                        ans[i][j] = ans[i][j-1];
                    }
                }
            }
        }
        return ans[tlen][slen];
    }
}