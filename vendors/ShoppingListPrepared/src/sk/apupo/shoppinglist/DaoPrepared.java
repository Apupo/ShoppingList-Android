package sk.apupo.shoppinglist;

import java.util.ArrayList;

import sk.apupo.android.dao.DaoController;
import sk.apupo.shoppinglist.daos.Product;
import sk.apupo.shoppinglist.daos.ProductDao;

import android.content.Context;
import android.util.Log;

public class DaoPrepared {
	
	private final String attributes[] = new String[]{"names.txt", "main_group.txt", "sub_group.txt", "comodity.txt", "sub_comodity.txt"};

	private DaoController daoController;
	
	private Context context;
	
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public DaoPrepared(Context context, DaoController dc) {
		this.context = context;
		this.daoController = dc;
	}

	public boolean runPreparedFromAssets() {
		for (int i = 0; i < attributes.length; i++) {
			ArrayList<Object> arr = AssetsFileReader.readStringFile(this.context, attributes[i]);
			fillProjects(attributes[i].toString(), arr);
		}
		
		ProductDao pdao = (ProductDao) this.daoController.getDao(ProductDao.class);
		Log.d(this.getClass().getSimpleName(), "Start inserting");
		pdao.insertInTx(this.products);
		Log.d(this.getClass().getSimpleName(), "Inserting finished");
		return true;
	}
	
	protected void fillProjects(String name, ArrayList<Object> arr) {
		Product product = null;
		
		for (int i = 0; i < arr.size(); i++) {
			product = getProductFromIntex(i);
			
			String str = arr.get(i).toString();
			
			if(name.equalsIgnoreCase("names.txt")) {
				product.setTitle(str);
				product.setTitleClean(str.toLowerCase());
			} else if(name.equalsIgnoreCase("main_group.txt")) {
				product.setMainGroup(str);
			} else if(name.equalsIgnoreCase("sub_group.txt")) {
				product.setSubGroup(str);
			} else if(name.equalsIgnoreCase("comodity.txt")) {
				product.setComodity(str);
			} else if(name.equalsIgnoreCase("sub_comodity.txt")) {
				product.setSubComodity(str);
			}
			
		}
	}
	
	protected Product getProductFromIntex(int index) {
		Product product = null;
		
		try {
			product = this.products.get(index);
		} catch (Exception e) {
			product = new Product();
			this.products.add(product);
		}
		
		return this.products.get(index);
	}
}
