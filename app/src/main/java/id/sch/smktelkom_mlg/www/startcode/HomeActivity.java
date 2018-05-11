package id.sch.smktelkom_mlg.www.startcode;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import id.sch.smktelkom_mlg.www.startcode.ContentFragment.HomeFragment;
import id.sch.smktelkom_mlg.www.startcode.ContentFragment.LessonFragment;
import id.sch.smktelkom_mlg.www.startcode.ContentFragment.VideoFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_lesson:
                fragment = new LessonFragment();
                break;

            case R.id.navigation_video:
                fragment = new VideoFragment();
                break;


        }
        return loadFragment(fragment);
    }

}
