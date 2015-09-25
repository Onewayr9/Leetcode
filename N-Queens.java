public class Solution {
    List<List<String>> ans = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        if(n<=0) return ans;
        solveNQueens(new int[n],0,n);
        return ans;
    }
    public void solveNQueens(int[] pos,int row,int n){
        if(row==n){
            ArrayList<String> temp = printtable(pos,n);
            ans.add(temp);
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
    public ArrayList<String> printtable(int[] pos,int n){
        ArrayList<String> table = new ArrayList<String>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n-1;j++) sb.append('.');
            sb.insert(pos[i],'Q');
            table.add(sb.toString());
        }
        return table;
    }
}