package com.shashanksingh.video_streamer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
//import android.widget.MediaController;
import android.widget.VideoView;

public class play extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    //We want as much space as possible
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.play);
	    //String SD_CARD_PATH = Environment.getExternalStorageDirectory().toString();
	    //String URL = SD_CARD_PATH + "627.mp4";
	    //String URL = "http://www.pocketjourney.com/downloads/pj/video/famous.3gp";
		final ImageView One = (ImageView) findViewById(R.id.info);
		final ImageView Two = (ImageView) findViewById(R.id.news);
		final ImageView Three = (ImageView) findViewById(R.id.bollywood);
		final ImageView Four = (ImageView) findViewById(R.id.khabar);
		ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
		final VideoView mVideoView  = (VideoView)findViewById(R.id.videoView1);
		progressBar.setVisibility(View.VISIBLE);
        mVideoView.setOnPreparedListener(new OnPreparedListener(){

			@Override
			public void onPrepared(MediaPlayer mp) {
				mp.start();
				mp.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {

					@Override
					public void onVideoSizeChanged(MediaPlayer arg0, int arg1,
							int arg2) {
						//Log.e(TAG, "Changed");
						ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
						progressBar.setVisibility(View.GONE);
					}
					
				});
				
			}
		});

		
		One.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				One.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    One.playSoundEffect(SoundEffectConstants.CLICK);
			    String URL = "http://download.wavetlan.com/SVV/Media/HTTP/The_Simpsons_S19E05_Treehouse_of_Horror_XVIII.3GP";
			    Uri uri = Uri.parse(URL); //Declare your Url here  
			    mVideoView.pause();
//			    mVideoView.setMediaController(null);       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});

		Two.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Two.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    Two.playSoundEffect(SoundEffectConstants.CLICK);
			    String URL = "http://www.pocketjourney.com/downloads/pj/video/famous.3gp";
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    mVideoView.pause();
//			    mVideoView.setMediaController(null);       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}	
		});
		Three.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Three.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    Three.playSoundEffect(SoundEffectConstants.CLICK);
			    String URL= "http://techslides.com/demos/sample-videos/small.3gp";
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    mVideoView.pause();
//			    mVideoView.setMediaController(null);       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});
		Four.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Four.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    Four.playSoundEffect(SoundEffectConstants.CLICK);
			    String URL = "http://download.wavetlan.com/SVV/Media/HTTP/H264/Other_Media/dolphins_1600k.3gp";
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    mVideoView.pause();
//			    mVideoView.setMediaController(null);       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});
	}
}
