import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StateTest {

    @Test
    public void test() {
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.O, CELL_TYPE.O, CELL_TYPE.O },
                { CELL_TYPE.EMPTY, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY },
                { CELL_TYPE.EMPTY, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY } };
                
                
        State state = new State(board);
        assertTrue(state.isRowWin(CELL_TYPE.O));
        assertFalse(state.isColumnWin(CELL_TYPE.O));
        assertFalse(state.isDiagonalWin(CELL_TYPE.O));
    }

    @Test
    public void test1() {
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.O, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY },
                { CELL_TYPE.O, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY },
                { CELL_TYPE.O, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY } };

        State state = new State(board);
        assertFalse(state.isRowWin(CELL_TYPE.O));
        assertTrue(state.isColumnWin(CELL_TYPE.O));
        assertFalse(state.isDiagonalWin(CELL_TYPE.O));
    }

    @Test
    public void test2() {
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.O, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY },
                { CELL_TYPE.EMPTY, CELL_TYPE.O, CELL_TYPE.EMPTY },
                { CELL_TYPE.EMPTY, CELL_TYPE.EMPTY, CELL_TYPE.O } };

        State state = new State(board);
        assertFalse(state.isRowWin(CELL_TYPE.O));
        assertFalse(state.isColumnWin(CELL_TYPE.O));
        assertTrue(state.isDiagonalWin(CELL_TYPE.O));
    }

    @Test
    public void test3() {
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.EMPTY, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY },
                { CELL_TYPE.O, CELL_TYPE.O, CELL_TYPE.O },
                { CELL_TYPE.EMPTY, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY } };

        State state = new State(board);
        assertTrue(state.isRowWin(CELL_TYPE.O));
        assertFalse(state.isColumnWin(CELL_TYPE.O));
        assertFalse(state.isDiagonalWin(CELL_TYPE.O));
    }

    @Test
    public void test4() {
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.EMPTY, CELL_TYPE.O, CELL_TYPE.EMPTY },
                { CELL_TYPE.EMPTY, CELL_TYPE.O, CELL_TYPE.EMPTY },
                { CELL_TYPE.EMPTY, CELL_TYPE.O, CELL_TYPE.EMPTY } };

        State state = new State(board);
        assertFalse(state.isRowWin(CELL_TYPE.O));
        assertTrue(state.isColumnWin(CELL_TYPE.O));
        assertFalse(state.isDiagonalWin(CELL_TYPE.O));
    }

    @Test
    public void test5() {
        CELL_TYPE board[][] = new CELL_TYPE[][] { { CELL_TYPE.EMPTY, CELL_TYPE.EMPTY, CELL_TYPE.O },
                { CELL_TYPE.EMPTY, CELL_TYPE.O, CELL_TYPE.EMPTY },
                { CELL_TYPE.O, CELL_TYPE.EMPTY, CELL_TYPE.EMPTY } };

        State state = new State(board);
        assertFalse(state.isRowWin(CELL_TYPE.O));
        assertFalse(state.isColumnWin(CELL_TYPE.O));
        assertTrue(state.isDiagonalWin(CELL_TYPE.O));
    }

}
