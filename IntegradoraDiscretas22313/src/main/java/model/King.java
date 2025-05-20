package model;

public class King extends Piece {

    public King(boolean white, Position position) {
        super(white, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        int dx = Math.abs(position.getColumn() - newPosition.getColumn());
        int dy = Math.abs(position.getRow() - newPosition.getRow());
        return dx <= 1 && dy <= 1;
    }
}
