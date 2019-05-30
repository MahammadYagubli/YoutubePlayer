package com.MahammadYagubli.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
String YOUTUBE_VIDEO_ID="I2b-wEsHEEA";
String  YOUTUBE_Playlist="RD-S98gtynShg";
    @Override
    public void onCreate(  Bundle savedInstanceState,  PersistableBundle persistentState) {

        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.standalone);
        Button btnPlayVideo=(Button)findViewById(R.id.btnplaySingle);
        Button btnPlayList=(Button)findViewById(R.id.btnstanalone);
        btnPlayList.setOnClickListener(this);btnPlayVideo.setOnClickListener(this);

                            }

    @Override
    public void onClick(View v) {
int id=v.getId();
Intent intent=null;
switch (id){

    case R.id.btnplaySingle:
    intent= YouTubeStandalonePlayer.createVideoIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBEVIDE0);
        break;

    case R.id.btnstanalone:
        intent= YouTubeStandalonePlayer.createPlaylistIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.PlayList);

        break;

        default:
            break;

}
if(intent!=null){

    startActivity(intent);
}

    }
}
