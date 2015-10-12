public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length==0||dungeon[0].length==0){
            return 0;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] ans = new int[row][col];
        ans[row-1][col-1] = Math.max(1-dungeon[row-1][col-1],1);
        for(int i=row-2;i>=0;i--){
            ans[i][col-1] = Math.max(ans[i+1][col-1]-dungeon[i][col-1],1);
        }
        for(int j=col-2;j>=0;j--){
            ans[row-1][j] = Math.max(ans[row-1][j+1]-dungeon[row-1][j],1);
        }
        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){
                int right = Math.max(ans[i][j+1]-dungeon[i][j],1);
                int bot = Math.max(ans[i+1][j]-dungeon[i][j],1);
                ans[i][j] = Math.min(right,bot);
            }
        }
        return ans[0][0];
    }
}