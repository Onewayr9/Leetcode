import java.util.HashSet;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0].length!=9)
            return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j]-'0'))
                        return false;
                    else set.add(board[i][j]-'0');
                }
            }
            set.clear();
        }
        for(int j=0;j<9;j++){
            for(int i=0;i<9;i++){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j]-'0'))
                        return false;
                    else set.add(board[i][j]-'0');
                }
            }
            set.clear();
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int t=3*i;t<3*i+3;t++){
                    for(int k=3*j;k<3*j+3;k++){
                        if(board[t][k]!='.'){
                            if(set.contains(board[t][k]-'0')) return false;
                            else set.add(board[t][k]-'0');
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}