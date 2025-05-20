package model;

public class Queen extends Piece {

    public Queen(boolean white, Position position) {
        super(white, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        boolean straight = newPosition.getRow() == position.getRow() || newPosition.getColumn() == position.getColumn();
        boolean diagonal = Math.abs(position.getColumn() - newPosition.getColumn()) ==
                Math.abs(position.getRow() - newPosition.getRow());
        return straight || diagonal;
    }
}
