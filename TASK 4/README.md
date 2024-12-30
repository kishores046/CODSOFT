#QUIZ APPLICATION WITH TIMER

OVERVIEW: 
     This is java console based quiz application .It allows user to answer multiple choice questions within a time
limit.This program tracks scores and user's answer for each question and display a final summary of correct
and incorrect responses.

FEATURES

1)QUIZ QUESTIONS AND OPTIONS

     Each questions include multiple choice options and a correct answer .The questions are stored
in seperate file so it allows us to maintain questions seperately.

2)TIMER

    Here Timer,TimerTask classes are not used but ExecutedService class is used for more efficient 
task scheduling.Here for each questions 10s is allocated

3)SCORE CALCULATION

    The program keeps track of the user's score based on correct answers

4)RESULT SCREEN

    At the end of the quiz the user's score final score is dispalyed.A summary of correct and incorrect answers
is provided

TECNOLOGIES USED

IDE USED:Visual Studio Code

Progrramming language:Java

CLASSES's DESCRIPTION

    MultiQuestionQuiz class:It is main class for the questions to be displayed along with the options.It keeps tracks
of our score and display the result and summary at end .It also regualates the timer
 
    LoadQuestions class:It loads the questions from .txt file to data structure and returns it to main class
by specific pattern for questions and options.It uses BufferedReader class so it loads faster since there is 
no need to interact directly with file.It increases it's performance
      

