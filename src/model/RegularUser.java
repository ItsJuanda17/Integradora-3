package model;

import java.util.Calendar;

public class RegularUser extends User {

	/**
	 * 
	 * @param name
	 * @param cc
	 * @param vinculationDate
	 */
	public RegularUser(String name, String cc, Calendar vinculationDate) {
		super(name , cc , vinculationDate);

	}

	public String toString(){
		return "Usuario: " + super.toString();
	}

}