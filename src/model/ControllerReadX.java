package model;


import java.util.ArrayList;
import java.util.Calendar;

public class ControllerReadX {

	private ArrayList <User> userList;

	public ControllerReadX(){

		userList = new ArrayList<User>();
	}

	public void createUser(String name , String cc , Calendar vinculationDate , int type){

		User user= null;

		switch(type){
			case 1 :
			    user = new RegularUser(name, cc, vinculationDate);
				break;
			case 2 : 
			    user = new PremiumUser(name, cc, vinculationDate);
				break;
			default : System.out.println("Please type a valid option");

		}
		if (user !=null){
			userList.add(user);
			System.out.println("User successfully registered");
		}


	}

	
}