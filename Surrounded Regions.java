public class Solution {
    Queue<Integer> queue = new LinkedList<Integer>();
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0) return;
        else{
            for(int i=0;i<board[0].length;i++){
                //System.out.println(board[0][i]);
                if(board[0][i]=='O') bfs(board,0,i);
                if(board[board.length-1][i]=='O') bfs(board,board.length-1,i);
            }
            for(int i=1;i<board.length-1;i++){
                if(board[i][0]=='O') bfs(board,i,0);
                if(board[i][board[0].length-1]=='O') bfs(board,i,board[0].length-1);
            }
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]=='O') board[i][j] = 'X';
                    else if(board[i][j]=='#') board[i][j] = 'O';
                }
            }
        }
    }
    public void bfs(char[][] board,int i,int j){
        int n = board[0].length;
        queueFill(board,i,j);
        while(!queue.isEmpty()){
            int num = queue.poll();
            int row = num/n;
            int col = num%n;
            queueFill(board,row-1,col);
            queueFill(board,row+1,col);
            queueFill(board,row,col-1);
            queueFill(board,row,col+1);
        }
    }
    public void queueFill(char[][] board,int i,int j){
        int m = board.length;
		int n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
			return;
		queue.offer(i*n+j);
		board[i][j] = '#';
    }
}