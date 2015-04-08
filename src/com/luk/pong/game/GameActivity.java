package com.luk.pong.game;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.luk.pong.R;
import com.luk.pong.game.Ball.Direction;

public class GameActivity extends Activity {
	 Ball ball;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ImageView balll = (ImageView)findViewById(R.id.ball);
        RelativeLayout lay = (RelativeLayout)findViewById(R.id.MainLayout);
    	DisplayMetrics outMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		
		
        Loop.start(this,balll, lay, outMetrics);
        //        balll.setX(200);
//        balll.setY(200);
//        
//       ball = new Ball(this);
//        ball.setPosition(200, 200);
//        ball.setDirection(Direction.NW);
//        ball.start();
//    
    }

	public void Method() {
		ImageView ballView = (ImageView)findViewById(R.id.ball);
		ballView.setX(ball.posX);
		ballView.setY(ball.posY);
	}

}
