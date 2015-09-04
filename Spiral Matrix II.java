public class Solution {
    public int[][] generateMatrix(int n) {
        if(n==0) return (new int[0][0]);
        else{
            int[][] matrix = new int[n][n];
            int len = n*n;
            int i = 1;
            int round = 0;
            while(i<=len){
                for(int j=round;j<n-round;j++){
                    matrix[round][j]=i++;
                }
                if(i>len) break;
                for(int j=round+1;j<n-round;j++){
                    matrix[j][n-round-1]=i++;
                }
                if(i>len) break;
                for(int j=n-round-2;j>=round;j--){
                    matrix[n-round-1][j]=i++;
                }
                if(i>len) break;
                for(int j=n-round-2;j>=round+1;j--){
                    matrix[j][round]=i++;
                }
                round++;
            }
            return matrix;
        }
    }
}