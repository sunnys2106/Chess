package Pieces;

public class Queen extends Piece {
    public Queen(int player) {
        super("queen", player);
    }

    @Override
    public boolean[][] showPossibleMoves(int y, int x, Square[][] squares) {
        boolean[][] validMoves = new boolean[8][8];
        int p = 1;
        if (squares[y][x].piece.player == 1) {
            p = 2;
        }
        // vertical moves
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

        // diagonal moves
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
