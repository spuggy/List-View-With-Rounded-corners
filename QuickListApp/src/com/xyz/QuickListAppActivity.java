package com.xyz;

import java.util.ArrayList;
import java.util.List;




import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class QuickListAppActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        AdapterView<MyListAdapter> lv = (AdapterView<MyListAdapter>) findViewById(R.id.listView1);
		
		MyListAdapter listAdapter = new MyListAdapter();

        
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2" };
		
        
		
        LayoutInflater inflater = getLayoutInflater();  
		
		int item_layout = 0 ;
		
		for(int i = 0 ; i < values.length;i++) {
		
			//decide which layout to show depending on the item position
			if(i==0) {
				item_layout = R.layout.top_list_layout ;
			} else if(i==values.length-1) {
				item_layout = R.layout.bottom_list_layout;
			} else {
				item_layout = R.layout.mid_list_layout;
			}
			
			
			TextView button = (TextView)inflater.inflate(item_layout, null); 

			button.setText(values[i]);
			button.setTag(new Integer(i));
			
			listAdapter.addView(button);
		}
        
        
        
		
		//lv.setSelector(R.color.transparent);
		lv.setAdapter(listAdapter);

        
        
        
    }
    
    
    //custom list adapter so I can add items as I go with addView
    static class MyListAdapter extends BaseAdapter {	
		

		private List<View> views = new ArrayList<View>();
		
		public void addView(View view){
			views.add(view);
		}
		
		public int getCount() {
			return views.size();
		}
		
		public Object getItem(int position) {
			return views.get(position).getTag();
		}
		
		public long getItemId(int position) {
			return views.get(position).getId();
		}
		
		public View getView(int position, View convertView, ViewGroup parent) {
			return views.get(position);
		}
	}
}