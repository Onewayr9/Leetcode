public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return true;
        else if(board.length==0||board[0].length==0) return false;
        else{
            boolean[][] discovered = new boolean[board.length][board[0].length];
            return exist(board,word,0,0,0,word.length(),discovered);}
    }
    public boolean exist(char[][] board,String word,int begin,int row,int col,int len,boolean[][] discovered){
        if(begin==len||(board[row][col]==word.charAt(begin)&&begin==len-1)) return true;
        else{
            for(int i = row;i<board.length;i++){
                for(int j = col;j<board[0].length;j++){
                    if(board[i][j]==word.charAt(begin)){
                        discovered[i][j] = true;
                        boolean ret = false;
                        if(i>0&&discovered[i-1][j]==false) ret = ret||exist(board,word,begin+1,i-1,j,len,discovered);
                        if(i<board.length-1&&discovered[i+1][j]==false) ret = ret||exist(board,word,begin+1,i+1,j,len,discovered);
                        if(j>0&&discovered[i][j-1]==false) ret = ret||exist(board,word,begin+1,i,j-1,len,discovered);
                        if(j<board[0].length-1&&discovered[i][j+1]==false) ret = ret||exist(board,word,begin+1,i,j+1,len,discovered);
                        if(ret==true) return true;
                        else if(begin!=0) {
                            discovered[i][j] = false;
                            return false;}
                        else discovered[i][j] = false;
                    }else if(begin!=0) return false;
                }
            }
        }
        return false;
    }
}