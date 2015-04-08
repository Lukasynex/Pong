package com.luk.pong.menu;

import android.content.Context;
import android.content.Intent;

public class ActivityRunner {
	private static Context context;
	private static String[] activities;
	private static String[] classNames = { "com.luk.pong.game.GameActivity",
			"com.luk.pong.client.Client", "com.luk.pong.server.Server",
			"com.luk.pong.menu.OptionsActivity", "com.luk.pong.menu.InfoActivity","" };

	public static void start(String item) {
		for (int i = 0; i < activities.length; i++) {
			if (item.equals(activities[i])) {
				startIntent(i);
				break;
			}
		}
	}

	private static void startIntent(int i) {
		Intent intent = null;
		if(classNames[i].length()==0){
			((MainActivity) context).finish();
		}
		try {
			intent = new Intent(context, Class.forName(classNames[i]));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (intent == null)
				;// TODO:error handling
		}
		context.startActivity(intent);
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public static void getActivities(String[] values) {
		activities = values;
	}

}
