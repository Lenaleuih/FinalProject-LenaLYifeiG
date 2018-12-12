import java.awt.*;

public class PromptViewer extends Canvas {

    public static int i = 0;
    public Question q = Question.readQuestion().get(i);

    public PromptViewer() {

    }

    public void paint(Graphics g) {
        super.paint(g);

        if (q.getShuffled().length() == 4) {
            g.setColor(Color.ORANGE);
            g.fillRect(300, 150, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(350, 150, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(300, 300, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(350, 300, 150, 150);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            String firstLetter = q.getShuffled().substring(0, 1);
            g.drawString(firstLetter, 320, 250);

            String secondLetter = q.getShuffled().substring(1, 2);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(secondLetter, 420, 250);

            String thirdLetter = q.getShuffled().substring(2, 3);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(thirdLetter, 320, 370);

            String fourthLetter = q.getShuffled().substring(3, 4);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(fourthLetter, 420, 370);

        } else {
            g.setColor(Color.ORANGE);
            g.fillRect(300, 150, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(350, 150, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(225, 300, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(375, 300, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(425, 300, 150, 150);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            String firstLetter = q.getShuffled().substring(0, 1);
            g.drawString(firstLetter, 320, 250);


            g.setFont(new Font("Cambria", Font.BOLD, 100));
            String secondLetter = q.getShuffled().substring(1, 2);
            g.drawString(secondLetter, 420, 250);

            String thirdLetter = q.getShuffled().substring(2, 3);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(thirdLetter, 270, 390);

            String fourthLetter = q.getShuffled().substring(3, 4);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(fourthLetter, 370, 390);

            String fifthLetter = q.getShuffled().substring(4, 5);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(fifthLetter, 470, 390);


        }
    }


}
