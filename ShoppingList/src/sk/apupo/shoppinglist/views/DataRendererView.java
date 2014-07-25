package sk.apupo.shoppinglist.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Observable;

import sk.apupo.shoppinglist.R;
import sk.apupo.shoppinglist.interfaces.ObserverBase;
import sk.apupo.shoppinglist.models.models.DataVO;

public class DataRendererView extends RelativeLayout implements ObserverBase {

	private Observable mData;
	@Override
	public void setData(Observable data) {
		mData = data;
		mData.addObserver(this);
		update(null, data);
	}
	@Override
	public Observable getData() {
		return mData;
	}

	
	private TextView nameTextView;
	
	public void recycle() {
		mData.deleteObserver(this);
	}
	
	public DataRendererView(Context context) {
		super(context);
		init(null, 0);
	}

	public DataRendererView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs, 0);
	}

	public DataRendererView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs, defStyle);
	}
	
	protected void init(AttributeSet attras, int defsStyle) {
		LayoutInflater inflater = LayoutInflater.from(getContext());
		inflater.inflate(R.layout.datarenderer, this);
		
		nameTextView = (TextView) findViewById(R.id.data_renderer_name);
	}

	@Override
	public void update(Observable observable, Object data) {
		DataVO dataVO = (DataVO) data;
		nameTextView.setText(dataVO.getName());
	}
}
