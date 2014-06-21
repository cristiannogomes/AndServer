package com.example.andserver;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	MyHttpServer server;
	TextView ipAddress;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ipAddress = new TextView(this);
		setContentView(ipAddress);
		server = new MyHttpServer(MainActivity.this);
		server.start();

		ipAddress.setText(server.getIPAddress());
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		server.stop();
	}

}