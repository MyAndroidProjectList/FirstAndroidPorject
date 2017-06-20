package com.example.myfirstandroidproject;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) this.findViewById(R.id.sms_button);
		button.setOnClickListener(new ButtonOnClickListener());
	}
	
	private final class ButtonOnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View arg0) {
			//¶ÌÐÅ·¢ËÍÆ÷
			EditText phoneText = (EditText) findViewById(R.id.sms_phone);
			EditText contentText = (EditText) findViewById(R.id.sms_content);
			String phone = phoneText.getText().toString();
			String content = contentText.getText().toString();
			SmsManager manager = SmsManager.getDefault();
			List<String> smsContexts = manager.divideMessage(content);
			for(String text:smsContexts){
				manager.sendTextMessage(phone, null, text, null, null);
			}
			Toast.makeText(MainActivity.this, R.string.sms_success, Toast.LENGTH_LONG).show();;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
