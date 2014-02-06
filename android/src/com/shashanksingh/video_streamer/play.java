package com.shashanksingh.video_streamer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class play extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.play);
	    //String SD_CARD_PATH = Environment.getExternalStorageDirectory().toString();
	    //String URL = SD_CARD_PATH + "627.mp4";
	    //String URL = "http://www.pocketjourney.com/downloads/pj/video/famous.3gp";
		Button One = (Button) findViewById(R.id.One);
		Button Two = (Button) findViewById(R.id.Two);
		Button Three = (Button) findViewById(R.id.Three);
		Button Four = (Button) findViewById(R.id.Four);
		
		One.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
			    String URL = "";
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    VideoView mVideoView  = (VideoView)findViewById(R.id.videoView1);
			    mVideoView.pause();
			    mVideoView.setMediaController(new MediaController(play.this));       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});

		Two.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
			    String URL = "http://www.pocketjourney.com/downloads/pj/video/famous.3gp";
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    VideoView mVideoView  = (VideoView)findViewById(R.id.videoView1);
			    mVideoView.pause();
			    mVideoView.setMediaController(new MediaController(play.this));       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});
		Three.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
			    String URL = "http://download.blender.org/peach/bigbuckbunny_movies/big_buck_bunny_720p_stereo.ogg";
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    VideoView mVideoView  = (VideoView)findViewById(R.id.videoView1);
			    mVideoView.pause();
			    mVideoView.setMediaController(new MediaController(play.this));       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});
		Four.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
			    String URL = "http://download.blender.org/peach/bigbuckbunny_movies/big_buck_bunny_480p_h264.mov";
			    Uri uri = Uri.parse(URL); //Declare your Url here.
			    VideoView mVideoView  = (VideoView)findViewById(R.id.videoView1);
			    mVideoView.pause();
			    mVideoView.setMediaController(new MediaController(play.this));       
			    mVideoView.setVideoURI(uri);
			    mVideoView.requestFocus();
			    mVideoView.start();
			}
		});
	}
}
