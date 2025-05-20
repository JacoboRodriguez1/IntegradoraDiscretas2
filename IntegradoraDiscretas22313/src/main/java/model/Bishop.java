package model;

public class Bishop extends Piece {

    public Bishop(boolean white, Position position) {
        super(white, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        return Math.abs(position.getColumn() - newPosition.getColumn()) ==
                Math.abs(position.getRow() - newPosition.getRow());
    }
}
