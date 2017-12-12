import java.awt.Point;
import java.util.ArrayList;

public class Minimax {
    private PIECE_TYPE realTurn;
    public static Point computerMove;

    public Minimax(PIECE_TYPE piece) {
        this.realTurn = piece;
    }

    public void setPieceType(PIECE_TYPE realTurn) {
        this.realTurn = realTurn;
    }


    /**
     * Returns the best move given the state of the game
     */
    public int minimax(PIECE_TYPE turn, State state) {
        if (state.isEnd())
            return eval(state);

        if (turn == realTurn) {
            int max = Integer.MIN_VALUE;
            ArrayList<Point> moves = state.getMoves();
            for (Point move : moves) {
                State clone = new State(state);
                clone.setMove(turn, move);
                int currentScore = minimax(PIECE_TYPE.getReverseTurn(turn), clone);
                max = Math.max(currentScore, max);
            }
            return max;

        } else {
            int min = Integer.MAX_VALUE;
            ArrayList<Point> moves = state.getMoves();
            for (Point move : moves) {
                State clone = new State(state);
                clone.setMove(turn, move);
                int currentScore = minimax(PIECE_TYPE.getReverseTurn(turn), clone);
                min = Math.min(currentScore, min);
            }
            return min;
        }
       
    }

    public Point bestMove(PIECE_TYPE turn, State state) {
        int max = -1;
        int min = +1;
        Point maxMove = null;
        Point minMove = null;
        ArrayList<Point> moves = state.getMoves();
        for (Point move : moves) {
            State clone = new State(state);
            clone.setMove(turn, move);
            int value = minimax(PIECE_TYPE.getReverseTurn(turn), clone);
            if (value >= max) {
                max = value;
                maxMove = move;
            }
            if (value < min) {
                min = value;
                minMove = move;
            }
            System.out.println(value);

        }
        if (Math.abs(min) < max) {
            return maxMove;
        } else if (max == 0) {
            return maxMove;
        } else {
            return minMove;
        }

    }

    /**
     * Returns 1 if the AI is the winner
     */
    private int eval(State state) {
        PIECE_TYPE piece = state.winner();
        if (piece == PIECE_TYPE.DRAW) {
            return 0;
        }
        if (piece == this.realTurn)
            return 10;
        else
            return -10;
    }

    public PIECE_TYPE pieceType() {
        return realTurn;
    }

}
