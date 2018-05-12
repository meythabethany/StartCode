package id.sch.smktelkom_mlg.www.startcode.ContentFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import id.sch.smktelkom_mlg.www.startcode.R;
import id.sch.smktelkom_mlg.www.startcode.Video.VideoDua;
import id.sch.smktelkom_mlg.www.startcode.Video.VideoEmpat;
import id.sch.smktelkom_mlg.www.startcode.Video.VideoSatu;
import id.sch.smktelkom_mlg.www.startcode.Video.VideoTiga;

public class VideoFragment extends Fragment {

    private static final String API_KEY = "AIzaSyDqZQA1OF6eDU0kylYPtAujf9IrzC6WOKg";
    private static String VIDEO_ID = "EGy39OMyHzw";

    Button BASIS, VIEW, JAVA, KONEK;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_video_fragment, null);

        BASIS = v.findViewById(R.id.basis);
        BASIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new VideoEmpat());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        VIEW = v.findViewById(R.id.view);
        VIEW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new VideoDua());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        JAVA = v.findViewById(R.id.java);
        JAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new VideoSatu());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        KONEK = v.findViewById(R.id.conect);
        KONEK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new VideoTiga());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });


        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(VIDEO_ID);
                    player.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        return v;
    }


}
