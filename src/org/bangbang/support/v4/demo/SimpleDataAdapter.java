package org.bangbang.support.v4.demo;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class SimpleDataAdapter extends ArrayAdapter<String>{

	private static final String TAG = SimpleDataAdapter.class.getSimpleName();

	public SimpleDataAdapter(Context context, int resource,
			int textViewResourceId, List<String> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

	public SimpleDataAdapter(Context context, int resource,
			int textViewResourceId, String[] objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}	

	public SimpleDataAdapter(Context context, int resource,
			int textViewResourceId) {
		super(context, resource, textViewResourceId);
		// TODO Auto-generated constructor stub
	}

	public SimpleDataAdapter(Context context, int textViewResourceId,
			List<String> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

	public SimpleDataAdapter(Context context, int textViewResourceId,
			String[] objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

	public SimpleDataAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.d(TAG, "getView(). position: " + position);
		View v = super.getView(position, convertView, parent);
		
		int bkColor = Color.BLUE;
		if (position % 3 == 1) {
			bkColor = (Color.GRAY);
		} else if (position % 3 == 2) {
			bkColor = (Color.YELLOW);
		} 
//		v.setBackgroundColor(bkColor);
		
		return v;
	}
	
}
