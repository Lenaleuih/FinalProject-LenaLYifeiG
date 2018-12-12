import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wrong extends JFrame {

    private JButton buttonNext, buttonGoBack;

    public Wrong() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Wrong answer");

        createView();
        setVisible(true);

    }

    public void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JLabel congrats = new JLabel();
        congrats.setFont(new Font("Cambria", Font.BOLD, 80));
        congrats = new JLabel("Sorry, you didn't get it right.");

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

        buttonGoBack = new JButton("go back");
        buttonGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level1 ab = new Level1();
                ab.setVisible(true);
            }
        });
        panel.add(buttonGoBack);

    }


}


