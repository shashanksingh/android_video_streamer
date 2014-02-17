//One login page [Activity] -- Views Done
//One Singup page [Activity] -- Views Done
//One page to play videos [Activity] -- Views Done
package com.shashanksingh.video_streamer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//buttonLogin = findViewById(R.id.)
		Button buttonPlay = (Button) findViewById(R.id.play);
		Button buttonSignup = (Button) findViewById(R.id.signup);
		Button buttonLogin = (Button) findViewById(R.id.login);
		VideoView videoView = (VideoView) findViewById(R.id.logoVideo);
		
		String fileName = "android.resource://"+  getPackageName() +"/drawable/channelid";
		videoView.setVideoURI(Uri.parse(fileName));
		videoView.start();
		
		buttonPlay.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,play.class);
				startActivity(intent);
			}
		});
		
		buttonSignup.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,signup.class);
				startActivity(intent);
			}
		});
		
		buttonLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,login.class);
				startActivity(intent);
			}
		});
		
		videoView.setOnCompletionListener(new OnCompletionListener(){

			@Override
			public void onCompletion(MediaPlayer arg0) {
				VideoView videoView = (VideoView) findViewById(R.id.logoVideo);
				ImageView imageView = (ImageView) findViewById(R.id.logoImage);
				videoView.setVisibility(View.GONE);
				imageView.setVisibility(View.VISIBLE);	
			}
			
		});
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
