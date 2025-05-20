package model;

public class Knight extends Piece {

    public Knight(boolean white, Position position) {
        super(white, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        int dx = Math.abs(position.getColumn() - newPosition.getColumn());
        int dy = Math.abs(position.getRow() - newPosition.getRow());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
