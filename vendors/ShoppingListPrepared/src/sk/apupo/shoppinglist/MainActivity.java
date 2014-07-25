package sk.apupo.shoppinglist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DaoController dc = new DaoController(this);
		DaoPrepared dp = new DaoPrepared(this, dc);
		boolean finished = DaoPrepared.runPreparedFromAssets(this);
	}
}
