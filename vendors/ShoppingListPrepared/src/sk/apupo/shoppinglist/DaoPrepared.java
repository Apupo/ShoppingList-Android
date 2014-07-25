package sk.apupo.shoppinglist;

import java.util.ArrayList;

import sk.apupo.shoppinglist.daos.Product;
import sk.apupo.shoppinglist.daos.ProductDao;

import android.content.Context;

public class DaoPrepared {
	
	private final String attributes[] = new String[]{"names.txt", "main_group.txt", "sub_group.txt", "comodity.txt", "sub_comodity.txt"};

	private DaoController daoController;
	
	public DaoPrepared(DaoController dc) {
		this.daoController = daoController;
	}

	public boolean runPreparedFromAssets(Context context) {
		ArrayList<ArrayList<Object>> foods = new ArrayList<>();
		
		for (int i = 0; i < attributes.length; i++) {
			ArrayList<Object> arr = AssetsFileReader.readStringFile(context, attributes[i]);
			foods.add(arr);
		}

		ArrayList<Product> products = new ArrayList<Product>();
		int size = foods.get(0).size();
		
		for (int i = 0; i < size; i++) {
			Product product = new Product();
			for (int j = 0; j < foods.size(); j++) {
				//product.set
			}
		}
		
		
		
		ProductDao pdao = (ProductDao) this.daoController.getDao(ProductDao.class);
		
		
		return true;
	}
}
