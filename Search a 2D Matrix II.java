public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1])
            return false;
        int [][] square = transferToSquare(matrix,target);
        return isFind(square,target);
    }
    public boolean isFind(int[][] square, int target) {
        int begin = 0;
        int end = square.length-1;
        int mid = (begin+end)/2;
        while(begin<end){
            mid = (begin+end)/2;
            if(target<=square[mid][mid]&&target>square[mid-1][mid-1])
                break;
            else if(target>square[mid][mid]){
                begin = mid+1;
            }else if(target<square[mid][mid]){
                end = mid-1;
            }
        }
        if(target==square[mid][mid])
            return true;
        else{
            begin = 0;
            end = mid;
            int midd = (begin+end)/2;
            while(begin<end){
                midd = (begin+end)/2;
                if(square[mid][midd]==target)
                    return true;
                else if(target>square[mid][midd]){
                    begin = midd+1;
                }else if(target<square[mid][midd]){
                    end = midd-1;
                }
            }
            if(square[mid][midd]==target)
                return true;
            begin = 0;
            end = mid;
            midd = (begin+end)/2;
            while(begin<end){
                midd = (begin+end)/2;
                if(square[midd][mid]==target)
                    return true;
                else if(target>square[midd][mid]){
                    begin = midd+1;
                }else if(target<square[midd][mid]){
                    end = midd-1;
                }
            }
            return (square[midd][mid]==target);
        }
        return false;
    }
    public int[][] transferToSquare(int[][] matrix,int target){
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] ans;
        if(row>column){
            int i=column-1;
            while(i<row){
                if(target<matrix[i][column-1])
                    break;
                else i++;
            }
            int[][] square = Arrays.copyOfRange(matrix,i-column+1,i);
            ans = square;
        }else if(row<column){
            int i=row-1;
            while(i<column){
                if(target<matrix[row-1][i])
                    break;
                else i++;
            }
            int[][] square = new int[row][row];
            for(int j=0;j<row;j++){
                square[j] = Arrays.copyOfRange(matrix[j],i-row+1,i);
            }
            ans = square;
        }else ans = matrix;
        return ans;
    }
}