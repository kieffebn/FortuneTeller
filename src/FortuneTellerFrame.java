
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;

public class FortuneTellerFrame extends JFrame
{

    JPanel main = new JPanel();
    JPanel controlPnl = new JPanel();
    JPanel scrollPnl = new JPanel();
    ImageIcon icon = new ImageIcon("src/ball.png");
    JLabel titleLbl = new JLabel("Fortune Teller!",icon, JLabel.CENTER);

    JButton quitBtn = new JButton("Quit");
    JButton fortuneBtn = new JButton("Read My Fortune!");

    JTextArea displayArea = new JTextArea(20, 40);
    JScrollPane scroller = new JScrollPane(displayArea);


    public class previousValue {
        public static int prev;
    }

    public FortuneTellerFrame()
    {
        titleLbl.setFont(new Font("Times New Roman", Font.ITALIC, 36));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 16));
        quitBtn.setFont(new Font("Sans Serif", Font.BOLD, 12));
        fortuneBtn.setFont(new Font("Sans Serif", Font.BOLD, 12));
        setTitle("Fortune Teller");
        setSize(1440, 810);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createGUI();
        enableButtons();

        setVisible(true);
    }


    public static void main(String[] args)
    {
        FortuneTellerFrame frame = new FortuneTellerFrame();
        frame.setLocationRelativeTo(null);
    }

    private void createGUI()
    {
        main.setLayout(new BorderLayout());

        controlPnl.setLayout(new GridLayout(1,4 ));  // 1 row 4 columns

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);
        titleLbl.setFont(new Font("Serif", Font.PLAIN, 24));

        scrollPnl.add(scroller);

        main.add(BorderLayout.NORTH, titleLbl);
        main.add(BorderLayout.CENTER, scrollPnl);
        main.add(BorderLayout.SOUTH, controlPnl);

        add(main);
    }

    private void enableButtons()
    {


        fortuneBtn.addActionListener
                (
                        e -> {
                            String[] fortunes = {
                                    "You will win a lifetime supply of q-tips!",
                                    "You will always gag at the smell of fresh linen!",
                                    "Riches are in your future!",
                                    "I sense love in your future!",
                                    "You will be crossed by a gaggle of angry geese!",
                                    "Never Gonna Give You Up will be the permanent song in your head!",
                                    "Surprise! You forgot how to code... good luck!",
                                    "You will be the court jester for our robot conquerors!",
                                    "You will die of dysentery, yikes!",
                                    "Great fortune awaits you!",
                                    "You will be the next music star!",
                                    "You will switch bodies with Danny DeVito, Freaky Friday style!"
                            };
                            int current;

                            Random rnd = new Random();
                            current = rnd.nextInt(12);

                            if (current == previousValue.prev && current >= 1) {
                                    current --;


                            } else {
                                current --;
                            }

                            displayArea.append(fortunes[current] + "\n");
                            previousValue.prev = current;

                        }
                );

        quitBtn.addActionListener
                (
                        (ActionEvent ae) -> System.exit(0)
                );
    }

}
