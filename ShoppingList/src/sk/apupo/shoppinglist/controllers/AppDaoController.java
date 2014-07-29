package sk.apupo.shoppinglist.controllers;

import sk.apupo.android.dao.DaoController;
import sk.apupo.android.utils.FileUtil;
import android.content.Context;

public class AppDaoController extends DaoController {

	public AppDaoController(Context context, String databaseName, Class<?> devOpenHelperClass, Class<?> daoMasterClass, Class<?> daoSessionClass) {
		super(context, databaseName, devOpenHelperClass, daoMasterClass, daoSessionClass);
	}
	
	@Override
	protected boolean initializeHelper() {
		if(!getDatabaseFile().isFile()) {
			FileUtil.copyDatabaseFromAssets(getContext(), getDatabaseName(), getDatabasePath());
		}
		
		return super.initializeHelper();
	}
}
