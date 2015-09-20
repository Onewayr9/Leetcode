public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        else{
            int ans = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]=='1'){
                        ans++;
                        dfs(grid,i,j);
                    }
                }
            }
            return ans;
        }
    }
    public void dfs(char[][] grid,int i,int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0||i>=n||j<0||j>=m||grid[i][j]=='0') return;
        else{
            grid[i][j] = '0';
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
        }
    }
}