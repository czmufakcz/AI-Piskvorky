import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class State {
    private final int WIDTH = 3;
    private final int HEIGHT = 3;
    private CELL_TYPE board[][];

    public State() {
        board = new CELL_TYPE[WIDTH][HEIGHT];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = CELL_TYPE._;
            }
        }
    }

    public State(CELL_TYPE board[][]) {
        this.board = board;
    }

    public State(State state) {
        board = new CELL_TYPE[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i++) {
            this.board[i] = Arrays.copyOf(state.board[i], state.board[i].length);
        }
    }

    public ArrayList<Point> getMoves() {
        ArrayList<Point> listMoves = new ArrayList<>();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == CELL_TYPE._) {
                    listMoves.add(new Point(j, i));
                }
            }
        }
        return listMoves;
    }

    public boolean isEnd() {
        //DRAW
        if(getMoves().size() == 0){
            return true;
        }
        //ROW
        if(isRowWin(CELL_TYPE.X)){
            return true;
        }
        if(isRowWin(CELL_TYPE.O)){
            return true;
        }
        //COLUMN
        if(isColumnWin(CELL_TYPE.X)){
            return true;
        }
        
        if(isColumnWin(CELL_TYPE.O)){
            return true;
        }
        // DIAGONAL
        if (isDiagonalWin(CELL_TYPE.X)) {
            return true;
        }
        if (isDiagonalWin(CELL_TYPE.O)) {
            return true;
        }
        
        // DRAW
        if (getMoves().size() == 0) {
            return true;
        }

        return false;
    }

    public boolean isColumnWin(CELL_TYPE cellType) {
        for (int i = 0; i < WIDTH; i++) {
            if (board[0][i] == cellType && board[1][i] == cellType && board[2][i] == cellType) {
                return true;
           }
        }
        return false;
    }

    public boolean isRowWin(CELL_TYPE cellType) {
        for (int i = 0; i < HEIGHT; i++) {
            if (board[i][0] == cellType && board[i][1] == cellType && board[i][2] == cellType) {
                return true;
            }
        }
        return false;
    }

    public boolean isDiagonalWin(CELL_TYPE cellType) {
        return (board[0][0] == cellType && board[1][1] == cellType && board[2][2] == cellType) || (board[2][0] == cellType && board[1][1] == cellType && board[0][2] == cellType);
    }


    public PIECE_TYPE winner() {

        // ROW
        if (isRowWin(CELL_TYPE.X)) {
            return PIECE_TYPE.X;
        }
        if (isRowWin(CELL_TYPE.O)) {
            return PIECE_TYPE.O;
        }
        // COLUMN
        if (isColumnWin(CELL_TYPE.X)) {
            return PIECE_TYPE.X;
        }

        if (isColumnWin(CELL_TYPE.O)) {
            return PIECE_TYPE.O;
        }
        // DIAGONAL
        if (isDiagonalWin(CELL_TYPE.X)) {
            return PIECE_TYPE.X;
        }
        if (isDiagonalWin(CELL_TYPE.O)) {
            return PIECE_TYPE.O;
        }
        return PIECE_TYPE.DRAW;
    }

    public void setMove(PIECE_TYPE piece, Point point) {
        if (board[point.y][point.x] != CELL_TYPE._) {
            throw new IllegalArgumentException("This cordinate is no empty.");
        }

        switch (piece) {
        case O:
            board[point.y][point.x] = CELL_TYPE.O;
            break;
        case X:
            board[point.y][point.x] = CELL_TYPE.X;
            break;

        default:
            break;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            stringBuilder.append("{");
            for (int j = 0; j < HEIGHT; j++) {
                stringBuilder.append(board[i][j] + " , ");
            }
            stringBuilder.append("}" + System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public boolean isBlocked(Point point, CELL_TYPE cell) {
        return board[point.y][point.x] == cell;
    }
}
