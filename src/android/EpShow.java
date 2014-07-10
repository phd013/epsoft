package org.apache.cordova.epsoft;

import io.cordova.hellocordova.MyService;
import io.cordova.hellocordova.ResultActivity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class EpShow extends CordovaPlugin {

	String TAG = "EpShow";
	CallbackContext cbContext;

	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		cbContext=callbackContext;
		if (action.equals("show")) {
			Log.e(TAG, "show-----------");
			callbackContext.success("show");
		} else if (action.equals("shortToast")) {
			String msg=args.getString(0);
			Toast.makeText(this.cordova.getActivity(), msg,
					Toast.LENGTH_SHORT).show();
		}else if (action.equals("getResult")) {
			String msg=args.getString(0);
			openActivity(msg, callbackContext);
		}else if (action.equals("startService")) {
			openService();
			callbackContext.success("start service ok...");
		}
		else if (action.equals("stopService")) {
			stopService();
			callbackContext.success("stop service ok...");
		}else {
			return false;
		}
		return true;
	}
	private void openService(){
		Intent intent = new Intent();
		intent.setClass(this.cordova.getActivity(), MyService.class);
		this.cordova.getActivity().startService(intent);
	}
	private void stopService(){
		Intent intent = new Intent();
		intent.setClass(this.cordova.getActivity(), MyService.class);
		this.cordova.getActivity().stopService(intent);
	}
	
	private void openActivity(String message, CallbackContext callbackContext) {
		// 要调用的activity名称
		Intent intent = new Intent();
		intent.setClass(this.cordova.getActivity(), ResultActivity.class);
		intent.putExtra("msg", message); // 传给activity的参数
		this.cordova.startActivityForResult(this, intent, 1);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		switch (resultCode) {
		case Activity.RESULT_OK:
			Bundle extra = intent.getExtras(); // 获取activity传回的参数
			String str = extra.getString("return");
			Log.e(TAG, str);
			this.cbContext.success(str); // 将传回的参数返回给调用的页面
			break;
		default:
			break;
		}
	}
	
}
