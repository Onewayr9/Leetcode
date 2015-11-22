public class NumMatrix {
    int[][] dpmatrix;
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            dpmatrix = matrix;
        }else{
            int m=matrix.length;
            int n=matrix[0].length;
            dpmatrix = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0&&j==0){
                        dpmatrix[i][j] = matrix[0][0];
                    }else if(i==0){
                        dpmatrix[i][j] = dpmatrix[i][j-1] + matrix[i][j];
                    }else if(j==0){
                        dpmatrix[i][j] = dpmatrix[i-1][j] + matrix[i][j];
                    }else{
                        dpmatrix[i][j] = dpmatrix[i-1][j] + dpmatrix[i][j-1] - dpmatrix[i-1][j-1] + matrix[i][j];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = 0,top = 0, leftop = 0;
        if(row1==0&&col1==0){
            return dpmatrix[row2][col2];
        }else if(row1==0){
            left = dpmatrix[row2][col1-1];
        }else if(col1==0){
            top = dpmatrix[row1-1][col2];
        }else{
            left = dpmatrix[row2][col1-1];
            top = dpmatrix[row1-1][col2];
            leftop = dpmatrix[row1-1][col1-1];
        }
        return dpmatrix[row2][col2] - left - top + leftop;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);