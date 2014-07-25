package com.example.drawer_test;

import javax.security.auth.PrivateCredentialPermission;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView; 
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private String[] mPlanetTitles; //Drawer中list_view的数据
	private DrawerLayout mDrawerLayout; // Drawer对象
	private ListView mDListView;// ListView 对象

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer_layout);
		//实例化DrawerLayout对象
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout); 
		//initialize ListView
		initListView();
		
	}
	
	protected void initListView(){
		//实例化ListView对象
		mDListView = (ListView)findViewById(R.id.left_drawer);
		
		//得到ListView的内容
		mPlanetTitles = getResources().getStringArray(R.array.listview_menu);
	
		//利用适配器填装数据
		mDListView.setAdapter( new ArrayAdapter<String>(this, 
				R.layout.drawer_list_item, mPlanetTitles));
		
		//注册list item的点击事件
		mDListView.setOnItemClickListener(new OnItemClickListener()
		{		
			public void OnItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				 // Highlight the selected item, update the title, and close the
                // drawer
				mDListView.setItemChecked(position, true);
				setTitle(mPlanetTitles[position]);
				mDrawerLayout.closeDrawer(mDListView);
			}

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
	}

		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
