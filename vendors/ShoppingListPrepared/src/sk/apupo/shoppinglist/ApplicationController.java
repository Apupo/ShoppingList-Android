package sk.apupo.shoppinglist;

import sk.apupo.android.dao.DaoController;
import sk.apupo.shoppinglist.daos.DaoMaster;
import sk.apupo.shoppinglist.daos.DaoSession;
import sk.apupo.shoppinglist.daos.DaoMaster.DevOpenHelper;
import android.app.Application;

public class ApplicationController extends Application {
	
	private static final String DB_NAME					=					"shoppinglist.sqlite";
	
	private DaoController daoController;
	public DaoController getDaoController() { return this.daoController; }

	public ApplicationController() {
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		if(this.daoController == null) {
			this.daoController = new DaoController(this, DB_NAME, DevOpenHelper.class, DaoMaster.class, DaoSession.class);
		}
	}
}
