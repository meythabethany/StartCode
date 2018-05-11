package id.sch.smktelkom_mlg.www.startcode.HomeContent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.sch.smktelkom_mlg.www.startcode.ApplicationView.Kalkulator;
import id.sch.smktelkom_mlg.www.startcode.ApplicationView.Laundry;
import id.sch.smktelkom_mlg.www.startcode.ApplicationView.Luas;
import id.sch.smktelkom_mlg.www.startcode.ApplicationView.Recycler;
import id.sch.smktelkom_mlg.www.startcode.ApplicationView.Widget;
import id.sch.smktelkom_mlg.www.startcode.R;

/**
 * Created by Meytha Bethany Putri on 02/05/2018.
 */

public class ApplicationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.application, null);

        Button recycler = v.findViewById(R.id.recycler);
        recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new Recycler());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button laundry = v.findViewById(R.id.laundry);
        laundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new Laundry());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button kalkulator = v.findViewById(R.id.kalkulator);
        kalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new Kalkulator());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button luas = v.findViewById(R.id.persegi);
        luas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new Luas());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Button widget = v.findViewById(R.id.Widget);
        widget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new Widget());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        return v;
    }

}
