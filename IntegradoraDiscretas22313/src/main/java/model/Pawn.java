package model;

public class Pawn extends Piece {

    public Pawn(boolean white, Position position) {
        super(white, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        int direction = white ? -1 : 1;
        return newPosition.getColumn() == position.getColumn() &&
                newPosition.getRow() == position.getRow() + direction;
    }
}
