package id.sch.smktelkom_mlg.www.startcode.Testimoni;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.sch.smktelkom_mlg.www.startcode.Database.DatabaseHelper;
import id.sch.smktelkom_mlg.www.startcode.R;

/**
 * Created by Meytha Bethany Putri on 12/05/2018.
 */

public class InsertTestimoni extends Fragment {

    DatabaseHelper db;
    EditText nama, testi, nisn;
    Button save;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.insert_testi, null);

        db = new DatabaseHelper(getContext());
        nama = v.findViewById(R.id.et_nama);
        testi = v.findViewById(R.id.et_testi);
        save = v.findViewById(R.id.insert);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        return v;
    }

    private void saveData() {
        String Nama = nama.getText().toString();
        String Testimoni = testi.getText().toString();
        if (Nama.isEmpty() && Testimoni.isEmpty()) {
            Toast.makeText(getContext(), "ISI", Toast.LENGTH_SHORT).show();
        } else {
            db.addTesti(Nama, Testimoni);
            Toast.makeText(getContext(), "berhasil", Toast.LENGTH_SHORT).show();
        }
    }


}
