package ui;

import java.util.Calendar;
import java.util.Scanner;



import model.BibliographicProducts;
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
			System.out.println("4.Bibliographic's list");
			System.out.println("5.Modify bibliographic products");
			System.out.println("6.Delete bibliographic products");
			System.out.println("7.Buy bibliographic products");
			System.out.println("8.Unsubscribe of a magazine");
			
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
				break;
			
			case 3:
			    registerBibliographicProducts();
				break;
			
			case 4:
			    controller.displayProductListAll();
				break;

			case 5:
			    modifyBibliographicProducts();
				break;

			case 6:
			    deleteBibliographicProducts();
				break;

			case 7:
			    buyBookAndSubscribeToMagazine();
			    break;

			case 8:
				unsubscribeMagazine();
				break;

			default :
			    System.out.println("Plesea type an option valid");
			break;
			 
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
		reader.nextLine();

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

	public void modifyBibliographicProducts() {
		
			System.out.println("MODIFY BIBLIOGRAPHIC PRODUCTS");
			System.out.println("Enter the name of the product to modify: ");
			String productName = reader.next();
		
			BibliographicProducts product = controller.findProductByName(productName);
		
			if (product == null) {
				System.out.println("Product not found");
				return;
			}
		
			System.out.println("The product is found");
			controller.displayProductList(product);
		
			System.out.println("Please select the type of product to modify (1. Book, 2. Magazine): ");
			int productType = reader.nextInt();
			reader.nextLine();
		
			System.out.println("New name: ");
			String newName = reader.nextLine();
			
			System.out.println("New pagesNumber: ");
			int newPagesNumber = reader.nextInt();
			reader.nextLine();
		
			System.out.print("New URL: ");
			String newURL = reader.nextLine();
		
		
			System.out.print("New product value: ");
			double newProductValue = reader.nextDouble();
		
			System.out.println("New publication date:");
			System.out.print("Year: ");
			int year = reader.nextInt();
			System.out.print("Month: ");
			int month = reader.nextInt();
			System.out.print("Day: ");
			int day = reader.nextInt();
		
			Calendar newPublicationDate = Calendar.getInstance();
			newPublicationDate.set(year, month - 1, day);

				if (productType == 1) {
					reader.nextLine();

				 System.out.println("New short review: ");
				 String newShortReview = reader.nextLine();

				 System.out.print("New genre (1. for Science Fiction, 2. for Fantasy, 3. for Historical Novel): ");
				 int newGenre = reader.nextInt();

				 controller.modifyProduct(product, productName, newName, newPagesNumber, newPublicationDate, newProductValue, newURL, newShortReview, null, newGenre, 0);

			    }else if(productType==2){
					reader.nextLine();

					System.out.println("New periodicity of issuance : ");
					String  newPeriodicityOfIssuance = reader.nextLine();

					System.out.println("select the new category (1.Varieties , 2.Design , 3.Scientific )");
					int newCategory = reader.nextInt();

					controller.modifyProduct(product, productName, newName, newPagesNumber, newPublicationDate, newProductValue, newURL, null, newPeriodicityOfIssuance, 0, newCategory);

				}
				
				 else {
					System.out.println("Invalid product type");
				}
				controller.displayProductList(product);
	}
    
	//Corregir error de que solo puede recibir una palabra 
	public void deleteBibliographicProducts(){
		    
		   
			System.out.println("\nPlease enter the name of the product that you want to delete: ");
			String productName = reader.next();
			
			
			boolean delete = controller.deleteBibliographicProducts(productName);
		
			if (delete) {
				System.out.println("The product has been deleted");
			} else {
				System.out.println("The product name was not found");
			}
		
		
		
	}

	public void buyBookAndSubscribeToMagazine() {
		System.out.println("BUY BOOK AND SUBSCRIBE TO MAGAZINE");
		System.out.println("Please select an option:");
		System.out.println("1. Buy a book");
		System.out.println("2. Subscribe to a magazine");

		int option = validateIntegerInput();

		switch(option){

			case 1 : 

			System.out.println("BUY BOOK");
			System.out.println("Please enter the name of the book you want to buy: ");
			String bookName = reader.next();
		
			// Obtener la fecha actual del controlador
			Calendar operationDateBook = controller.generateCurrentDate();

			System.out.println("Please enter the money with which you are going to make the purchase :");
			double money = reader.nextDouble();
		
			// Comprar el libro
			String buyBookResult = controller.buyBook(bookName, operationDateBook , money);
			System.out.println(buyBookResult);
			break;

			case 2: 

			System.out.println("SUBSCRIBE TO MAGAZINE");
			System.out.println("Please enter the name of the magazine you want to subscribe to: ");
			String magazineName = reader.next();
		
			// Obtener la fecha actual del controlador
			Calendar operationDateMagazine = controller.generateCurrentDate();

			System.out.println("Please enter the money with which you are going to make the purchase :");
			double cash = reader.nextDouble();
		
			// Suscribirse a la revista
			String subscribeMagazineResult = controller.subscribeToMagazine(magazineName, operationDateMagazine, cash);
			System.out.println(subscribeMagazineResult);
			break;
		}
	}

	public void unsubscribeMagazine(){

		System.out.println("Please enter the name of the magazine that you want unsubscribe: ");
		String name = reader.next();

		controller.unsubscribeMagazine(name);
	}


		






}


		


		
   
