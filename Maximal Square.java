public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] d = new int[n][m];
        int max = 0;

        for(int i=0; i<n; i++) {
            if(matrix[i][0]=='1') {
                d[i][0] = 1;
                max = 1;
            }
        }
        
        for(int j=0; j<m; j++) {
            if(matrix[0][j]=='1') {
                d[0][j] = 1;
                max = 1;
            }
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(matrix[i][j]=='0') d[i][j]=0;
                else {
                    d[i][j] = Math.min( Math.min( d[i-1][j], d[i][j-1]), d[i-1][j-1] ) + 1;
                    max = Math.max(max, d[i][j]);
                }
            }
        }
        return max*max;
    }
}