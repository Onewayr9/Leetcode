public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            dp[i][0] = matrix[i][0]=='1'?1:0;
        }
        for(int i=1;i<matrix[0].length;i++){
            dp[0][i] = matrix[0][i]=='1'?1:0;
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j] = 0;
                }else{
                    int length = Math.min(dp[i-1][j-1],dp[i-1][j]);
                    int width = Math.min(dp[i-1][j-1],dp[i][j-1]);
                    dp[i][j] = Math.min(length,width) + 1;
                }
            }
        }
        int max = 0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}