import java.awt.Point;
import java.util.ArrayList;

public class Minimax {
    private PIECE_TYPE piece;

    public Minimax(PIECE_TYPE piece) {
        this.piece = piece;
    }

    /**
     * Returns the best move given the state of the game
     */
    public Point minimax(State state) {
        Point bestMove = null;
        int highestScore = Integer.MIN_VALUE;

        ArrayList<Point> moves = state.getMoves();
        int score = 0;
        for (Point move : moves) {
            State clone = new State(state);
            clone.setMove(PIECE_TYPE.O, move);
            score = min(clone);
            if (score > highestScore) {
                highestScore = score;
                bestMove = move;
            }
        }

        return bestMove;
    }

    /**
     * Returns the lowest score received by the min player
     */
    private int min(State state) {
        if (state.isEnd())
            return eval(state);

        int lowestScore = Integer.MAX_VALUE;

        ArrayList<Point> moves = state.getMoves();
        int score = 0;
        for (Point move : moves) {
            State clone = new State(state);
            clone.setMove(PIECE_TYPE.X, move);
            score = max(clone);
            if (score < lowestScore)
                lowestScore = score;
        }

        return lowestScore;
    }

    /**
     * Returns the highest score received by the max player
     */
    private int max(State state) {
        if (state.isEnd())
            return eval(state);

        int highestScore = Integer.MIN_VALUE;

        ArrayList<Point> moves = state.getMoves();
        int score = 0;
        for (Point move : moves) {
            State clone = new State(state);
            clone.setMove(PIECE_TYPE.O, move);
            score = min(clone);
            if (score > highestScore)
                highestScore = score;
        }

        return highestScore;
    }

    /**
     * Returns 1 if the AI is the winner
     */
    private int eval(State state) {
        PIECE_TYPE piece = state.winner();
        if (state.getMoves().size() == 0) {
            return 0;
        }

        if (piece == this.piece.O)
            return 1;
        else
            return -1;
    }

}
