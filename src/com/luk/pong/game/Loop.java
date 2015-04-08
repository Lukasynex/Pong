package com.luk.pong.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

public class Loop {
	private static boolean isStarted = false;
	private static Handler handler = new Handler();
	private static Ball mBall;
	private static Activity activity;
	private static View layout;
	private static ImageView ball_t;
	public static boolean isActive = true;
	private static int red = 0;
	private static int green = 128;
	private static int blue = 255;
	private static boolean red_up = true;
	private static boolean green_up = true;
	private static boolean blue_up = false;
	private static Runnable stepTimer = new Runnable() {

		private int i = 0;

		@Override
		public void run() {
			if (isActive) {
				if (i % 6 == 0) {
					ColorTransition();
					i = 0;
				}
				LoopActions();
				handler.postDelayed(this, 4);
				++i;
			}
		}

	};
	private static Context context;

	public static void start(Context con, ImageView image, View lay, DisplayMetrics outMetrics) {
		if (!isStarted) {

			handler.postDelayed(stepTimer, 0);

			isStarted = true;
		}
		context = con;
		ball_t = image;
		mBall = new Ball(con, outMetrics);
		mBall.connect(ball_t);
		layout = lay;
	}

	private static void ColorTransition() {
		layout.setBackgroundColor(Color.rgb(red, green, blue));

		if (red <= 0)
			red_up = true;
		if (red >= 255)
			red_up = false;

		if (blue <= 0)
			blue_up = true;
		if (blue >= 255)
			blue_up = false;

		if (green <= 0)
			green_up = true;
		if (green >= 255)
			green_up = false;

		if (blue_up)
			blue += 1;
		else
			blue -= 1;
		if (red_up)
			red += 1;
		else
			red -= 1;
		if (green_up)
			green += 1;
		else
			green -= 1;

	}

	public static void LoopActions() {
		mBall.LoopActions();
		ball_t.setX(mBall.posX);
		ball_t.setY(mBall.posY);
	}
}