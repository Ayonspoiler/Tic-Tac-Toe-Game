import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public interface TicTacToeModel {
    void makeMove(int row, int col);

    boolean isGameOver();

    boolean isDraw();

    char getWinner();
    char[][] getBoard();  // Add this method to the interface

    void reset();


}
