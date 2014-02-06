package com.shashanksingh.video_streamer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class signup extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.signup);
	    Button buttonSubmit = (Button) findViewById(R.id.submit);
		buttonSubmit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(signup.this,MainActivity.class);
				startActivity(intent);
			}
		});
	}

}
