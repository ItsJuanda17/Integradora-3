package model;
import java.util.Calendar;

public class PremiumUser extends User {

	/**
	 * 
	 * @param name
	 * @param cc
	 * @param vinculationDate
	 */
	public PremiumUser(String name, String cc, Calendar vinculationDate) {
		super(name , cc , vinculationDate);
	}

}