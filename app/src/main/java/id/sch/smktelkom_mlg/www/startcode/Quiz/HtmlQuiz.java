package id.sch.smktelkom_mlg.www.startcode.Quiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import id.sch.smktelkom_mlg.www.startcode.QuizLibrary.HtmlLibrary;
import id.sch.smktelkom_mlg.www.startcode.R;

/**
 * Created by Meytha Bethany Putri on 02/05/2018.
 */

public class HtmlQuiz extends Fragment {
    private HtmlLibrary mHtmlLibrary = new HtmlLibrary();

    private TextView mScoreView, mQuestionView;
    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.quiz, null);

        mScoreView = v.findViewById(R.id.score);
        mQuestionView = v.findViewById(R.id.question);
        mButtonChoice1 = v.findViewById(R.id.choice1);
        mButtonChoice2 = v.findViewById(R.id.choice2);
        mButtonChoice3 = v.findViewById(R.id.choice3);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    private void updateScore(int mScore) {
        mScoreView.setText("" + mScore);
    }

    private void updateQuestion() {
        mQuestionView.setText(mHtmlLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mHtmlLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mHtmlLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mHtmlLibrary.getChoice3(mQuestionNumber));

        mAnswer = mHtmlLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }

}
