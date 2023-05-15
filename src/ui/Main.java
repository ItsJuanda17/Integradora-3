package ui;

import java.util.Calendar;
import java.util.Scanner;
import model.ControllerReadX;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
			System.out.println("2.Users list");
			System.out.println("3.Register bibliographic products");
			System.out.println("4.Bibliographic products list");
			System.out.println("5.Modify bibliographic products");
			
	}

	public void executeOption(int option){
		switch(option){
			case 0:
			    System.out.println("Thanks for using the system");
				break;
			
			case 1:
			    registerUser();
				break;
			
			case 2:
			    controller.showUserList();
			
			case 3:
			    registerBibliographicProducts();
				break;

			case 4:
			    controller.displayProductList();
				break;
			
			
			case 5:
			    updateBibliographicProducts();
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

	private Calendar parsePublicationDate(String publicationDateStr) {
        // Parsear la fecha de publicación en formato dd/mm/yyyy
        String[] dateParts = publicationDateStr.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]) - 1; // Restar 1 porque los meses en Calendar van de 0 a 11
        int year = Integer.parseInt(dateParts[2]);
        
        Calendar publicationDate = Calendar.getInstance();
        publicationDate.set(year, month, day);
        
        return publicationDate;
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

		System.out.println("REGISTER OF BIBLIOGRAPHIC PRODUCTS");
		System.out.println("please select the type of the produtc (1. Book , 2.Magazine)");

		int productType = reader.nextInt();

		if(productType==1){

			String name , URL , shortReview;
			int pagesNumber , genre;
			double productValue;

			reader.nextLine();

			System.out.println("Type the book name: ");
			name = reader.nextLine();

			System.out.println("Type the number pages of the book: ");
			pagesNumber = reader.nextInt();

			System.out.println("Type the publication date (please follow the format DD/MM/YYYY): ");
			String publicationDateStr = reader.next();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

			Date publicationDate;

			try{
				publicationDate = dateFormat.parse(publicationDateStr);

			}catch(ParseException e){
				System.out.println("invalid date format");
				return  ;

			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(publicationDate);

			System.out.println("please type the price of the book");
			productValue = reader.nextDouble();
			reader.nextLine();

			System.out.println("please type the url of the cover page");
			URL = reader.nextLine();

			System.out.print("short description: ");
            shortReview = reader.nextLine();

            System.out.print("Genre (1.SCIENCE FICTION , 2. FANTASY, 3. HISTORICAL NOVEL): ");
            genre = reader.nextInt();

			controller.registerBook(name, pagesNumber, calendar, 0 , productValue, URL, shortReview, 0, genre);





		}else if (productType == 2){
			String name , URL , periodicityOfIssuance ;
			int pagesNumber ,   category;
			double productValue;  

			reader.nextLine();

			System.out.println("Type the magazine name: ");
			name = reader.nextLine();

			System.out.println("Type the pages number of the magazine: ");
			pagesNumber =reader.nextInt();

			System.out.println("Type the publication date (please follow the format DD/MM/YYYY): ");
			String publicationDateStr = reader.next();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

			Date publicationDate;

			try{
				publicationDate = dateFormat.parse(publicationDateStr);

			}catch(ParseException e){
				System.out.println("invalid date format");
				return ;

			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(publicationDate);

			System.out.println("Type the price of the magazine , remember the price is in dollars");
			productValue = reader.nextDouble();

			System.out.println("please type the url of the cover page");
			URL = reader.next();

			System.out.println("please type the periodicity of issuance ");
			periodicityOfIssuance= reader.next();

			System.out.print("categories (1.VARIETIES, 2.DESIGN, 3.SCIENTIFIC) : ");
            category = reader.nextInt();

			controller.registerMagazine(name, pagesNumber, calendar, 0 , productValue, URL, periodicityOfIssuance, 0, category);


		}
		
	}

	public void updateBibliographicProducts() {

		System.out.println("Please type the name of the product that you want to modify");
		String productName = reader.nextLine();
		reader.nextLine();

		System.out.println("Type the new name of the product: ");
		String newName = reader.nextLine();

		System.out.println("Type the new pages number: ");
		int newPagesNumber = reader.nextInt();
		reader.nextLine();

		System.out.println("Type the new publication date: ");
		String newPublicationDateStr = reader.nextLine();
		Calendar newPublicationDate = parsePublicationDate(newPublicationDateStr);
		
		System.out.println("Type the new value of the product: ");
		double newProductValue = reader.nextDouble();
		reader.nextLine();
        
		System.out.println("Type the new URL of the product: ");
		String newURL = reader.nextLine();

		System.out.println("Type the new short review: ");
		String newShortReview = reader.nextLine();

		System.out.println("Type the new periodicity of issuance :");
		String newPeriodicitOfIssuance = reader.nextLine();
	

		String result = controller.modifyProduct(productName, newName, newPagesNumber, newPublicationDate, newProductValue, newURL, newShortReview, newPeriodicitOfIssuance); 
		System.out.println(result); 


		
	}

}