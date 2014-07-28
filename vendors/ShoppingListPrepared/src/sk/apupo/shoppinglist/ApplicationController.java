package sk.apupo.shoppinglist;

import sk.apupo.android.dao.DaoController;
import android.app.Application;

public class ApplicationController extends Application {
	
	private DaoController daoController;
	public DaoController getDaoController() { return this.daoController; }

	public ApplicationController() {
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		if(this.daoController == null) {
			this.daoController = new DaoController(this);
		}
	}

}
