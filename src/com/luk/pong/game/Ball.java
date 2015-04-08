package com.luk.pong.game;

import com.luk.pong.game.Ball.Direction;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Ball extends AbstractItem {
	private static Handler handler = new Handler();
	private static boolean isActive = false;
	private static Direction direction = Direction.O;
	private static final int step = 4;
	private static int WIDTH;
	private static int HEIGHT;

	public static enum Direction {
		N, NW, NE, W, SW, SE, E, S, NNW, NWW, NEE, NNE, SSW, SSE, SEE, SWW, O
	}

	public Ball(Context context, DisplayMetrics outMetrics) {
		super(context);
		// TODO Auto-generated constructor stub
		direction = Direction.SW;
		posX = 100;
		posY = 100;
		WIDTH = outMetrics.widthPixels;
		HEIGHT = outMetrics.heightPixels;
	}

	public static void setPosition(int x, int y) {
		posX = x;
		posY = y;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	public void start() {
		if (!isActive) {
			handler.postDelayed(stepTimer, 0);
			isActive = true;
		}
	}

	private Runnable stepTimer = new Runnable() {
		@Override
		public void run() {
			if (isActive) {
				LoopActions();
				((GameActivity) context).Method();
				handler.postDelayed(this, 5);
			}
		}

	};
	private static int width;
	private static int height;

	public static void LoopActions() {
		checkForEdges();

		switch (direction) {
		case N:
			setPosition(posX, posY - step);
			break;
		case S:
			setPosition(posX, posY + step);
			break;
		case W:
			setPosition(posX - step, posY);
			break;
		case E:
			setPosition(posX + step, posY);
			break;
		case NW:
			setPosition(posX - step / 2, posY - step / 2);
			break;
		case NE:
			setPosition(posX + step / 2, posY - step / 2);
			break;
		case SW:
			setPosition(posX - step / 2, posY + step / 2);
			break;
		case SE:
			setPosition(posX + step / 2, posY + step / 2);
			break;
		case NEE:
			break;
		case NNE:
			break;
		case NNW:
			break;
		case NWW:
			break;
		case O:
			break;
		case SEE:
			break;
		case SSE:
			break;
		case SSW:
			break;
		case SWW:
			break;
		default:
			break;

		}

	}

	private static void checkForEdges() {
		if (posX - step < 0) {
			if (direction == Direction.W)
				direction = Direction.E;
			else if (direction == Direction.NW)
				direction = Direction.NE;
			else if (direction == Direction.SW)
				direction = Direction.SE;
		} else if (posX + step > WIDTH-65) {
			if (direction == Direction.E)
				direction = Direction.W;
			else if (direction == Direction.NE)
				direction = Direction.NW;
			else if (direction == Direction.SE)
				direction = Direction.SW;
		}
		if (posY - step < 0) {
			if (direction == Direction.N)
				direction = Direction.S;
			else if (direction == Direction.NW)
				direction = Direction.SW;
			else if (direction == Direction.NE)
				direction = Direction.SE;
		} else if (posY + step > HEIGHT-150) {
			if (direction == Direction.S)
				direction = Direction.N;
			else if (direction == Direction.SW)
				direction = Direction.NW;
			else if (direction == Direction.SE)
				direction = Direction.NE;
		}
	}

	public void setDirection(Direction nw) {
		direction = nw;
	}

	public void connect(ImageView ball_t) {
		posX = (int) ball_t.getX();
		posY = (int) ball_t.getY();
		width = 2 * ball_t.getWidth();
		height = 2 * ball_t.getHeight();
		Toast.makeText(context, "width: " + width + ", height: " + height,
				Toast.LENGTH_LONG);
		width = 100;
		height = 100;
	}
}
