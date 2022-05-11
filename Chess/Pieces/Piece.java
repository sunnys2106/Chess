package Pieces;

public abstract class Piece {
    public String type;
    public int player; // 1-white, 2-black

    public Piece(String type, int player) {
        this.type = type;
        this.player = player;
    }

    public boolean validMove(boolean[][] possibleMoves, int y, int x) {
        return possibleMoves[y][x] == true;
    }

    public abstract boolean[][] showPossibleMoves(int y, int x, Square[][] squares);
}
