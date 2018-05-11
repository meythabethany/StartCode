package id.sch.smktelkom_mlg.www.startcode.ApplicationView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.www.startcode.R;

/**
 * Created by Meytha Bethany Putri on 02/05/2018.
 */

public class Recycler extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recyclerview, null);
        return v;
    }

    public void open(View view) {
        Intent codeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gitlab.com/meythabethany/Tugas02-XIRPL6-21-RecyclerView3"));
        startActivity(codeIntent);
    }
}
