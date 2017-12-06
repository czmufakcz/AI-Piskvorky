import java.awt.Point;
import java.util.ArrayList;

public class Minimax {
    private PIECE_TYPE realTurn;
    public static Point computerMove;

    public Minimax(PIECE_TYPE piece) {
        this.realTurn = piece;
    }



    /**
     * Returns the best move given the state of the game
     */
    public int minimax(int depth, PIECE_TYPE turn, State state) {
        if (state.isEnd())
            return eval(state);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        ArrayList<Point> moves = state.getMoves();

        for (Point move : moves) {
            State clone = new State(state);

            if (turn == realTurn) {
                clone.setMove(turn, move);
                int currentScore = minimax(depth + 1, PIECE_TYPE.getReverseTurn(turn), clone);
                max = Math.max(currentScore, max);
                
                if (currentScore >= 0) {
                    if (depth == 0)
                        computerMove = move;
                }

                if (moves.get(moves.size() - 1) == move && max < 0) {
                    if (depth == 0)
                        computerMove = move;
                }

            } else {
                clone.setMove(turn, move);
                int currentScore = minimax(depth + 1, PIECE_TYPE.getReverseTurn(turn), clone);
                min = Math.min(currentScore, min);
            }

       
        }

        return turn == realTurn ? max : min;
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
            return 1;
        else
            return -1;
    }

}
