public class Solution {
    int ans = 0;
    public int totalNQueens(int n) {
        if(n<=0) return 0;
        else{
            solveNQueens(new int[n],0,n);
            return ans;
        }
    }
    public void solveNQueens(int[] pos,int row,int n){
        if(row==n){
            ans++;
            return;
        }
        for(int i=0;i<n;i++){
            pos[row] = i;
            if(isValid(pos,row)){
                solveNQueens(pos,row+1,n);
            }
        }
    }
    public boolean isValid(int[] pos,int row){
        for(int i=0;i<row;i++){
            if(pos[i]==pos[row]||(Math.abs(pos[i]-pos[row])==(row-i))) return false;
        }
        return true;
    }
}