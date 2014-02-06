//One login page [Activity] -- Views Done
//One Singup page [Activity] -- Views Done
//One page to play videos [Activity] -- Views Done
package com.shashanksingh.video_streamer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    mPlusClient = new PlusClient.Builder(this, this, this)
        .setActions("http://schemas.google.com/AddActivity", "http://schemas.google.com/BuyActivity")
        .build();
	    
	    findViewById(R.id.sign_in_button).setOnClickListener(this);
		//buttonLogin = findViewById(R.id.)
		Button buttonPlay = (Button) findViewById(R.id.play);
		Button buttonSignup = (Button) findViewById(R.id.signup);
		Button buttonLogin = (Button) findViewById(R.id.login);
		
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
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
