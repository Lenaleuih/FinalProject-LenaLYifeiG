import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Question {
    private String original;
    private String shuffled;




    public Question(String original, String shuffled){
        this.original=original;
        this.shuffled= shuffled;

    }

    public Question() {

    }

    public static void addQuestion(String original) {
        File file = new File("Vocabularies.txt");
        try {

            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.println(original);
            writer.close();
        } catch (Exception e) {
            System.out.println("Problem writing the file.Please make sure the path is corret");
        }


    }

    private static String shuffle(String inputString) {

        Random rand = new Random();
        char a [] = inputString.toCharArray();

        for (int i = 0; i<a.length; i++){
            int j = rand.nextInt(a.length);

            char temp = a[i]; a[i]=a[j]; a [j]= temp;
        }

        return new String (a);

    }

    public void setShuffled(Question q){
        q.shuffled = shuffle(q.original);
    }

    public String getShuffled(){
        return shuffled;
    }

    public String getOriginal(){return original;}


    public static ArrayList<Question> readQuestion() {
        ArrayList<Question> questions = new ArrayList<>();
        try {
            File file = new File("Vocabularies.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String a = scanner.next();
                String b = shuffle(a);
                Question q = new Question(a,b);
                questions.add(q);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Problem reading the file. Please make sure the " +
                    "path is correct");
        }
        return questions;
    }



}


