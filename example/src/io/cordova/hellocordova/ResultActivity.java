package io.cordova.hellocordova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class ResultActivity extends Activity {

	String TAG = this.getClass().getSimpleName();

	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.result_activity);
	
	Log.e(TAG, this.getIntent().getStringExtra("msg"));
	
	findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();   
            intent.putExtra("return", "Activity Ok");  //设置回传参数
            setResult(RESULT_OK, intent); 
            finish(); 
		}
	});
}
}
