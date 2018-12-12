import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Signup extends JFrame{

    private JButton buttonSubmit, buttonPrevious;
    private JTextField username, password1, password2;
    private String inputUsername, inputPassword1, inputPassword2;
    private File user = new File("user.txt");

    public Signup() {
        createView();

        setTitle("word shuffle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }


    private void createView() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        //North
        JPanel panelNorth = new JPanel(new BorderLayout());
        panel.add(panelNorth, BorderLayout.NORTH);
        panelNorth.add(new JLabel("Welcome to word shuffle!"), BorderLayout.WEST);


        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;


        //Center
        JPanel panelCenter = new JPanel(new GridBagLayout());
        panel.add(panelCenter);

        panelCenter.add(new JLabel("username: "), c);
        c.gridy++;
        panelCenter.add(new JLabel("password: "), c);
        c.gridy++;
        panelCenter.add(new JLabel("confirm password: "), c);
        c.gridy++;

        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        username = new JTextField(8);
        panelCenter.add(username, c);

        username.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputUsername = username.getText();
            }
        });
        c.gridy++;

        password1 = new JTextField(8);
        panelCenter.add(password1, c);
        password1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPassword1 = password1.getText();
            }
        });
        c.gridy++;

        password2 = new JTextField(8);
        panelCenter.add(password2, c);
        password2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPassword2 = password2.getText();
            }
        });

        c.gridy++;

        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        panelCenter.add(new JLabel("(only letters, please) "), c);
        c.gridy++;
        panelCenter.add(new JLabel("(only numbers, please) "), c);
        c.gridy++;

        //South
        JPanel panelSouth = new JPanel();
        panel.add(panelSouth, BorderLayout.SOUTH);

        buttonSubmit = new JButton("submit");
        panelSouth.add(buttonSubmit);

        buttonPrevious = new JButton("previous");
        panelSouth.add(buttonPrevious);

        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    FileWriter fileWriter = new FileWriter(user, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    if (inputPassword1.equals(inputPassword2)) {
                        bufferedWriter.write(inputUsername + "," + inputPassword1+"\n");
                        bufferedWriter.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "no the same" +
                                "password", "register error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "invalid " +
                            "login details", "register error", JOptionPane.ERROR_MESSAGE);
                }

                dispose();
                Login ab = new Login();
                ab.setVisible(true);


            }

        });

        buttonPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login ab = new Login();
                ab.setVisible(true);
            }
        });

    }




//    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt){
//        File user = new File("user.txt");
//        try {
//            if(!user.exists()&&inputPassword1.equals(inputPassword2)){
//                user.createNewFile();
//            }
//            FileWriter fileWriter = new FileWriter(user, true);
//
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(inputUsername+","+inputPassword1);
//            bufferedWriter.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "invalid " +
//                    "login details","register error", JOptionPane.ERROR_MESSAGE);
//        }
//
//
//
//        this.dispose();
//    }


}
