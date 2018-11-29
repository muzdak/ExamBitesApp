package education.exambites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static education.exambites.R.id.view;

public class VideoPlayerMainActivity extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    Button playBtn,startQuiz;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_main);
        playBtn =(Button)findViewById(R.id.btn_play);
        startQuiz=(Button)findViewById(R.id.startQuiz);
        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youTube_player_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
            youTubePlayer.loadVideo("8qLL2Gx3I_k");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
                playBtn.setVisibility(View.GONE);
            }
        });

    }
    public void startQuizs(View view){
        Intent intent=new Intent(this,quiz.class);
        startActivity(intent);
    }
}
