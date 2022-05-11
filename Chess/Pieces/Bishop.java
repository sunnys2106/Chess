package Pieces;

public class Bishop extends Piece {
    public Bishop(int player) {
        super("bishop", player);
    }

    @Override
    public boolean[][] showPossibleMoves(int y, int x, Square[][] squares) {
        boolean[][] validMoves = new boolean[8][8];
        int p = 1;
        if (squares[y][x].piece.player == 1) {
            p = 2;
        }
        for (int i = 1; y - i >= 0 && x + i < 8; i++) {// right-up
            if (!squares[y - i][x + i].hasPiece) {
                validMoves[y - i][x + i] = true;
            } else if (squares[y - i][x + i].piece.player == p) {
                validMoves[y - i][x + i] = true;
                break;
            } else {
                break;
            }
        }
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {// left-up
            if (!squares[y - i][x - i].hasPiece) {
                validMoves[y - i][x - i] = true;
            } else if (squares[y - i][x - i].piece.player == p) {
                validMoves[y - i][x - i] = true;
                break;
            } else {
                break;
            }
        }
        for (int i = 1; x + i < 8 && y + i < 8; i++) {// right-down
            if (!squares[y + i][x + i].hasPiece) {
                validMoves[y + i][x + i] = true;
            } else if (squares[y + i][x + i].piece.player == p) {
                validMoves[y + i][x + i] = true;
                break;
            } else {
                break;
            }
        }
        for (int i = 1; y + i < 8 && x - i >= 0; i++) {// left-down
            if (!squares[y + i][x - i].hasPiece) {
                validMoves[y + i][x - i] = true;
            } else if (squares[y + i][x - i].piece.player == p) {
                validMoves[y + i][x - i] = true;
                break;
            } else {
                break;
            }
        }

        return validMoves;
    }

}
