package sk.apupo.shoppinglist.controllers;

import android.app.Application;
import android.os.Environment;

import com.activeandroid.ActiveAndroid;

import java.io.File;

public class ApplicationController extends com.activeandroid.app.Application {
	
	//public final Logger logger = LoggerFactory.getLogger();

	public ApplicationController() {
	}
	
	@Override
	public void onCreate() {
		super.onCreate();

        ActiveAndroid.initialize(this);

		initLogger();
	}

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }

    protected void initLogger() {
		/*PropertyConfigurator.getConfigurator(this).configure();
		FileAppender fa = new FileAppender();
		fa.setFileName("log.text");
		logger.addAppender(fa);
		logger.info("Application started");*/
	}
	
	public File getLogFile() {
		File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + File.separator + "log.text");
		return file;
	}
}
