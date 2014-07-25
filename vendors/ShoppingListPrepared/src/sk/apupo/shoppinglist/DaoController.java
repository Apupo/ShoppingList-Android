package sk.apupo.shoppinglist;

import java.io.File;
import java.lang.reflect.Method;

import sk.apupo.shoppinglist.daos.DaoMaster;
import sk.apupo.shoppinglist.daos.DaoMaster.DevOpenHelper;
import sk.apupo.shoppinglist.daos.DaoSession;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;

public class DaoController {
	
	private static final String DB_NAME					=					"shoppinglist.sqlite";
	
	private DevOpenHelper helper;
	private DaoSession writableSession;
	
	public DaoController(Context context) {
		String path = context.getExternalFilesDir(null) + File.separator + DB_NAME;
		this.helper = new DaoMaster.DevOpenHelper(context, path, null);
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
		}
		
		return null;
	}
}
