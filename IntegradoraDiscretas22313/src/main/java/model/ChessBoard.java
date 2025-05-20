package model;

import structures.MyLinkedList;

public class ChessBoard {
    private MyLinkedList<Piece> pieces;

    public ChessBoard() {
        pieces = new MyLinkedList<>();
        initialize();
    }

    private void initialize() {
        // White pieces
        pieces.add(new Rook(true, new Position(7, 0)));
        pieces.add(new Knight(true, new Position(7, 1)));
        pieces.add(new Bishop(true, new Position(7, 2)));
        pieces.add(new Queen(true, new Position(7, 3)));
        pieces.add(new King(true, new Position(7, 4)));
        pieces.add(new Bishop(true, new Position(7, 5)));
        pieces.add(new Knight(true, new Position(7, 6)));
        pieces.add(new Rook(true, new Position(7, 7)));
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(true, new Position(6, i)));
        }

        // Black pieces
        pieces.add(new Rook(false, new Position(0, 0)));
        pieces.add(new Knight(false, new Position(0, 1)));
        pieces.add(new Bishop(false, new Position(0, 2)));
        pieces.add(new Queen(false, new Position(0, 3)));
        pieces.add(new King(false, new Position(0, 4)));
        pieces.add(new Bishop(false, new Position(0, 5)));
        pieces.add(new Knight(false, new Position(0, 6)));
        pieces.add(new Rook(false, new Position(0, 7)));
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(false, new Position(1, i)));
        }
    }

    public MyLinkedList<Piece> getPieces() {
        return pieces;
    }

    public Piece getPieceAt(Position position) {
        for (int i = 0; i < pieces.size(); i++) {
            Piece piece = pieces.get(i);
            if (piece.getPosition().equals(position)) {
                return piece;
            }
        }
        return null;
    }

    public void movePiece(Piece piece, Position newPosition) {
        Piece target = getPieceAt(newPosition);
        if (target != null) {
            removePiece(target);
        }
        piece.setPosition(newPosition);
    }

    public void removePiece(Piece piece) {
        MyLinkedList<Piece> newList = new MyLinkedList<>();
        for (int i = 0; i < pieces.size(); i++) {
            Piece p = pieces.get(i);
            if (!p.equals(piece)) {
                newList.add(p);
            }
        }
        pieces = newList;
    }
}
