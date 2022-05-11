package Pieces;

public class Rook extends Piece {
    public Rook(int player) {
        super("rook", player);
    }

    @Override
    public boolean[][] showPossibleMoves(int y, int x, Square[][] squares) {
        boolean[][] validMoves = new boolean[8][8];
        int p = 1;
        if (squares[y][x].piece.player == 1) {
            p = 2;
        }
        for (int i = x - 1; i >= 0; i--) {// left
            if (!squares[y][i].hasPiece) {
                validMoves[y][i] = true;
            } else if (squares[y][i].piece.player == p) {
                validMoves[y][i] = true;
                break;
            } else {
                break;
            }
        }
        for (int i = x + 1; i < 8; i++) {// right
            if (!squares[y][i].hasPiece) {
                validMoves[y][i] = true;
            } else if (squares[y][i].piece.player == p) {
                validMoves[y][i] = true;
                break;
            } else {
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {// down
            if (!squares[i][x].hasPiece) {
                validMoves[i][x] = true;
            } else if (squares[i][x].piece.player == p) {
                validMoves[i][x] = true;
                break;
            } else {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {// up
            if (!squares[i][x].hasPiece) {
                validMoves[i][x] = true;
            } else if (squares[i][x].piece.player == p) {
                validMoves[i][x] = true;
                break;
            } else {
                break;
            }
        }

        return validMoves;
    }
}
