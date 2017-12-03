import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Game {
    private Position posittion = new Position();
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
                    button.setFont(new Font(null, Font.PLAIN, 100));
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
                            button.setText("" + game.posittion.getTurn());
                            game.move(idx);
                            if (!game.posittion.gameEnd()) {
                                int best = game.posittion.bestMove();
                                buttons[best].setText("" + game.posittion.getTurn());
                                game.move(best);

                            }
                            if (game.posittion.gameEnd()) {
                                String message = "";
                                if (game.posittion.win('x')) {
                                    message = "You won";

                                } else if (game.posittion.win('o')) {
                                    message = "Computer won";
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

    private void move(int idx) {
        posittion = posittion.move(idx);
    }

}
