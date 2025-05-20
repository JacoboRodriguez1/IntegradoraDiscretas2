package model;

public class Rook extends Piece {

    public Rook(boolean white, Position position) {
        super(white, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        return newPosition.getRow() == position.getRow() || newPosition.getColumn() == position.getColumn();
    }
}
