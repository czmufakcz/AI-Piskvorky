import java.awt.Point;
import java.util.ArrayList;

public class Minimax {
    private PIECE_TYPE turn;

    public Minimax(PIECE_TYPE piece) {
        this.turn = piece;
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
            score = min(clone, 0);
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
    private int min(State state, int depth) {
        if (state.isEnd())
            return eval(state, depth);

        int lowestScore = Integer.MAX_VALUE;

        ArrayList<Point> moves = state.getMoves();
        int score = 0;
        for (Point move : moves) {
            State clone = new State(state);
            clone.setMove(PIECE_TYPE.X, move);
            score = max(clone, ++depth);
            if (score < lowestScore)
                lowestScore = score;
        }

        return lowestScore;
    }

    /**
     * Returns the highest score received by the max player
     */
    private int max(State state, int depth) {
        if (state.isEnd())
            return eval(state, depth);

        int highestScore = Integer.MIN_VALUE;

        ArrayList<Point> moves = state.getMoves();
        int score = 0;
        for (Point move : moves) {
            State clone = new State(state);
            clone.setMove(PIECE_TYPE.O, move);
            score = min(clone, ++depth);
            if (score > highestScore)
                highestScore = score;
        }

        return highestScore;
    }

    /**
     * Returns 1 if the AI is the winner
     */
    private int eval(State state, int depth) {
        PIECE_TYPE piece = state.winner();
        if (piece == PIECE_TYPE.DRAW) {
            return 0;
        }
        if (piece == this.turn)
            return 1 - depth;
        else
            return depth - 1;
    }

}
