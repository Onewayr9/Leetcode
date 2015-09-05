public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        int[][] ans = new int[obstacleGrid.length][obstacleGrid[0].length];
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        ans[0][0] = Math.abs(obstacleGrid[0][0]-1);
        if(obstacleGrid[0][0]==1) return 0;
        int obstacle = 1;
        for(int i=1;i<row;i++){
            if(obstacleGrid[i][0]==1) obstacle = 0;
            ans[i][0] = obstacle;
        }
        obstacle = 1;
        for(int i=1;i<col;i++){
            if(obstacleGrid[0][i]==1) obstacle = 0;
            ans[0][i] = obstacle;
        }
        for(int i=1;i<row;i++)
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j]==1) ans[i][j] = 0;
                else ans[i][j] = ans[i-1][j]+ans[i][j-1];
            }
        return ans[row-1][col-1];
    }
}