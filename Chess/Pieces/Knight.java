package Pieces;

public class Knight extends Piece {
    public Knight(int player) {
        super("knight", player);
    }

    @Override
    public boolean[][] showPossibleMoves(int y, int x, Square[][] squares) {
        boolean[][] validMoves = new boolean[8][8];
        int p = 1;
        if (squares[y][x].piece.player == 1) {
            p = 2;
        }
        if (y + 2 < 8) {// bottom right inner
            if (x + 1 < 8 && (!squares[y + 2][x + 1].hasPiece || squares[y + 2][x + 1].piece.player == p)) {
                validMoves[y + 2][x + 1] = true;
            } // bottom left inner
            if (x - 1 >= 0 && (!squares[y + 2][x - 1].hasPiece || squares[y + 2][x - 1].piece.player == p)) {
                validMoves[y + 2][x - 1] = true;
            }
        }
        if (y - 2 >= 0) {// top right inner
            if (x + 1 < 8 && (!squares[y - 2][x + 1].hasPiece || squares[y - 2][x + 1].piece.player == p)) {
                validMoves[y - 2][x + 1] = true;
            } // top left inner
            if (x - 1 >= 0 && (!squares[y - 2][x - 1].hasPiece || squares[y - 2][x - 1].piece.player == p)) {
                validMoves[y - 2][x - 1] = true;
            }
        }
        if (x + 2 < 8) {// top right outer
            if (y - 1 >= 0 && (!squares[y - 1][x + 2].hasPiece || squares[y - 1][x + 2].piece.player == p)) {
                validMoves[y - 1][x + 2] = true;
            } // bottom right outer
            if (y + 1 < 8 && (!squares[y + 1][x + 2].hasPiece || squares[y + 1][x + 2].piece.player == p)) {
                validMoves[y + 1][x + 2] = true;
            }
        }
        if (x - 2 >= 0) {// top left outer
            if (y - 1 >= 0 && (!squares[y - 1][x - 2].hasPiece || squares[y - 1][x - 2].piece.player == p)) {
                validMoves[y - 1][x - 2] = true;
            } // bottom left outer
            if (y + 1 < 8 && (!squares[y + 1][x - 2].hasPiece || squares[y + 1][x - 2].piece.player == p)) {
                validMoves[y + 1][x - 2] = true;
            }
        }

        return validMoves;
    }
}
