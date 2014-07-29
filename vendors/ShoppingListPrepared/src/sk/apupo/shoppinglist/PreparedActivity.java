package sk.apupo.shoppinglist;

import java.util.List;

import sk.apupo.shoppinglist.daos.Product;
import sk.apupo.shoppinglist.daos.ProductDao;
import sk.apupo.shoppinglist.daos.ProductEntity;
import android.app.Activity;
import android.os.Bundle;

public class PreparedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prepared_activity_layout);
		
		DaoPrepared dp = new DaoPrepared(this, ((ApplicationController) getApplicationContext()).getDaoController());
		boolean finished = dp.runPreparedFromAssets();
		
		ProductDao dao = (ProductDao) ((ApplicationController) getApplicationContext()).getDaoController().getDao(ProductDao.class);
		List<Product> list = dao.queryBuilder().build().list();
		Product p = list.get(0);
	}
}
