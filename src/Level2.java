import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Level2 extends JFrame {
    private JButton buttonNext, buttonSubmit;
    private JTextField answer;
    private String inputWord;
    private PromptViewer2 fourBlocks= new PromptViewer2();
    public static int i = 1;
    public Question q = Question.readQuestion().get(i);


    public Level2() {
        setTitle("word shuffle");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setPreferredSize(new Dimension(800,600));

        createView();
        setVisible(true);
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);


        //North
        JPanel panelNorth = new JPanel();
        panel.add(panelNorth, BorderLayout.NORTH);
        panelNorth.add(new JLabel("Instruction: spell the word correctly with the letters below You'll earn one " +
                "point for one correctly spelled word!"));

        //center
        JPanel panelCenter = new JPanel();
        panel.add(panelCenter, BorderLayout.CENTER);

        fourBlocks.setPreferredSize(new Dimension(800,600));
        panelCenter.add(fourBlocks);
        this.pack();

        //south
        JPanel panelSouth = new JPanel();
        panel.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.add(new JLabel("input: "));

        answer = new JTextField(8);
        panelSouth.add(answer);
        answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputWord=answer.getText();
            }
        });


        buttonSubmit = new JButton("Submit");
        panelSouth.add(buttonSubmit);
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputWord.equals(q.getOriginal())){
                    Correct ab = new Correct();
                    ab.setVisible(true);
                    dispose();

                }else{
                    Wrong ab = new Wrong();
                    ab.setVisible(true);
                    dispose();
                }
            }
        });

        buttonNext = new JButton("Next");
        panelSouth.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level2 ab = new Level2();
                dispose();
                ab.setVisible(true);
            }
        });

    }



}


