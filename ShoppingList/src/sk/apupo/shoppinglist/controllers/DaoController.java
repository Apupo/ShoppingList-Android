package sk.apupo.shoppinglist.controllers;

import java.io.File;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sk.apupo.shoppinglist.models.daos.DaoMaster;
import sk.apupo.shoppinglist.models.daos.DaoMaster.DevOpenHelper;
import sk.apupo.shoppinglist.models.daos.DaoSession;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;

public class DaoController {
	
	private static final Logger logger 					= 					LoggerFactory.getLogger(DaoController.class);

	private static final String DB_NAME					=					"shoppinglist.sqlite";
	
	private DevOpenHelper helper;
	private DaoSession writableSession;
	
	public DaoController(Context context) {
		String path = context.getExternalFilesDir(null) + File.separator + DB_NAME;
		this.helper = new DaoMaster.DevOpenHelper(context, path, null);
		logger.info("Create database on path " + path);
	}
	
	private DaoSession getWritableSession() {
		if (this.writableSession == null) {
			SQLiteDatabase db = this.helper.getWritableDatabase();
			DaoMaster daoMaster = new DaoMaster(db);

			this.writableSession = daoMaster.newSession();
		}

		return this.writableSession;
	}
	
	public AbstractDao<?, ?> getDao(Class<?> cls) {
		String function = "get"+cls.getSimpleName();
		Method method = null;
		try {
			method = DaoSession.class.getMethod(function, (Class<?>) null);
			return (AbstractDao<?, ?>) method.invoke(this.getWritableSession(), (Class<?>) null);
		} catch (Exception e) {
			logger.error("Cannot get dao", e);
		}
		
		return null;
	}
}
