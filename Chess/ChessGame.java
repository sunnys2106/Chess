
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;

import Pieces.*;

public class ChessGame implements ActionListener {
    JFrame frame;
    JPanel titlePanel;
    JPanel buttonPanel;
    JLabel textField;
    JButton[][] buttons;

    boolean whiteTurn;
    int selectedY;
    int selectedX;
    boolean[][] validMoves;
    Square[][] squares;
    boolean gameOver;

    Color DarkChessSquare = new Color(252, 209, 159);
    Color White = new Color(255, 255, 255);
    Color LightGreen = new Color(127, 240, 125);
    Color DarkGreen = new Color(58, 140, 56);
    Color Red = new Color(242, 137, 131);

    public ChessGame() {
        // init gui components
        frame = new JFrame();
        titlePanel = new JPanel();
        buttonPanel = new JPanel();
        textField = new JLabel();
        // each square on the chess board will be represented by a button
        buttons = new JButton[8][8];

        whiteTurn = true;
        selectedX = -1;
        selectedY = -1;
        validMoves = new boolean[8][8];
        // holds the information for each board piece
        squares = new Square[8][8];
        gameOver = false;

        // more setting up gui
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(8 * 75, 8 * 75 + 100);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setVisible(true);

        buttonPanel.setLayout(new GridLayout(8, 8));
        boolean blackSquare = false;
        // adds all buttons to the buttons list
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                buttonPanel.add(buttons[i][j]);
                buttons[i][j].setOpaque(true);
                buttons[i][j].setBorderPainted(false);
                if (blackSquare) {
                    buttons[i][j].setBackground(DarkChessSquare);
                    squares[i][j] = new Square(2);
                } else {
                    buttons[i][j].setBackground(White);
                    squares[i][j] = new Square(1);
                }
                blackSquare = !blackSquare;
                buttons[i][j].setFocusable(false);
                buttons[i][j].setRolloverEnabled(false);
                buttons[i][j].addActionListener(this);
            }
            blackSquare = !blackSquare;
        }
        // add all icons to buttons
        try {
            BufferedImage img = ImageIO.read(new File("Chess/images/whiteRook.png"));
            buttons[7][0].setIcon(new ImageIcon(img));
            buttons[7][7].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/blackRook.png"));
            buttons[0][0].setIcon(new ImageIcon(img));
            buttons[0][7].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/whiteKnight.png"));
            buttons[7][1].setIcon(new ImageIcon(img));
            buttons[7][6].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/blackKnight.png"));
            buttons[0][1].setIcon(new ImageIcon(img));
            buttons[0][6].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/whiteBishop.png"));
            buttons[7][2].setIcon(new ImageIcon(img));
            buttons[7][5].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/blackBishop.png"));
            buttons[0][2].setIcon(new ImageIcon(img));
            buttons[0][5].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/whiteQueen.png"));
            buttons[7][3].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/blackQueen.png"));
            buttons[0][3].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/whiteKing.png"));
            buttons[7][4].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/blackKing.png"));
            buttons[0][4].setIcon(new ImageIcon(img));
            img = ImageIO.read(new File("Chess/images/blackPawn.png"));
            for (int i = 0; i < 8; i++) {
                buttons[1][i].setIcon(new ImageIcon(img));
            }
            img = ImageIO.read(new File("Chess/images/whitePawn.png"));
            for (int i = 0; i < 8; i++) {
                buttons[6][i].setIcon(new ImageIcon(img));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        // add text
        textField.setFont(new Font("Verdana", Font.PLAIN, 40));
        textField.setOpaque(true);
        textField.setText("White Turn");
        textField.setHorizontalAlignment(JLabel.CENTER);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 8 * 75, 100);
        titlePanel.add(textField);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        // update the squares with pieces in them
        squares[0][0] = new Square(new Rook(2), true, 1, 1);
        squares[0][7] = new Square(new Rook(2), true, 2, 2);
        squares[0][1] = new Square(new Knight(2), true, 2, 2);
        squares[0][6] = new Square(new Knight(2), true, 1, 1);
        squares[0][2] = new Square(new Bishop(2), true, 1, 1);
        squares[0][5] = new Square(new Bishop(2), true, 2, 2);
        squares[0][3] = new Square(new Queen(2), true, 2, 2);
        squares[0][4] = new Square(new King(2), true, 1, 1);
        for (int i = 0; i < 8; i++) {
            int a;
            if (i % 2 == 0) {
                a = 2;
            } else {
                a = 1;
            }
            squares[1][i] = new Square(new Pawn(2), true, a, a);
        }
        squares[7][0] = new Square(new Rook(1), true, 2, 2);
        squares[7][7] = new Square(new Rook(1), true, 1, 1);
        squares[7][1] = new Square(new Knight(1), true, 1, 1);
        squares[7][6] = new Square(new Knight(1), true, 2, 2);
        squares[7][2] = new Square(new Bishop(1), true, 2, 2);
        squares[7][5] = new Square(new Bishop(1), true, 1, 1);
        squares[7][3] = new Square(new Queen(1), true, 1, 1);
        squares[7][4] = new Square(new King(1), true, 2, 2);
        for (int i = 0; i < 8; i++) {
            int a;
            if (i % 2 == 0) {
                a = 1;
            } else {
                a = 2;
            }
            squares[6][i] = new Square(new Pawn(1), true, a, a);
        }
    }

    // redraws all squares on the board with their colors
    public void redrawSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (squares[i][j].color) {
                    case 1:
                        buttons[i][j].setBackground(White);
                        break;
                    case 2:
                        buttons[i][j].setBackground(DarkChessSquare);
                        break;
                    case 3:
                        buttons[i][j].setBackground(DarkGreen);
                        break;
                    case 4:
                        buttons[i][j].setBackground(LightGreen);
                        break;
                    case 5:
                        buttons[i][j].setBackground(Red);
                        break;
                }

            }
        }
    }

    // changes all squares to their original colors
    public void resetAllColors() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j].color = squares[i][j].defaultColor;
            }
        }
    }

    // changes valid move squares to different colors
    public void updatePossibleMoveSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (validMoves[i][j]) {
                    if (!squares[i][j].hasPiece) {
                        squares[i][j].color = 4;
                    } else {
                        squares[i][j].color = 5;
                    }
                }
            }
        }
    }

    // handle a move. Takes the x and y of the square the player wants to move to
    public void move(int x, int y) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (validMoves[i][j] && i == y && j == x) {
                    resetAllColors();
                    redrawSquares();

                    squares[y][x].hasPiece = true;
                    squares[y][x].piece = squares[selectedY][selectedX].piece;

                    BufferedImage img;
                    String player = "black", pieceType = "";
                    if (squares[selectedY][selectedX].piece.player == 1) {
                        player = "white";
                    }
                    switch (squares[selectedY][selectedX].piece.type) {
                        case "bishop":
                            pieceType = "Bishop";
                            break;
                        case "king":
                            pieceType = "King";
                            break;
                        case "knight":
                            pieceType = "Knight";
                            break;
                        case "pawn":
                            pieceType = "Pawn";
                            break;
                        case "queen":
                            pieceType = "Queen";
                            break;
                        case "rook":
                            pieceType = "Rook";
                            break;
                    }
                    try {
                        img = ImageIO.read(new File("Chess/images/" + player + pieceType + ".png"));
                        buttons[y][x].setIcon(new ImageIcon(img));
                        buttons[selectedY][selectedX].setIcon(null);
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }

                    squares[selectedY][selectedX].hasPiece = false;
                    squares[selectedY][selectedX].piece = null;
                    selectedX = -1;
                    selectedY = -1;

                    whiteTurn = !whiteTurn;
                    if (whiteTurn) {
                        textField.setText("White Turn");
                    } else {
                        textField.setText("Black Turn");
                    }
                    checkGameOver();
                    return;
                }
            }
        }
    }

    // changes square colors and valid move highlightingw when player clicks on
    // their own piece
    public void updateSquareColors(int x, int y) {
        if (selectedY == y && selectedX == x) {
            resetAllColors();
            redrawSquares();
            selectedX = -1;
            selectedY = -1;
            return;
        }
        if ((whiteTurn && squares[y][x].piece.player == 1)
                || (!whiteTurn && squares[y][x].piece.player == 2)) {
            resetAllColors();
            squares[y][x].color = 3;
            validMoves = squares[y][x].piece.showPossibleMoves(y, x, squares);
            updatePossibleMoveSquares();
            redrawSquares();
            selectedY = y;
            selectedX = x;
            return;
        }
    }

    // check if game is over by looking for a missing king
    public void checkGameOver() {
        int kings = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (squares[i][j].hasPiece && squares[i][j].piece.type == "king") {
                    kings++;
                }
            }
        }
        if (kings != 2) {
            if (whiteTurn) {
                textField.setText("Black Wins");
            } else {
                textField.setText("White Wins");
            }
            gameOver = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (e.getSource() == buttons[i][j] && selectedX != -1 && selectedY != -1) {
                        move(j, i);
                    }
                    if (e.getSource() == buttons[i][j] && squares[i][j].hasPiece) {
                        updateSquareColors(j, i);
                    }
                }
            }
        }
    }
}