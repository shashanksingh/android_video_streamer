package com.shashanksingh.video_streamer;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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
	    String URL = "http://hermes.sprc.samsung.pl/widget/tmp/testh.3gp";

	    Uri uri = Uri.parse(URL); //Declare your Url here.

	    VideoView mVideoView  = (VideoView)findViewById(R.id.videoView1);
	    mVideoView.setMediaController(new MediaController(this));       
	    mVideoView.setVideoURI(uri);
	    mVideoView.requestFocus();
	    mVideoView.start();
	}

}
