package model;

public abstract class Piece {
    protected boolean white;
    protected Position position;

    public Piece(boolean white, Position position) {
        this.white = white;
        this.position = position;
    }

    public boolean isWhite() {
        return white;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract boolean isValidMove(Position newPosition);
}
