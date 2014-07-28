package sk.apupo.shoppinglist.controllers;

import sk.apupo.android.app.ApplicationController;
import sk.apupo.android.dao.DaoController;
import sk.apupo.shoppinglist.models.daos.DaoMaster;
import sk.apupo.shoppinglist.models.daos.DaoSession;
import sk.apupo.shoppinglist.models.daos.DaoMaster.DevOpenHelper;

public class AppController extends ApplicationController {

	public AppController() {
	}

	@Override
	protected DaoController instantiateDaoController() {
		return new DaoController(AppController.this, DevOpenHelper.class, DaoMaster.class, DaoSession.class);
	}
}
