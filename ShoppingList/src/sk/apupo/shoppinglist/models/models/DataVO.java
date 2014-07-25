package sk.apupo.shoppinglist.models.models;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Observable;

public class DataVO extends Observable {

	private String mName;
	public String getName() { return mName; }
	public void setName(String name) {
		if(mName != null && mName.equals(name)) return;
		mName = name;
		setChanged();
		notifyObservers(this);
	}
	
	public DataVO(String name) {
		setName(name);
	}
	
	public long getId() {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        byte[] messageDigest = md.digest(mName.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String md5 = number.toString(16);
        return number.longValue();
	}
}
