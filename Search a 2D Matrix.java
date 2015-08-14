public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        else if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1])
            return false;
        int column = findColumn(matrix,target,0,matrix.length-1);
        if(target>matrix[column][matrix[column].length-1])
            return false;
        return isFind(matrix[column],target,0,matrix[column].length-1);
    }
    public int findColumn(int[][] matrix, int target, int begin, int end){
        if(begin==end)
            return begin;
        int mid = (begin+end)/2;
        if(target>=matrix[mid][0]&&target<matrix[mid+1][0])
            return mid;
        else if(target>=matrix[mid][0]){
            return findColumn(matrix,target,mid+1,end);
        }
        else if(target<matrix[mid][0]){
            return findColumn(matrix,target,begin,mid-1);
        }
        return mid;
    }
    public boolean isFind(int[] array, int target, int begin, int end){
        if(begin==end)
            return target==array[begin];
        int mid = (end+begin)/2;
        if(target==array[mid])
            return true;
        else if(target>array[mid]){
            if(target>array[end])
                return false;
            else
                return isFind(array,target,mid+1,end);
        }
        else if(target<array[mid]){
            if(target<array[begin])
                return false;
            else
                return isFind(array,target,begin,mid-1);
        }
        return false;
    }
}