package com.MahammadYagubli.youtubeplayer;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
static final String GOOGLE_API_KEY="AIzaSyCxuk3Qk5fst6CUeeUYymsUcp16NfWwg2A";
static final String YOUTUBEVIDE0="suASnpsPgz8";
    static final String PlayList="RDMMsuASnpsPgz8";
    private static final String TAG = "Activity Youtube:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.design.widget.CoordinatorLayout layout=(android.support.design.widget.CoordinatorLayout)getLayoutInflater().inflate(R.layout.activity_youtube,null);
        setContentView(layout);
Button button1=new Button(this);
button1.setLayoutParams(new ConstraintLayout.LayoutParams(300,80));
button1.setText("ButtonAddd");
layout.addView(button1);
        YouTubePlayerView player=new YouTubePlayerView(this);
        player.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT) );
player.initialize(GOOGLE_API_KEY,this);
        layout.addView(player);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG,"ONinitializationSuccess: provider is : "+provider.getClass().toString());
        Toast.makeText(this,"Initialized Youtube Player Successfully,",Toast.LENGTH_LONG).show();
      youTubePlayer.setPlaybackEventListener(playerbackeventListener);
      youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);;

        if(!wasRestored){
            youTubePlayer.cueVideo(YOUTUBEVIDE0);

        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
if(youTubeInitializationResult.isUserRecoverableError()){
  final int  REQUEST_CODE=1;
    youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE).show();
}
else {
    String errorMessage=String.format("There is an error nitializing the youtubePLayer(%1$s)",youTubeInitializationResult.toString());
    Toast.makeText( this, errorMessage,Toast.LENGTH_LONG).show();


}
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
private YouTubePlayer.PlaybackEventListener playerbackeventListener=new YouTubePlayer.PlaybackEventListener() {
    @Override
    public void onPlaying() {
        Toast.makeText(YoutubeActivity. this,  "Good , Video is playing Ok",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onPaused() {
        Toast.makeText(YoutubeActivity. this,  "Awefull , Video is Paused",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onStopped() {
        Toast.makeText(YoutubeActivity. this,  "   Video is Stopped",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
};
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener=new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {
            Toast.makeText(YoutubeActivity. this,  " Click add now, Video is Loadiing",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onLoaded(String s) {
            Toast.makeText(YoutubeActivity. this,  " Click add now, Video is Loaded",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(YoutubeActivity. this,  " Click add now, Video is started",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YoutubeActivity. this,  " Click add now, Video is Started",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(YoutubeActivity. this,  " Click add now, Video is Ended",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            Toast.makeText(YoutubeActivity. this,  errorReason.toString(),Toast.LENGTH_LONG).show();

        }
    };
}
