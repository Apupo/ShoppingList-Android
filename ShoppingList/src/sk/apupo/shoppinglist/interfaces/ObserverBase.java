package sk.apupo.shoppinglist.interfaces;

import java.util.Observable;
import java.util.Observer;

public interface ObserverBase extends Observer {
	public void setData(Observable data);
	public Observable getData();
}
