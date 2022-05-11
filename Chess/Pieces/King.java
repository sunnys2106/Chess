package Pieces;

public class King extends Piece {
    public King(int player) {
        super("king", player);
    }

    @Override
    public boolean[][] showPossibleMoves(int y, int x, Square[][] squares) {
        boolean[][] validMoves = new boolean[8][8];
        int p = 1;
        if (squares[y][x].piece.player == 1) {
            p = 2;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == y + 1 || i == y - 1 || i == y) && (j == x + 1 || j == x - 1 || j == x)) {
                    if (squares[i][j].hasPiece == false || squares[i][j].piece.player == p) {
                        validMoves[i][j] = true;
                    }
                }
            }
        }
        return validMoves;
    }

}
