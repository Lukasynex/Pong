package com.luk.pong;

import android.content.Context;

public abstract class AbstractItem {
	protected static int posX;
	protected static int posY;
	protected Context context;
	
	public AbstractItem(Context context){
		this.context = context;
	}
	public abstract void stop();
}
