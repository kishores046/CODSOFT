
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadQuestions {
     String[][] loadQuestions() {
        String[][] problem=null;
        //Creating Buffered Reader object to read the file for efficiency
        //Surrounding Buffered Reading object in try with resoureces to ensure there in no resource leak 
        try (BufferedReader reader = new BufferedReader(new FileReader("QuizQuestions.txt")))//Relative path of the file
        {   int noOfQuestions=0;
            while (reader.readLine()!=null) {
                 noOfQuestions++;
        }
            String[][] parts=new String[noOfQuestions][];
            String line;
            int count=0;
            while ((line = reader.readLine()) != null) {
                //Using split() to split the questions and answers
                String[] Q = line.split(",");
                if (Q.length!=6){
                    continue;//validating the question's format
                }
                parts[count]=Q;
                count++;
            }
            return parts;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading questions: " + e.getMessage());
            System.exit(1);
        }
         return problem;
     }
}

      
