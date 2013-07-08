package org.bangbang.support.v4.demo;

import org.bangbang.android.support.v4.R;
import org.bangbang.support.v4.widget.HListView;
import org.bangbang.support.v4.widget.ListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.TextView;

public class ListViewCompareDemo extends Activity {

	private static final int LIMIT = 20;
	private ListView mList;
	private HListView mHList;
	private ListAdapter mAdapter;
	private android.widget.ListView mAndroidList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview_compare);
		
		mList = (ListView) findViewById(R.id.list);
		mHList = (HListView) findViewById(R.id.hlist);
		mAndroidList = (android.widget.ListView)findViewById(R.id.android_list);
		findViewById(R.id.hrandom_selection).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int position = (int) (LIMIT * Math.random());
				((TextView)findViewById(R.id.hrandom_number)).setText("current selection: " + position+ "");
				mHList.setSelection(position);
			}
		});
		findViewById(R.id.random_selection).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int position = (int) (LIMIT * Math.random());
				((TextView)findViewById(R.id.random_number)).setText("current selection: " + position+ "");
				mList.setSelection(position);
			}
		});
		findViewById(R.id.android_random_selection).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int position = (int) (LIMIT * Math.random());
				((TextView)findViewById(R.id.android_random_number)).setText("current selection: " + position+ "");
				mAndroidList.setSelection(position);
			}
		});
		
		
		String[] objects = new String[LIMIT];
		for (int i = 0 ; i < LIMIT ; i++) {
			objects[i] = "data " + i;
		}
		
		mAdapter = new SimpleDataAdapter(this, android.R.layout.simple_list_item_1, objects);
		
		mList.setAdapter(mAdapter);		
		mHList.setAdapter(mAdapter);
		mAndroidList.setAdapter(mAdapter);
	}
}
