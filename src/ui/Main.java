package ui;

import java.util.Calendar;
import java.util.Scanner;
import model.ControllerReadX;

public class Main {

	private ControllerReadX controller;
	private Scanner reader;

	public Main(){
		this.reader= new Scanner(System.in);
		controller = new ControllerReadX();

	}

	public static void main(String[] args) {

		Main view = new Main();

		int option= 0;

		do{

			view.menu();
			option = view.validateIntegerInput();
			view.executeOption(option);


		}while (option !=0);

		view.reader.close();
		
	}

	public void menu(){
			System.out.println("0. Exit the system");
			System.out.println("1. Register User");
			
	}

	public void executeOption(int option){
		switch(option){
			case 0:
			    System.out.println("Thanks for using the system");
			
			case 1:
			    registerUser();
				break;
			
			default :
			    System.out.println("Plesea type an option valid");
			 

		}
	}

	public int validateIntegerInput(){
		int option=0;
		if(reader.hasNextInt()){
			option = reader.nextInt();
		
		}else{
			reader.nextLine();
			option = -1;
			System.out.println("Please , enter an integer value ");
		}
		return option;
	}

	public void registerUser() {

		System.out.println("Hi , please enter the user name");
		String name = reader.next();

		System.out.println("Type the user document");
		String cc= reader.next();

		System.out.println("Type the vinculation year");
		int year= reader.nextInt();

		System.out.println("Type the vinculation month, remember(1-12)");
		int month = reader.nextInt() -1;

		System.out.println("Type the vinculation day ");
		int day = reader.nextInt();

		Calendar vinculationDate = Calendar.getInstance();
		
		vinculationDate.set(year , month , day);

		System.out.println("Please select the type of your user");
		System.out.println("1. REGULAR USER");
		System.out.println("2.PREMIUM USER");

		int type = reader.nextInt();

		controller.createUser(name, cc, vinculationDate, type);

		
	}

	public void registerBibliographicProducts() {
		// TODO - implement Main.registerBibliographicProducts
		throw new UnsupportedOperationException();
	}

	public void updateBibliographicProducts() {
		// TODO - implement Main.updateBibliographicProducts
		throw new UnsupportedOperationException();
	}

}