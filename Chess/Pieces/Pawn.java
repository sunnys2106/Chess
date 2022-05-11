package Pieces;

public class Pawn extends Piece {
    public Pawn(int player) {
        super("pawn", player);
    }

    @Override
    public boolean[][] showPossibleMoves(int y, int x, Square[][] squares) {
        boolean[][] validMoves = new boolean[8][8];
        if (squares[y][x].piece.player == 2) {
            if (!squares[y + 1][x].hasPiece) {
                validMoves[y + 1][x] = true;
                if (y == 1 && !squares[y + 2][x].hasPiece) {
                    validMoves[y + 2][x] = true;
                }
            }
            if (x + 1 < 8 && squares[y + 1][x + 1].hasPiece && squares[y + 1][x + 1].piece.player == 1) {
                validMoves[y + 1][x + 1] = true;
            }
            if (x - 1 >= 0 && squares[y + 1][x - 1].hasPiece && squares[y + 1][x - 1].piece.player == 1) {
                validMoves[y + 1][x - 1] = true;
            }
        } else {
            if (!squares[y - 1][x].hasPiece) {
                validMoves[y - 1][x] = true;
                if (y == 6 && !squares[y - 2][x].hasPiece) {
                    validMoves[y - 2][x] = true;
                }
            }
            if (x + 1 < 8 && squares[y - 1][x + 1].hasPiece && squares[y - 1][x + 1].piece.player == 2) {
                validMoves[y - 1][x + 1] = true;
            }
            if (x - 1 >= 0 && squares[y - 1][x - 1].hasPiece && squares[y - 1][x - 1].piece.player == 2) {
                validMoves[y - 1][x - 1] = true;
            }
        }
        return validMoves;
    }

}
