import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimaxTest {

    @Test
    public void test2() {
        // VARIANTA A START X -> REMIZA
        Minimax minimax = new Minimax(PIECE_TYPE.X);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ } };

        State state = new State(board);

        while (!state.isEnd()) {

            if (minimax.pieceType() == PIECE_TYPE.X) {
                // X
                state.setMove(PIECE_TYPE.X, minimax.bestMove(PIECE_TYPE.X, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.O);
            } else {
                // O
                state.setMove(PIECE_TYPE.O, minimax.bestMove(PIECE_TYPE.O, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.X);
            }

        }

        assertEquals(PIECE_TYPE.DRAW, state.winner());

    }

    @Test
    public void test3() {
        // VARIANTA A START O -> REMIZA
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ } };

        State state = new State(board);

        while (!state.isEnd()) {

            if (minimax.pieceType() == PIECE_TYPE.X) {
                // X
                state.setMove(PIECE_TYPE.X, minimax.bestMove(PIECE_TYPE.X, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.O);
            } else {
                // O
                state.setMove(PIECE_TYPE.O, minimax.bestMove(PIECE_TYPE.O, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.X);
            }

        }

        assertEquals(PIECE_TYPE.DRAW, state.winner());

    }

    @Test
    public void test4() {
        // VARIANTA B START X -> REMIZA
        Minimax minimax = new Minimax(PIECE_TYPE.X);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ } };

        State state = new State(board);

        while (!state.isEnd()) {

            if (minimax.pieceType() == PIECE_TYPE.X) {
                // X
                state.setMove(PIECE_TYPE.X, minimax.bestMove(PIECE_TYPE.X, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.O);
            } else {
                // O
                state.setMove(PIECE_TYPE.O, minimax.bestMove(PIECE_TYPE.O, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.X);
            }

        }

        assertEquals(PIECE_TYPE.DRAW, state.winner());

    }

    @Test
    public void test5() {
        // VARIANTA B START -> O WIN
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE.O, CELL_TYPE.X },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE._ } };

        State state = new State(board);

        while (!state.isEnd()) {

            if (minimax.pieceType() == PIECE_TYPE.X) {
                // X
                state.setMove(PIECE_TYPE.X, minimax.bestMove(PIECE_TYPE.X, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.O);
            } else {
                // O
                state.setMove(PIECE_TYPE.O, minimax.bestMove(PIECE_TYPE.O, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.X);
            }

        }

        assertEquals(PIECE_TYPE.O, state.winner());

    }

    @Test
    public void test6() {
        // VARIANTA C START X -> REMIZA
        Minimax minimax = new Minimax(PIECE_TYPE.X);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.O, CELL_TYPE.X, CELL_TYPE._ },
                { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.O },
                { CELL_TYPE._, CELL_TYPE.X, CELL_TYPE._ } };

        State state = new State(board);

        while (!state.isEnd()) {

            if (minimax.pieceType() == PIECE_TYPE.X) {
                // X
                state.setMove(PIECE_TYPE.X, minimax.bestMove(PIECE_TYPE.X, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.O);
            } else {
                // O
                state.setMove(PIECE_TYPE.O, minimax.bestMove(PIECE_TYPE.O, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.X);
            }

        }

        assertEquals(PIECE_TYPE.DRAW, state.winner());

    }

    @Test
    public void test7() {
        // VARIANTA C START O -> O WIN
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.O, CELL_TYPE.X, CELL_TYPE._ },
                { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE.O },
                { CELL_TYPE._, CELL_TYPE.X, CELL_TYPE._ } };

        State state = new State(board);

        while (!state.isEnd()) {

            if (minimax.pieceType() == PIECE_TYPE.X) {
                // X
                state.setMove(PIECE_TYPE.X, minimax.bestMove(PIECE_TYPE.X, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.O);
            } else {
                // O
                state.setMove(PIECE_TYPE.O, minimax.bestMove(PIECE_TYPE.O, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.X);
            }

        }
        assertEquals(PIECE_TYPE.O, state.winner());

    }

    @Test
    public void test8() {
        // VARIANTA D START O -> REMIZA
        Minimax minimax = new Minimax(PIECE_TYPE.O);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE._ },
                { CELL_TYPE.O, CELL_TYPE.X, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE.O } };

        State state = new State(board);

        while (!state.isEnd()) {

            if (minimax.pieceType() == PIECE_TYPE.X) {
                // X
                state.setMove(PIECE_TYPE.X, minimax.bestMove(PIECE_TYPE.X, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.O);
            } else {
                // O
                state.setMove(PIECE_TYPE.O, minimax.bestMove(PIECE_TYPE.O, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.X);
            }

        }

        assertEquals(PIECE_TYPE.DRAW, state.winner());

    }

    @Test
    public void test9() {
        // VARIANTA D START X -> X WIN
        Minimax minimax = new Minimax(PIECE_TYPE.X);
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.X, CELL_TYPE.O, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE.X, CELL_TYPE._ },
                { CELL_TYPE._, CELL_TYPE._, CELL_TYPE.O } };

        State state = new State(board);

        while (!state.isEnd()) {

            if (minimax.pieceType() == PIECE_TYPE.X) {
                // X
                state.setMove(PIECE_TYPE.X, minimax.bestMove(PIECE_TYPE.X, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.O);
            } else {
                // O
                state.setMove(PIECE_TYPE.O, minimax.bestMove(PIECE_TYPE.O, state));
                System.out.println(state.toString());
                System.out.println("");
                minimax.setPieceType(PIECE_TYPE.X);
            }

        }


        assertEquals(PIECE_TYPE.X, state.winner());
    }

}
