package com.sonya.zlzlauncher;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;

public class DrawerLongClickListener implements OnItemLongClickListener {

	Context mContext;
	SlidingDrawer drawerForAdapter;
	RelativeLayout homeViewForAdapter;

	public DrawerLongClickListener(Context ctxt, SlidingDrawer slidingDrawer,
			RelativeLayout zlzHome) {
		mContext = ctxt;
		drawerForAdapter = slidingDrawer;
		homeViewForAdapter = zlzHome;

	}

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View item, int arg2,
			long arg3) {
		MainActivity.appLaunchable = false;
		LayoutParams lp = new LayoutParams(item.getWidth(), item.getHeight());
		lp.leftMargin = (int) item.getX();
		lp.topMargin = (int) item.getY();

		LayoutInflater li = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout ll = (LinearLayout) li.inflate(R.layout.zlz_items, null);

		((ImageView) ll.findViewById(R.id.zlz_icons))
				.setImageDrawable(((ImageView) item
						.findViewById(R.id.zlz_icons)).getDrawable());
		((TextView) ll.findViewById(R.id.zlz_text)).setText(((TextView) item
				.findViewById(R.id.zlz_text)).getText());

		ll.setOnTouchListener(new AppTouchListener(item.getWidth()));
		homeViewForAdapter.addView(ll, lp);
		drawerForAdapter.animateClose();
		drawerForAdapter.bringToFront();
		return false;
	}

}
