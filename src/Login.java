import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;


public class Login extends JFrame {
    private JButton buttonLogin, buttonSignup;
    private JTextField username, password;
    private String inputUsername, inputPassword;
    private Scanner x;
    private File user = new File("user.txt");

    public Login() {
        setTitle("word shuffle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        createView();
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        //North
        JPanel panelNorth = new JPanel(new BorderLayout());
        panel.add(panelNorth, BorderLayout.NORTH);
        panelNorth.add(new JLabel("Welcome back to word shuffle!"), BorderLayout.WEST);

        //Center
        JPanel panelCenter = new JPanel(new GridBagLayout());
        panel.add(panelCenter);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;

        panelCenter.add(new JLabel("username: "), c);
        c.gridy++;
        panelCenter.add(new JLabel("password: "), c);
        c.gridy++;

        c.gridx = 1;
        c.gridy = 0;

        username = new JTextField(8);
        panelCenter.add(username, c);
        username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputUsername = username.getText();
            }
        });

        c.gridy++;

        password = new JTextField(8);
        panelCenter.add(password, c);
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPassword = password.getText();
            }
        });

        //South
        JPanel panelSouth = new JPanel();
        panel.add(panelSouth, BorderLayout.SOUTH);

        buttonLogin = new JButton("login");
        panelSouth.add(buttonLogin);

        buttonSignup = new JButton("signup");
        panelSouth.add(buttonSignup);


        buttonSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                Signup ab = new Signup();
                ab.setVisible(true);


            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                String tempUsername = "";
                String tempPassword = "";

                try {
                    x = new Scanner(user);
                    x.useDelimiter("[,\n]");

                    while (x.hasNext() && !found) {
                        tempUsername = x.next();
                        tempPassword = x.next();

                        if (tempUsername.trim().equals(inputUsername.trim())
                                && tempPassword.trim().equals(inputPassword.trim())) {
                            found = true;
                        }
                    }
                    x.close();
                    dispose();
                    Level1 ab = new Level1();
                    ab.setVisible(true);
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "invalid " +
                            "login details", "login error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });

    }


}











