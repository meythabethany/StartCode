package id.sch.smktelkom_mlg.www.startcode.Lesson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.www.startcode.R;

/**
 * Created by Meytha Bethany Putri on 10/05/2018.
 */

public class html extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.html, null);
//        Button Back = (Button) v.findViewById(R.id.back);
//        Back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
//                fragmentTransaction1.replace(R.id.fragment_container, new LessonFragment());
//                fragmentTransaction1.addToBackStack(null);
//                fragmentTransaction1.commit();
//            }
//        });

        return v;
    }
}
