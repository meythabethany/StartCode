package id.sch.smktelkom_mlg.www.startcode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.sch.smktelkom_mlg.www.startcode.Quiz.BasdatQuiz;
import id.sch.smktelkom_mlg.www.startcode.Quiz.CssQuiz;
import id.sch.smktelkom_mlg.www.startcode.Quiz.HtmlQuiz;
import id.sch.smktelkom_mlg.www.startcode.Quiz.JavaQuiz;

/**
 * Created by Meytha Bethany Putri on 19/04/2018.
 */

public class QuizFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz, null);

        Button Basdat = v.findViewById(R.id.basdatQuiz);
        Basdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new BasdatQuiz());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button css = v.findViewById(R.id.cssQuiz);
        css.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new CssQuiz());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button html = v.findViewById(R.id.htmlQuiz);
        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new HtmlQuiz());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button java = v.findViewById(R.id.javaQuiz);
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new JavaQuiz());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        return v;
    }
}
