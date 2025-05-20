package ui;
import model.GameController;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import model.GameController;
import model.Piece;
import model.Position;
import structures.MyLinkedList;

public class ChessBoardView extends GridPane {

    private GameController controller;
    private Position selectedPosition = null;

    public ChessBoardView(GameController controller) {
        this.controller = controller;
        drawBoard();
    }

    private void drawBoard() {
        this.getChildren().clear();
        MyLinkedList<Piece> pieces = controller.getBoard().getPieces();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                StackPane cell = new StackPane();
                Rectangle square = new Rectangle(240, 135);
                square.setFill((row + col) % 2 == 0 ? Color.BEIGE : Color.DARKGRAY);
                cell.getChildren().add(square);

                Piece piece = controller.getBoard().getPieceAt(new Position(row, col));
                if (piece != null) {
                    Text text = new Text(getPieceSymbol(piece));
                    cell.getChildren().add(text);
                }

                final int r = row, c = col;
                cell.setOnMouseClicked(e -> handleClick(r, c));
                this.add(cell, col, row);
            }
        }
    }

    private void handleClick(int row, int col) {
        Position clicked = new Position(row, col);
        if (selectedPosition == null) {
            Piece piece = controller.getBoard().getPieceAt(clicked);
            if (piece != null && piece.isWhite() == controller.isWhiteTurn()) {
                selectedPosition = clicked;
            }
        } else {
            boolean moved = controller.move(selectedPosition, clicked);
            selectedPosition = null;
            if (moved) drawBoard();
        }
    }

    private String getPieceSymbol(Piece piece) {
        String symbol = "";
        if (piece.getClass().getSimpleName().equals("Pawn")) symbol = "P";
        else if (piece.getClass().getSimpleName().equals("Rook")) symbol = "R";
        else if (piece.getClass().getSimpleName().equals("Knight")) symbol = "N";
        else if (piece.getClass().getSimpleName().equals("Bishop")) symbol = "B";
        else if (piece.getClass().getSimpleName().equals("Queen")) symbol = "Q";
        else if (piece.getClass().getSimpleName().equals("King")) symbol = "K";

        return piece.isWhite() ? symbol : symbol.toLowerCase();
    }
}
