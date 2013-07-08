package org.bangbang.support.v4.demo;

import org.bangbang.android.support.v4.R;
import org.bangbang.support.v4.widget.GridView;
import org.bangbang.support.v4.widget.HGridView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListAdapter;

public class GridViewDemo extends Activity {

	private static final int OBJECTS = 50;
	public HGridView mHGrid;
	public GridView mGrid;
	private ListAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview);
		
		mHGrid = (HGridView) findViewById(R.id.hgrid);
		mGrid = (GridView) findViewById(R.id.grid);
		
		String[] objects = new String[OBJECTS];
		for (int i = 0 ; i < OBJECTS ; i++) {
			objects[i] = "data " + i;
		}
		
		mAdapter = new SimpleDataAdapter(this, android.R.layout.simple_list_item_1, objects);
		
		mHGrid.setAdapter(mAdapter);
		mGrid.setAdapter(mAdapter);
	}

}
