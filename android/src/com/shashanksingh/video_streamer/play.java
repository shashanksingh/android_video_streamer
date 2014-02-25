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
import android.widget.TextView;
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
		
		super.onConfigurationChanged(newConfig);

	    // Checks the orientation of the screen
	    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
	        Toast.makeText(this, "Making Video Full Screen", Toast.LENGTH_SHORT).show();
	        One.setVisibility(View.GONE);
	        Two.setVisibility(View.GONE);
	        Three.setVisibility(View.GONE);
	        Four.setVisibility(View.GONE);
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
		final TextView mTextView = (TextView)findViewById(R.id.watching);
		final String youarewatching = getResources().getString(R.string.youarewatching);

		

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

		//Info --> events
		One.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				findViewById(R.id.youarewatching).setVisibility(View.VISIBLE);
				ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
				progressBar.setVisibility(View.VISIBLE);
				One.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    One.playSoundEffect(SoundEffectConstants.CLICK);
			    mTextView.setText(youarewatching + " Events" );
//			    Toast.makeText(play.this, "Playing Channel: Events", Toast.LENGTH_SHORT).show();
			    String URL = "http://mineral-hangar-418.appspot.com/serve/AMIfv94RiGkrU-NxrkaAjxblAbExc7FpAtM-tD44_xAaetkj9HU0qIasl1GVPGBYJhEQKSz-ICI_TkXCK5-76K6LICPgxE9hvKWtR57naO4W0irFUWQ2jkNcCsETDfPrwB-DwUzKjHVnJEbr61Th6DlA7JFCEwKf67XeixWeUXz-HuLU1JxhNM8";
			    Uri uri = Uri.parse(URL); //Declare your Url here  
			    mVideoView.pause();
			    mVideoView.setMediaController(null);       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});
		//Hindi News
		Two.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				findViewById(R.id.youarewatching).setVisibility(View.VISIBLE);
				ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
				progressBar.setVisibility(View.VISIBLE);
				Two.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
			    Two.playSoundEffect(SoundEffectConstants.CLICK);
			    mTextView.setText(youarewatching + " Hindi News" );
//			    Toast.makeText(play.this, "Playing Channel: Hindi News", Toast.LENGTH_SHORT).show();
			    String URL = "http://mineral-hangar-418.appspot.com/serve/AMIfv95aQfcunqOBZc3XrD0I9AepyQqO902qM2LDN42irskYf7xJEOdkZSKdWzagAGYN8WgVdf0s8_DEJXvfNPMgP239_muLn4ItZIwAC2VjYzrtHLYOqyq-Q0WtdTU-YhpIwsRcwsAJQOAi3q22b1HbUu2PZv2e79KE3G7sZO9QzUtdaRMF39s";
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
			    mTextView.setText(youarewatching + " Bollywood" );
//			    Toast.makeText(play.this, "Playing Channel: Bollywood", Toast.LENGTH_SHORT).show();
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
			    mTextView.setText(youarewatching + " Bengali News" );
//			    Toast.makeText(play.this, "Playing Channel: Bengali News", Toast.LENGTH_SHORT).show();
//			    String URL = "http://download.wavetlan.com/SVV/Media/HTTP/H264/Other_Media/dolphins_1600k.3gp";
//			    String URL = "http://download.wavetlan.com/SVV/Media/HTTP/H264/Other_Media/H264_test6_voice_3gp_480x320.3gp";
			    String URL = "http://mineral-hangar-418.appspot.com/serve/AMIfv97_O1AGJTa47r1JJGpCOZttd64cvVmnSQ37O8S1CEK3HmYU9WZqS6xsReKwd76BPEtIhYv_Nw3eLNyYJ_imJlngqFsmuGS09AlQhcjoL5UrE5czdhlDOt0u1iR57rHMJ9JVO6T2YzdXEZJ5oTVJ0hwW90eCr_1SU57I6cHQ2iU6DGh19UA";
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
