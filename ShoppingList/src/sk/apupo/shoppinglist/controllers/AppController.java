package sk.apupo.shoppinglist.controllers;

import sk.apupo.android.app.ApplicationController;
import sk.apupo.android.dao.DaoController;
import sk.apupo.shoppinglist.daos.DaoMaster;
import sk.apupo.shoppinglist.daos.DaoMaster.DevOpenHelper;
import sk.apupo.shoppinglist.daos.DaoSession;

public class AppController extends ApplicationController {

	private static final String DB_NAME					=					"shoppinglist.sqlite";
	
	public AppController() {
	}

	@Override
	protected DaoController instantiateDaoController() {
		return new AppDaoController(AppController.this, DB_NAME, DevOpenHelper.class, DaoMaster.class, DaoSession.class);
	}
}
