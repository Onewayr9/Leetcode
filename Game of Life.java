public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length==0||board[0].length==0){
            return;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int liveNumber = countLiveNeighbor(i,j,board);
                if((liveNumber<2||liveNumber>3)&&board[i][j]==1){
                    board[i][j] = 2;
                }
                if(liveNumber==3&&board[i][j]==0){
                    board[i][j] = 3;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==2){
                    board[i][j] = 0;
                }
                if(board[i][j]==3){
                    board[i][j] = 1;
                }
            }
        }
    }
    public int countLiveNeighbor(int i,int j,int[][] board){
        int ans = 0;
        if(i>0&&j>0){
            ans+=num(board[i-1][j]);
            ans+=num(board[i][j-1]);
            ans+=num(board[i-1][j-1]);
        }else if(i>0){
            ans+=num(board[i-1][j]);
        }else if(j>0){
            ans+=num(board[i][j-1]);
        }
        if(i<board.length-1&&j<board[0].length-1){
            ans+=num(board[i+1][j]);
            ans+=num(board[i][j+1]);
            ans+=num(board[i+1][j+1]);
        }else if(i<board.length-1){
            ans+=num(board[i+1][j]);
        }else if(j<board[0].length-1){
            ans+=num(board[i][j+1]);
        }
        if(i>0&&j<board[0].length-1){
            ans+=num(board[i-1][j+1]);
        }
        if(i<board.length-1&&j>0){
            ans+=num(board[i+1][j-1]);
        }
        return ans;
    }
    public int num(int i){
        if(i==1||i==2) return 1;
        else return 0;
    }
}