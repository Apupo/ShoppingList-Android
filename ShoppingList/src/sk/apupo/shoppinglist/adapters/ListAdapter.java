package sk.apupo.shoppinglist.adapters;

import android.content.Context;
import android.widget.AbsListView;

import java.util.ArrayList;
import java.util.Observable;

import sk.apupo.shoppinglist.interfaces.ObserverBase;
import sk.apupo.shoppinglist.views.DataRendererView;


public class ListAdapter extends ObservableBaseAdapter {

	public ListAdapter(Context context, AbsListView absListView, ArrayList<Observable> observableDataList) {
		super(context, absListView, observableDataList);
	}
	
	@Override
	protected ObserverBase instantiateObserverView() {
		return new DataRendererView(getContext());
	}
}
