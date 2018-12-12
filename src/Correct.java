import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Correct extends JFrame {
    private JButton buttonNext;

    public Correct(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);
        setResizable(false);

        createView();
        setVisible(true);

    }

    public void createView(){
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JLabel congrats = new JLabel();
        congrats.setFont(new Font("Cambria", Font.BOLD, 80));
        congrats = new JLabel("You've answered correctly!");

        panel.add(congrats);

        buttonNext = new JButton("next one");
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level2 ab = new Level2();
                ab.setVisible(true);
            }
        });

        panel.add(buttonNext);

    }


}
