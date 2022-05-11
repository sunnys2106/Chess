package Pieces;

public class Square {
    public boolean hasPiece = false;
    public Piece piece = null;
    public int color; // 1-white, 2-black,3 - darkGreen, 4 - lightGreen, 5-red
    public int defaultColor; // 1-white, 2-black

    public Square(Piece piece, boolean hasPiece, int color, int defaultColor) {
        this.piece = piece;
        this.hasPiece = hasPiece;
        this.color = color;
        this.defaultColor = defaultColor;
    }

    public Square(int color) {
        this.color = color;
        this.defaultColor = color;
    }
}
