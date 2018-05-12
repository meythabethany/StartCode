package id.sch.smktelkom_mlg.www.startcode.QuizLibrary;

/**
 * Created by Meytha Bethany Putri on 02/05/2018.
 */

public class CssLibrary {
    private String mQuestion[] = {
            "Apakah itu CSS? ...",
            "Apa itu Intline Style Sheet ...",
            "Sebutkan bahasa basis data",
            "Yang bukan tujuan basis data"
    };

    private String mChoices[][] = {
            {"informasi tambahan dari Tag", "Feature untuk membuat dynamic HTML", "Merupakan Tag paragrafh dalam HTML", "merupakan tag pembuka diakhiri dengan tanda "},
            {"read", "Update,delete,insert", "CSS yang dibuat dalam sebuah tag HTML ", "CSS yang dibuat diluar sebuah tag HTML "},
            {"DBL,DDL", "DDL,DML", "DBA,DDL", "apa aja"},
            {"rumah", "sharebility", "Security", "Apa aja"}
    };

    private String mCorrectAnswers[] = {"Database Management System (DBMS)", "Update,delete,insert", "DDL,DML", "DDL,DML", "rumah"};

    public String getQuestion(int a) {
        String question = mQuestion[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
