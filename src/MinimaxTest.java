import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class MinimaxTest {

    @Test
    public void test() {
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.O, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.X, CELL_TYPE._, CELL_TYPE.O } };

        State state = new State(board);
        minimax.minimax(0, PIECE_TYPE.O, state);
        state.setMove(PIECE_TYPE.O, Minimax.computerMove);

        assertEquals(PIECE_TYPE.O, state.winner());
    }

    @Test
    public void test1() {
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE._ },
                { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ } };

        State state = new State(board);
        minimax.minimax(0, PIECE_TYPE.O, state);
        state.setMove(PIECE_TYPE.O, Minimax.computerMove);

        assertEquals(PIECE_TYPE.O, state.winner());
    }

    @Test
    public void test2() {
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.O, CELL_TYPE.X, CELL_TYPE._ },
                { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.O },
                { CELL_TYPE._, CELL_TYPE.X, CELL_TYPE._ } };

        State state = new State(board);
        minimax.minimax(0, PIECE_TYPE.O, state);
        state.setMove(PIECE_TYPE.O, Minimax.computerMove);

        assertEquals(PIECE_TYPE.O, state.winner());
    }

    @Test
    public void test3() {
        Minimax minimax = new Minimax(PIECE_TYPE.X);

        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.O, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE.X, CELL_TYPE._, CELL_TYPE.O } };

        State state = new State(board);
        minimax.minimax(0, PIECE_TYPE.X, state);
        state.setMove(PIECE_TYPE.X, Minimax.computerMove);

        assertEquals(PIECE_TYPE.DRAW, state.winner());
    }

    @Test
    public void test4() {
        // VARIANTA B START X
        Minimax minimax = new Minimax(PIECE_TYPE.X);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ } };

        State state = new State(board);

        // X
        minimax.minimax(0, PIECE_TYPE.X, state);
        state.setMove(PIECE_TYPE.X, Minimax.computerMove);
        System.out.println(state.toString());
        System.out.println("");
        assertTrue(state.isBlocked(new Point(1, 2), CELL_TYPE.X));

        // O
        minimax.setPieceType(PIECE_TYPE.O);
        minimax.minimax(0, PIECE_TYPE.O, state);
        state.setMove(PIECE_TYPE.O, Minimax.computerMove);
        System.out.println(state.toString());
        System.out.println("");

        // X
        minimax.setPieceType(PIECE_TYPE.X);
        minimax.minimax(0, PIECE_TYPE.X, state);
        state.setMove(PIECE_TYPE.X, Minimax.computerMove);
        System.out.println(state.toString());
        System.out.println("");

        // O
        minimax.setPieceType(PIECE_TYPE.O);
        minimax.minimax(0, PIECE_TYPE.O, state);
        state.setMove(PIECE_TYPE.O, Minimax.computerMove);
        System.out.println(state.toString());
        System.out.println("");

        // X
        minimax.setPieceType(PIECE_TYPE.X);
        minimax.minimax(0, PIECE_TYPE.X, state);
        state.setMove(PIECE_TYPE.X, Minimax.computerMove);
        System.out.println(state.toString());
        System.out.println("");

        assertEquals(PIECE_TYPE.DRAW, state.winner());

    }

    @Test
    public void test5() {
        // VARIANTA B START O WIN po prvnim tahu
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ } };

        State state = new State(board);

        // O
        minimax.minimax(0, PIECE_TYPE.O, state);
        state.setMove(PIECE_TYPE.O, Minimax.computerMove);
        System.out.println(state.toString());
        System.out.println("");

        assertEquals(PIECE_TYPE.O, state.winner());

    }

    @Test
    public void test6() {
        // VARIANTA C START X - REMIZA
        Minimax minimax = new Minimax(PIECE_TYPE.X);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.O, CELL_TYPE.X, CELL_TYPE._ },
                { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.O },
                { CELL_TYPE._, CELL_TYPE.X, CELL_TYPE._ } };

        State state = new State(board);

        // X
        minimax.minimax(0, PIECE_TYPE.X, state);
        state.setMove(PIECE_TYPE.X, Minimax.computerMove);
        System.out.println(state.toString());
        System.out.println("");

        // O
        minimax.minimax(0, PIECE_TYPE.O, state);
        state.setMove(PIECE_TYPE.O, Minimax.computerMove);
        System.out.println(state.toString());
        System.out.println("");

        // X
        minimax.minimax(0, PIECE_TYPE.X, state);
        state.setMove(PIECE_TYPE.X, Minimax.computerMove);
        System.out.println(state.toString());
        System.out.println("");

        assertEquals(PIECE_TYPE.O, state.winner());

    }

}
