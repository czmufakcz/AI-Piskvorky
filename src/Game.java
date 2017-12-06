import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Game {
    private State state;
    private PIECE_TYPE piece = PIECE_TYPE.O;
    private static Game instance = null;

    private Game() {
        state = new State();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Java TTT");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(3, 3));
                final Game game = new Game();
                final JButton[] buttons = new JButton[9];
                for (int i = 0; i < 9; i++) {
                    final int idx = i;
                    final JButton button = new JButton();
                    buttons[i] = button;
                    button.setPreferredSize(new Dimension(100, 100));
                    button.setBackground(Color.WHITE);
                    button.setOpaque(true);
                    button.setFont(new Font(null, Font.PLAIN, 50));
                    button.addMouseListener(new MouseListener() {

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            Game game = Game.getInstance();
                            button.setText("" + game.piece);
                            game.state.setMove(game.piece, getPointIn2DArray(idx));
                            if (!game.state.isEnd()) {
                                Minimax minimax = new Minimax(PIECE_TYPE.getReverseTurn(game.piece));
                                minimax.minimax(0, PIECE_TYPE.getReverseTurn(game.piece), game.state);
                                game.state.setMove(PIECE_TYPE.getReverseTurn(game.piece), Minimax.computerMove);
                                buttons[Minimax.computerMove.x * 3 + Minimax.computerMove.y].setText("" + PIECE_TYPE.getReverseTurn(game.piece));
                            }
                            if (game.state.isEnd()) {
                                String message = "";
                                if (game.state.winner() == PIECE_TYPE.O) {
                                    message = "WIN O";

                                } else if (game.state.winner() == PIECE_TYPE.X) {
                                    message = "WIN X";
                                } else {
                                    message = "Draw";
                                }

                                JOptionPane.showMessageDialog(null, message);

                            }
                        }
                    });
                    frame.add(button);
                }
                frame.pack();
                frame.setVisible(true);

            }
        });

    }

    public static Point getPointIn2DArray(int index) {
        return new Point(index / 3, index % 3);

    }


}
