package model;

public class GameController {
    private ChessBoard board;
    private boolean whiteTurn;

    public GameController() {
        board = new ChessBoard();
        whiteTurn = true;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    public boolean move(Position from, Position to) {
        Piece piece = board.getPieceAt(from);
        if (piece == null) return false;
        if (piece.isWhite() != whiteTurn) return false;
        if (!piece.isValidMove(to)) return false;

        Piece destinationPiece = board.getPieceAt(to);
        if (destinationPiece != null && destinationPiece.isWhite() == whiteTurn) {
            return false;
        }

        board.movePiece(piece, to);
        whiteTurn = !whiteTurn;
        return true;
    }
}
