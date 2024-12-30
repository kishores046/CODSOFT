//import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class MultiQuestionQuiz {
    private static final int TIME_LIMIT = 10; // Time limit in seconds for each question 
    //Note it is constant we can modify after its declaration
    private static int timeRemaining = TIME_LIMIT;//Time remaining for each question
    private static ScheduledExecutorService executorService;//Creating a ScheduledExecutorService object
    static int score=0;//Score of the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoadQuestions obj=new LoadQuestions();//Creating an object of LoadQuestions class
        String[][] questions=obj.loadQuestions();
        if(questions==null){
            System.out.println("OOPS Something went wrong");
            System.exit(0);
        }
            //Calling the loadQuestions method of LoadQuestions class
        List<String> track_user=new ArrayList<>();//List to track the user's answers
        for (String[] question :questions) {
            timeRemaining = TIME_LIMIT; // Reset timer for each question
            System.out.println("\n" + question[0]);
            System.out.println(question[1]);
            System.out.println(question[2]);
            System.out.println(question[3]);
            System.out.println(question[4]);
            // Start the timer for each question
            callTimer();            
            // Get user's answer
            String answer = scanner.nextLine();
            // Stop the timer when an answer is given
            executorService.shutdown();
            try {//Wait for the executor service to terminate
                if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                   executorService.shutdownNow();
               }                   
            } catch (InterruptedException e) {
                    executorService.shutdownNow();
                 }
            // Check the answer
            if (answer.equalsIgnoreCase(question[5])) {
                score++;//Increment the score if the answer is correct
           }
           track_user.add(answer);//Add the user's answer to the list
            continue;
       }
       scanner.close();
       showResults(questions,track_user);//Show the results of the quiz
    }
    private static void showResults(String[][] questions,List<String> youranswer) {
        System.out.println("\nQuiz Completed!\n--------------\nYour Score is "+score+"\n--------------");
        System.out.println("Correct Answers||Your answer");
        for(int i=0;i<questions.length;i++){
        System.out.println("Option:"+questions[i][5]+")"+"||"+youranswer.get(i));
        }
    }
    public static void callTimer(){
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
             if (timeRemaining > 0) {     
                    timeRemaining--;
            } else {
                    System.out.println("\nTime's up! You failed to answer in time.");
                    executorService.shutdown();
                    // Exit the quiz if time runs out
                }
            }, 0, 1, TimeUnit.SECONDS);

    }
}