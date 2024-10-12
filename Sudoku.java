class sudoku{
class solution{
    public boolean issafe(char [][]board,int r,int c,int n){
        for(int i=0;i<board.length;i++){
            if(board[i][c]==(char)(n+'0')){
                return false;

            }
        }
        for(int j=0;j<board.length;j++){
            if(board[r][j]==(char)(n+'0')){
                return false;
            }
        }
        int sr=3*(r/3);
        int sc=3*(c/3);
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==(char)(n+'0')){
                    return false;

                }
            }
        }
        return true;
    }
    public boolean helper(char [][]board,int r,int c){
        if(r==board.length){
            return true;
        }
        int r1=0;
        int c1=0;
        if(c!=board.length-1){
            r1=r;
            c1=c+1;
        }
        else{
            r1=r+1;
            c1=0;
        }
        if(board[r][c]!='.'){
            if(helper(board,r1,c1)){
            return true;}
        }
        else{
            for(int i=1;i<9;i++){
                if(issafe(board,r,c,i)){
                    board[r][c]=(char)(i+'0');
                    if(helper(board, r1, c1)){
                        return true;
                    }
                    else{
                        board[r][c]='.';
                    }
                }
            }
        }
        return false;

    }
    public void sudoku(char [][] board){
        helper(board, 0, 0);

    }
}
}
