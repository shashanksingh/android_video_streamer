package com.shashanksingh.video_streamer;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class play extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.play);
	    String URL ="http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4";
	    Uri uri = Uri.parse(URL); //Declare your url here.

	    VideoView mVideoView  = (VideoView)findViewById(R.id.videoView1);
	    mVideoView.setMediaController(new MediaController(this));       
	    mVideoView.setVideoURI(uri);
	    mVideoView.requestFocus();
	    mVideoView.start();
	}

}
