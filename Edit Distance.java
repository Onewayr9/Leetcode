public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if(length1==0||length2==0){
            return Math.max(length1,length2);
        }
        int[][] ans = new int[length1+1][length2+1];
        for(int i=0;i<=length2;i++){
            ans[0][i] = i;
        }
        for(int j=1;j<=length1;j++){
            ans[j][0] = j;
        }
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                int delete = ans[i-1][j]+1;
                int insert = ans[i][j-1]+1;
                int replace = ans[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    replace+=1;
                }
                ans[i][j] = Math.min(Math.min(delete,insert),replace);
            }
        }
        return ans[length1][length2];
    }
}