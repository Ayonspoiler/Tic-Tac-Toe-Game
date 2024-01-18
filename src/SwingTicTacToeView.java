import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwingTicTacToeView implements TicTacToeView {
    private TicTacToeModel model;

    private JFrame frame;
    private JButton[][] buttons;

    public SwingTicTacToeView(TicTacToeModel model) {
       this.model=model;
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttons = new JButton[3][3];
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(row, col);
                    }
                });
                container.add(buttons[i][j]);
            }
        }


        frame.setVisible(true);
    }



    private void handleButtonClick(int row, int col) {
        model.makeMove(row, col);
        updateView();
        if (model.isGameOver()) {
            showResult();
        }
    }
    @Override
    public void updateView() {
        char[][] board = model.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(String.valueOf(board[i][j]));
            }
        }
    }

    @Override
    public void showResult() {
        if (model.isDraw()) {
            JOptionPane.showMessageDialog(frame, "It's a draw!");
        } else {
            char winner= model.getWinner();
            JOptionPane.showMessageDialog(frame, "Player " + winner + " wins!");
        }
        model.reset();
        updateView();
    }








}
