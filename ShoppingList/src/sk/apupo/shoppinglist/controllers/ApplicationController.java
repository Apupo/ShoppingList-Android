package sk.apupo.shoppinglist.controllers;

import android.app.Application;

public class ApplicationController extends Application {
	
	//public final Logger logger = LoggerFactory.getLogger();
	
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

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
    
}
