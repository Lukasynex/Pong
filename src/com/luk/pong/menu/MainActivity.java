package com.luk.pong.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.luk.pong.R;
import com.luk.pong.client.Client;
import com.luk.pong.game.GameActivity;
import com.luk.pong.server.Server;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		final ListView listview = (ListView) findViewById(R.id.listView1);
		final String[] values = new String[] { "Graj", "Po³¹cz jako klient",
				"Po³¹cz jako serwer", "Opcje", "Info", "Koniec" };
		ActivityRunner.getActivities(values);

		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < values.length; ++i) {
			list.add(values[i]);
		}
		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				final String item = (String) parent.getItemAtPosition(position);
				
				view.animate().setDuration(250).alpha(0)
						.withEndAction(new Runnable() {
							@Override
							public void run() {
								Intent intent = null;
								if(item.equals(values[0]))
									intent = new Intent(getBaseContext(), GameActivity.class);
								else if(item.equals(values[1]))
									intent = new Intent(getBaseContext(), Client.class);
								else if(item.equals(values[2]))
									intent = new Intent(getBaseContext(), Server.class);
								else if(item.equals(values[3]))
									intent = new Intent(getBaseContext(), OptionsActivity.class);
								else if(item.equals(values[4]))
									intent = new Intent(getBaseContext(), InfoActivity.class);
								else if(item.equals(values[5]))
									intent =null;
								
								if(intent != null)
									startActivity(intent);
								else
									finish();
								
								
//								list.remove(item);
//								adapter.notifyDataSetChanged();
								view.setAlpha(1);
							}
						});
			}

		});
	}

	private class StableArrayAdapter extends ArrayAdapter<String> {

		HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		public StableArrayAdapter(Context context, int textViewResourceId,
				List<String> objects) {
			super(context, textViewResourceId, objects);
			for (int i = 0; i < objects.size(); ++i) {
				mIdMap.put(objects.get(i), i);
			}
		}

		@Override
		public long getItemId(int position) {
			String item = getItem(position);
			return mIdMap.get(item);
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

	}
}
