package sk.apupo.shoppinglist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import sk.apupo.shoppinglist.adapters.ListAdapter;
import sk.apupo.shoppinglist.adapters.ObservableBaseAdapter;
import sk.apupo.shoppinglist.controllers.ApplicationController;
import sk.apupo.shoppinglist.models.models.DataVO;
import sk.apupo.shoppinglist.utils.AssetsFileReader;
import sk.apupo.shoppinglist.views.DataRendererView;

public class HomeActivity extends Activity {
	
	protected ArrayList<Observable> list = null;
	protected ListView listView;
	protected ObservableBaseAdapter adapter;
	
	private ApplicationController mApp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity_layout);
		
		mApp = (ApplicationController) getApplicationContext();
		
		final Logger logger = LoggerFactory.getLogger(HomeActivity.class);
		logger.debug("Logback first log shwo me please...");
		
		listView = (ListView) findViewById(R.id.home_list_view);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//mApp.logger.debug("On Click Item" + position );
				logger.info("On Click Item" + position );
			}
			
		});
		listView.setRecyclerListener(new AbsListView.RecyclerListener() {
			
			@Override
			public void onMovedToScrapHeap(View view) {
				if(view instanceof DataRendererView) {
					((DataRendererView) view).recycle();
				}
			}
		});
		
		list = new ArrayList<Observable>();
		for (int i = 0; i < 100; i++) {
			DataVO data = new DataVO("Data" + i);
			list.add(data);
		}
		
		adapter = new ListAdapter(this, listView, list);
		listView.setAdapter(adapter);
		
		Button btn = (Button) findViewById(R.id.home_button);
		btn.setText("Update");
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Random r = new Random();
				int ran = r.nextInt(80 - 65) + 65;
				int pos = r.nextInt(100 - 50) + 50;
				((DataVO) list.get(10)).setName("Data change " + ran);
			}
		});

        ArrayList<Object> commodity = AssetsFileReader.readStringFile(this, "commodity");

	}
	
}
