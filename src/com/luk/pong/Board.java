package com.luk.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class Board extends View {
	private static final int DEPTH = 15;
	private static int WIDTH;
	private static int HEIGHT;
	private Paint edgePaint = new Paint();

	public Board(Context context) {
		this(context, null);
	}

	public Board(Context context, AttributeSet set) {
		super(context, set);
		edgePaint.setColor(Color.DKGRAY);
		DisplayMetrics metrics = new DisplayMetrics();
		WIDTH = metrics.widthPixels;
		HEIGHT = metrics.heightPixels;
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawRect(0, 0, DEPTH, HEIGHT, edgePaint);
		canvas.drawRect(0, 0, WIDTH, DEPTH, edgePaint);
		canvas.drawRect(WIDTH - DEPTH, 0, WIDTH, HEIGHT, edgePaint);

		canvas.drawRect(0, HEIGHT - DEPTH, DEPTH, WIDTH, edgePaint);
	}

}
