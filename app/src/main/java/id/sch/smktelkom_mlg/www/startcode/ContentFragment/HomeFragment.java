package id.sch.smktelkom_mlg.www.startcode.ContentFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import id.sch.smktelkom_mlg.www.startcode.HomeContent.ApplicationFragment;
import id.sch.smktelkom_mlg.www.startcode.QuizFragment;
import id.sch.smktelkom_mlg.www.startcode.R;

public class HomeFragment extends Fragment {
    ViewFlipper v_flipper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_home_fragment, null);

        Button Quiz = v.findViewById(R.id.quiz);
        Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new QuizFragment());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button App = v.findViewById(R.id.app);
        App.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new ApplicationFragment());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        int images[] = {R.drawable.ww, R.drawable.qq, R.drawable.ee};

        v_flipper = v.findViewById(R.id.v_flipper);

        for (int image : images) {
            flipperImages(image);
        }
        return v;
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        v_flipper.setInAnimation(getContext(), android.R.anim.slide_out_right);
    }
}
