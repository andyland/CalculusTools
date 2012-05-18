/*
 * Copyright (C) 2010 Andrew P McSherry
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.andymcsherry.library;

import com.andymcsherry.calculustools.library.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class IntegralDisplayer extends Activity {

	public ImageView im1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.integraldisplayer);
		im1 = (ImageView) findViewById(R.id.ImageView01);
		String choice = getIntent().getStringExtra("intChoice");
		try{
		if (choice.equals("basic")) {
			im1.setImageResource(R.drawable.intb);
		} else if (choice.equals("trig")) {
			im1.setImageResource(R.drawable.intt);
		} else if (choice.equals("log")) {
			im1.setImageResource(R.drawable.intl);
		} else if (choice.equals("exp")) {
			im1.setImageResource(R.drawable.inte);
		} else if (choice.equals("itrig")) {
			im1.setImageResource(R.drawable.intit);
		} else if (choice.equals("hyp")) {
			im1.setImageResource(R.drawable.inth);
		} else if(choice.equals("dif")){
			im1.setImageResource(R.drawable.dif);
		} else if(choice.equals("lim")){
			im1.setImageResource(R.drawable.lim);
		} else if(choice.equals("trigi")){
			im1.setImageResource(R.drawable.trig);
		}
		}catch(OutOfMemoryError e){
			Toast.makeText(IntegralDisplayer.this, "Your phone has run out of available RAM.  Close some processes and try again.", Toast.LENGTH_LONG).show();
			finish();
		}
	}

	@Override
	// Creates menu
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, 0, Menu.NONE, getString(R.string.home));
		menu.add(Menu.NONE, 99, Menu.NONE, getString(R.string.help));
		if(Derivative.ads){
			menu.add(Menu.NONE,100, Menu.NONE, getString(R.string.donate));
		}
		return true;
	}

	@Override
	// Opens new activity based on user selection
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		if (item.getItemId() == 0) {
			intent = new Intent(getApplicationContext(), Derivative.class);
		} else if(item.getItemId() == 99){
			intent = new Intent(getApplicationContext(), Help.class);
		} else {
			intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=com.andymc.calculuspaid"));
		}
		intent.putExtra("function", getIntent().getStringExtra("function"));
		startActivity(intent);
		return true;
	}
}
