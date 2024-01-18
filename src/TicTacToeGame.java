import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame implements TicTacToeModel{
    private char[][] board;
    private char currentPlayer;
    private boolean gameWon;
    private boolean gameDraw;

    public TicTacToeGame() {
        board = new char[3][3];
        currentPlayer ='X';
    }

    @Override
    public void makeMove(int row, int col) {
        if (board[row][col] == '\0' && !gameWon && !gameDraw) {
            board[row][col] = currentPlayer;
            checkForWin(row, col);
            if(!gameWon)
            {
                checkForDraw();
            }

            switchPlayer();
        }
    }

    private void switchPlayer() {
        if (!gameWon) {
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
        }

    }




    private void checkForWin(int row, int col) {

//        Check row

        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
            gameWon = true;
        }
        // Check column
        else if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
            gameWon = true;
        }
        // Check diagonals
        else if ((row == col || row + col == 2) && (
                (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                        (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer))) {
            gameWon = true;
        }
    }


    private void checkForDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return;
                }
            }
        }
        gameDraw=true;
    }

    @Override
    public boolean isGameOver() {
        return gameWon || gameDraw;
    }

    @Override
    public boolean isDraw() {
        return gameDraw;
    }

    @Override
    public char getWinner() {
        if (gameWon) {
            return currentPlayer;
        } else {
            return '\0';
        }

    }

    public char[][] getBoard() {
        return board;
    }

    public void reset() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameWon = false;
        gameDraw = false;
    }
}
