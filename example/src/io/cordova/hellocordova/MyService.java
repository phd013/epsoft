package io.cordova.hellocordova;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	String TAG = this.getClass().getSimpleName();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	int i = 0;
	Handler handler = new Handler();
	Task task=null;

	class Task implements Runnable {

		@Override
		public void run() {
			Log.e(TAG, i + "------");
			i++;
			handler.postDelayed(task, 2000);
		}
	}

	@Override
	public void onCreate() {
		super.onCreate();
		task=new Task();
		handler.postDelayed(task, 2000);
	}
	
	@Override
	public void onDestroy() {
		handler.removeCallbacks(task);
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

}
