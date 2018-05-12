package id.sch.smktelkom_mlg.www.startcode.Testimoni;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import id.sch.smktelkom_mlg.www.startcode.R;

/**
 * Created by Meytha Bethany Putri on 12/05/2018.
 */

public class TestimoniList extends Fragment {

    ImageView insert;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.testi_list, null);

        insert = v.findViewById(R.id.add);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new InsertTestimoni());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });


        return v;
    }

}
