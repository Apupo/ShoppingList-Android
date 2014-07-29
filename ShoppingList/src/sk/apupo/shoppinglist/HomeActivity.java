package sk.apupo.shoppinglist;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sk.apupo.shoppinglist.controllers.AppController;
import sk.apupo.shoppinglist.daos.Product;
import sk.apupo.shoppinglist.daos.ProductDao;
import android.app.Activity;
import android.os.Bundle;

public class HomeActivity extends Activity {
	
	private final Logger logger = LoggerFactory.getLogger(HomeActivity.class);
	
	private AppController mApp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity_layout);
		
		mApp = (AppController) getApplicationContext();
		
		ProductDao dao = (ProductDao) mApp.getDaoController().getDao(ProductDao.class);
		List<Product> list = dao.queryBuilder().build().list();
	}
}
