package MyStuff.TicTactoeGame;


public class Board {
    private int size;
    private int maxMoves;
    private String[][] board;
    private int moveCount = 0;

    public Board(int size, int maxMoves) {
        this.size = size;
        this.maxMoves = size*size;
        this.board = new String[size][size];

    }


    public boolean isMoveValid(int row, int col, Player player) {
        return board[row][col] == null;
    }

    public void makeMove(int row, int col, Player player) {
        this.board[row][col] = player.getPiece();
        moveCount++;
        showBoard();
    }

    public boolean hasPlayerWon(int row, int col, Player player) {
        return (allRows(row,  player) || allCol( col, player) || isDiagonal(row, col, player)
        || isNegDiagonal(row,col,player));
    }

    private boolean isNegDiagonal(int row, int col, Player player) {
        if (row + col > size)
            return false;

        for (int j = size-1, i = 0; j >= 0 && i < size;i++,j--) {
                if(board[j][i]!=player.getPiece())
                    return false;
        }    
        return true;
    }


    private boolean isDiagonal(int row, int col, Player player) {
        if (row != col)
            return false;
        for (int i = 0, j = 0; i < size && j < size; i++, j++) {
            if (board[i][j] != player.getPiece()) {
                return false;
            }
        }
        return true;
    }
    
    private void showBoard(){
        for(int i=0; i< board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==null){
                    System.out.print("- ");
                }else {
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
        }
    }


    private boolean allCol(int col, Player player) {

        for (int i = 0; i < size; i++) {
                if(board[i][col] != player.getPiece())
                    return false;
        }
        return true;
    }


    private boolean allRows(int row, Player player) {
        for (int i = 0; i < size; i++) {
            if(board[row][i] != player.getPiece())
                return false;
    }
    return true;
    }


    public boolean noValidMovesLeft(int row, int col, Player player) {
        return maxMoves == moveCount;
    }


    
}
