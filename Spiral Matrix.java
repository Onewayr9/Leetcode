public class Solution {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return ans;
        int len = matrix.length*matrix[0].length;
        int m = matrix[0].length;
        int n = matrix.length;
        int i = 0;
        int round = 0;
        while(i<len){
            for(int j=round;j<m-round;j++){
                i++;
                ans.add(matrix[round][j]);
            }
            if(i>=len) break;
            for(int j=round+1;j<n-round;j++){
                i++;
                ans.add(matrix[j][m-round-1]);
            }
            if(i>=len) break;
            for(int j=m-round-2;j>=round;j--){
                i++;
                ans.add(matrix[n-round-1][j]);
            }
            if(i>=len) break;
            for(int j=n-round-2;j>=round+1;j--){
                i++;
                ans.add(matrix[j][round]);
            }
            round++;
        }
        return ans;
    }
}