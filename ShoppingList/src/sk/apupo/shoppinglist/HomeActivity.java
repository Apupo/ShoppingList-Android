package sk.apupo.shoppinglist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sk.apupo.android.app.ApplicationController;
import sk.apupo.shoppinglist.controllers.AppController;
import sk.apupo.shoppinglist.models.daos.ProductDao;
import android.app.Activity;
import android.os.Bundle;

public class HomeActivity extends Activity {
	
	private ApplicationController mApp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity_layout);
		
		mApp = (AppController) getApplicationContext();
		
		final Logger logger = LoggerFactory.getLogger(HomeActivity.class);
		logger.debug("Logback first log shwo me please...");
		
		ProductDao dao = (ProductDao) mApp.getDaoController().getDao(ProductDao.class);
	}
}
