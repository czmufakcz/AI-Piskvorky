
public enum PIECE_TYPE {
    X, O, DRAW;

    static PIECE_TYPE getReverseTurn(PIECE_TYPE turn){
        switch (turn) {
        case X:
            return O;
        case O:
            return X;
         
        default:
            throw new IllegalArgumentException("DRAW is not valid value.");
        }
    }

}
