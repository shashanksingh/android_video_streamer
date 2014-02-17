package com.shashanksingh.video_streamer;

import android.app.Activity;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
//import android.widget.MediaController;
import android.widget.VideoView;

public class play extends Activity {

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		final ImageView One = (ImageView) findViewById(R.id.info);
		final ImageView Two = (ImageView) findViewById(R.id.news);
		final ImageView Three = (ImageView) findViewById(R.id.bollywood);
		final ImageView Four = (ImageView) findViewById(R.id.khabar);
		final VideoView mVideoView  = (VideoView)findViewById(R.id.videoContent);
		
	    super.onConfigurationChanged(newConfig);

	    // Checks the orientation of the screen
	    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
	        Toast.makeText(this, "Making Video Full Screen", Toast.LENGTH_SHORT).show();
	        One.setVisibility(0);
	        Two.setVisibility(0);
	        Three.setVisibility(0);
	        Four.setVisibility(0);
			getWindow().clearFlags(WindowManager
					.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);

	        
	    } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
	        Toast.makeText(this, "Back To Controls", Toast.LENGTH_SHORT).show();
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, 
					WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
			getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    }
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    //We want as much space as possible
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.play);
		final ImageView One = (ImageView) findViewById(R.id.info);
		final ImageView Two = (ImageView) findViewById(R.id.news);
		final ImageView Three = (ImageView) findViewById(R.id.bollywood);
		final ImageView Four = (ImageView) findViewById(R.id.khabar);
		final VideoView mVideoView  = (VideoView)findViewById(R.id.videoContent);
		

		ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
	    mProgressBar.setIndeterminate(true);
	    mProgressBar.setMax(100);
	    mProgressBar.setProgress(100);
	    
        mVideoView.setOnPreparedListener(new OnPreparedListener(){

			@Override
			public void onPrepared(MediaPlayer mp) {
				mp.start();
				mp.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
					
					@Override
					public void onVideoSizeChanged(MediaPlayer arg0, int arg1,
							int arg2) {
						Log.e("TAG", "Changed="+arg1+"*"+arg2);
						ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
						progressBar.setVisibility(View.GONE);
					}
					
				});
				
			}
		});

		//Info
		One.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				findViewById(R.id.youarewatching).setVisibility(View.VISIBLE);
				ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
				progressBar.setVisibility(View.VISIBLE);
				One.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    One.playSoundEffect(SoundEffectConstants.CLICK);
			    String URL = "http://download.wavetlan.com/SVV/Media/HTTP/H264/Other_Media/H264_test5_voice_3gp_480x360.3gp";
			    Uri uri = Uri.parse(URL); //Declare your Url here  
			    mVideoView.pause();
			    mVideoView.setMediaController(null);       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});
		//English News
		Two.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				findViewById(R.id.youarewatching).setVisibility(View.VISIBLE);
				ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
				progressBar.setVisibility(View.VISIBLE);
				Two.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    Two.playSoundEffect(SoundEffectConstants.CLICK);
			    String URL = "http://www.pocketjourney.com/downloads/pj/video/famous.3gp";
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    mVideoView.pause();
			    mVideoView.setMediaController(null);       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}	
		});
		//Bollywood
		Three.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				findViewById(R.id.youarewatching).setVisibility(View.VISIBLE);
				ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
				progressBar.setVisibility(View.VISIBLE);
				Three.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    Three.playSoundEffect(SoundEffectConstants.CLICK);
//			    String URL= "http://techslides.com/demos/sample-videos/small.3gp";
			    //Jateshwar song
			    String URL = "http://mineral-hangar-418.appspot.com/serve/AMIfv96ih2c3tHoraamA4NJq0KWIT4cJGLftK_H5jlDJkqqeY-mDWcbbKGe9c6F7K8DsWdUyADkfpXaBIluCf-Lq9lalmmWPOwkoQjjaX5fHVZ-WiJzrYpSOXT1kp1mCrwEYHlLT6uplnmfUNmIMN4WjOLFBa45Tq24D5GlbtzUMIzGGaNvRYHE";
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    mVideoView.pause();
			    mVideoView.setMediaController(null);       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});
		//Bengali News
		Four.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				findViewById(R.id.youarewatching).setVisibility(View.VISIBLE);
				ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
				progressBar.setVisibility(View.VISIBLE);
				Four.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    Four.playSoundEffect(SoundEffectConstants.CLICK);
//			    String URL = "http://download.wavetlan.com/SVV/Media/HTTP/H264/Other_Media/dolphins_1600k.3gp";
//			    String URL = "http://download.wavetlan.com/SVV/Media/HTTP/H264/Other_Media/H264_test6_voice_3gp_480x320.3gp";
			    String URL = "http://mineral-hangar-418.appspot.com/serve/AMIfv977vPOxo7MiUCojkhlsGVVArO3mYO4rQOG8EKEYW0i7D3rYacrGlqnSTWMNLPhEZRZSGap-xE3yFLA0dqZLd8OnGyonAj4R_hWo30QqV9or6TkmaGqqWsNfyiAQsq9QJKbg4L7MJcdqVIgaDTPb6D1bxczemTYtuO3pG7BUOyVGst1yDrs";//award function
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    mVideoView.pause();
			    mVideoView.setMediaController(null);       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});
		
		
	}
}
