package com.sonya.zlzlauncher;

import android.app.ActionBar.LayoutParams;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class AppTouchListener implements OnTouchListener {
	int iconSize;

	public AppTouchListener(int size) {
		iconSize = size;
	}

	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
			LayoutParams lp = new LayoutParams(iconSize, iconSize);
			lp.leftMargin = (int) event.getRawX() - iconSize / 2;
			lp.topMargin = (int) event.getRawY() - iconSize / 2;
			v.setLayoutParams(lp);
		}
		return true;
	}
}
