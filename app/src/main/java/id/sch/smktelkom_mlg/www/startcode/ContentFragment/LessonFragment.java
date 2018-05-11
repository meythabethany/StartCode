package id.sch.smktelkom_mlg.www.startcode.ContentFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.sch.smktelkom_mlg.www.startcode.Lesson.basdat;
import id.sch.smktelkom_mlg.www.startcode.Lesson.css;
import id.sch.smktelkom_mlg.www.startcode.Lesson.html;
import id.sch.smktelkom_mlg.www.startcode.Lesson.java;
import id.sch.smktelkom_mlg.www.startcode.R;

public class LessonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_lesson, null);

        Button basdat = v.findViewById(R.id.basdat);
        basdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new basdat());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button css = v.findViewById(R.id.css);
        css.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new css());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button html = v.findViewById(R.id.html);
        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new html());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button java = v.findViewById(R.id.java);
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new java());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        return v;
    }
}