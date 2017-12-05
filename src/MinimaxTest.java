import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

public class MinimaxTest {

    @Test
    public void test() {
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.O, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.X, CELL_TYPE.EMPTY, CELL_TYPE.O } };

        State state = new State(board);
        Point point = minimax.minimax(state);
        state.setMove(PIECE_TYPE.O, point);

        assertEquals(PIECE_TYPE.O, state.winner());
    }

    @Test
    public void test1() {
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.EMPTY },
                { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.EMPTY, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY } };

        State state = new State(board);
        Point point = minimax.minimax(state);
        state.setMove(PIECE_TYPE.O, point);

        assertEquals(PIECE_TYPE.O, state.winner());
    }

    @Test
    public void test2() {
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.O, CELL_TYPE.X, CELL_TYPE.EMPTY },
                { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.O },
                { CELL_TYPE.EMPTY, CELL_TYPE.X, CELL_TYPE.EMPTY } };

        State state = new State(board);
        Point point = minimax.minimax(state);
        state.setMove(PIECE_TYPE.O, point);

        assertEquals(PIECE_TYPE.O, state.winner());
    }

    @Test
    public void test3() {
        Minimax minimax = new Minimax(PIECE_TYPE.X);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.O, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.X, CELL_TYPE.EMPTY, CELL_TYPE.O } };

        State state = new State(board);
        Point point = minimax.minimax(state);
        state.setMove(PIECE_TYPE.X, point);

        assertEquals(PIECE_TYPE.DRAW, state.winner());
    }

    @Test
    public void test4() {
        Minimax minimax = new Minimax(PIECE_TYPE.X);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.EMPTY },
                { CELL_TYPE.EMPTY, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.EMPTY, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY } };

        State state = new State(board);
        Point point = minimax.minimax(state);
        state.setMove(PIECE_TYPE.X, point);

        assertEquals(PIECE_TYPE.DRAW, state.winner());
    }

}
