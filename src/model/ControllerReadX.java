package model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class ControllerReadX {

	private ArrayList <User> userList;
	private ArrayList<BibliographicProducts> productList;
	private ArrayList <Bill> billList;

	public ControllerReadX(){

		userList = new ArrayList<User>();
		productList = new ArrayList<BibliographicProducts>();
		billList = new ArrayList <Bill>();
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

	public ArrayList <User> getUserList(){
		
		return userList;
	}

	public void showUserList() {
        System.out.println("Lista de usuarios:");
        for (User user : userList) {
            System.out.println("Nombre: " + user.getName() + ", CC: " + user.getCC());

	
        }

	}

	public Calendar generateCurrentDate(){
		return Calendar.getInstance();
	}

	public void registerBook(String name,  int pagesNumber, Calendar publicationDate, int accumulatedPagesRead,double productValue, String URL, String shortReview, int copiesSold, int genre   ){

		Genre bookGenre;

		if(genre == 1){

			bookGenre= Genre.FANTASY;

		}else if(genre == 2){

			bookGenre= Genre.SCIENCE_FICTION;

		}else{

		    bookGenre = Genre.HISTORICAL_NOVEL;

		}

		Book book = new Book(name,  pagesNumber, publicationDate, accumulatedPagesRead,  productValue, URL, shortReview, copiesSold, bookGenre );
		productList.add(book);

		System.out.println("The book has been succesfully registered");;

	}

	
	public void registerMagazine(String name, int pagesNumber, Calendar publicationDate, int accumulatedPagesRead, double productValue, String URL, String periodicityOfIssuance, int activeSuscriptions, int category){

		Category magazineCategory;

		if(category == 1){

			magazineCategory= Category.VARIETIES;

		}else if(category == 2){

			magazineCategory= Category.DESIGN;

		}else{

		    magazineCategory = Category.SCIENTIFIC;

		}

		Magazine magazine = new Magazine(name, pagesNumber, publicationDate,  accumulatedPagesRead, productValue, URL,  periodicityOfIssuance,  activeSuscriptions, magazineCategory);
		productList.add(magazine);

		System.out.println("The magazine has been successfully registered");

	}

	//Lista para ver los productos por nombre 
	public void displayProductList(BibliographicProducts productToShow) {

		System.out.println("--------------------");
		System.out.println("LIST OF BIBLIOGRAPHIC PRODUCTS");
		
		for (BibliographicProducts product : productList) {
			if(productToShow != null && !product.equals(productToShow)){
				continue;
			}
			String id = product.generateRandomId();
			System.out.println("Product ID: " + id);
			System.out.println("Name: " + product.getName());
			System.out.println("Pages Number: " + product.getPagesNumber());
			System.out.println("Publication Date: " + formatPublicationDate(product.getPublicationDate()));
			System.out.println("Accumulated Pages Read: " + product.getAccumulatedPagesRead());
			System.out.println("Product Value: " + product.getProductValue());
			System.out.println("URL: " + product.getURL());
			
			if (product instanceof Book) {
				Book book = (Book) product;
				
				System.out.println("Short Review: " + book.getShortReview());
				System.out.println("Copies Sold: " + book.getCopiesSold());
				System.out.println("Genre: " + book.getGenre());
			} else if (product instanceof Magazine) {
				Magazine magazine = (Magazine) product;
				
				System.out.println("Periodicity of Issuance: " + magazine.getPeriodicityOfIssuance());
				System.out.println("Active Subscriptions: " + magazine.getActiveSubscriptions());
				System.out.println("Category: " + magazine.getCategory());
			}
			
			System.out.println("--------------------");
		}
	}
	
	private String formatPublicationDate(Calendar publicationDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(publicationDate.getTime());
	}

	public BibliographicProducts findProductByName(String productName){
		for (BibliographicProducts product : productList) {
			if (product.getName().equals(productName)) {
				return product;
			}
		}
		return null;
	}

	public User findUserByName(String userName) {
		for (User user : userList) {
			if (user.getName().equalsIgnoreCase(userName)) {
				return user;
			}
		}
		return null; 
	}

	
	
	public String modifyProduct( String productName , String newName , int newPagesNumber ,Calendar newPublicationDate, double newProductValue , String newURL , String newShortReview , String newPeriodicityOfIssuance, int newGenre , int newCategory  ){

		   BibliographicProducts product = findProductByName(productName);
		
			if (product == null) {
				
				return "product not found";
			}
		
			System.out.println("The product is found");
			displayProductList(product);
		
		if (product instanceof Book ){

			Book book = (Book) product;

			book.setName(newName);
			book.setPagesNumber(newPagesNumber);
			book.setPublicationDate(newPublicationDate);
			book.setProductValue(newProductValue);
			book.setURL(newURL);
			book.setShortReview(newShortReview);
			
			Genre genre;

			if(newGenre == 1){
				genre = Genre.SCIENCE_FICTION;

			}else if(newGenre == 2 ){
				genre = Genre.FANTASY;
			
			}else{
				genre = Genre.HISTORICAL_NOVEL;
			}

			book.setGenre(genre);


		}else if (product instanceof Magazine ){
			Magazine magazine = (Magazine) product;

			magazine.setName(newName);
			magazine.setPagesNumber(newPagesNumber);
			magazine.setPublicationDate(newPublicationDate);
			magazine.setProductValue(newProductValue);
			magazine.setURL(newURL);
			magazine.setPeriodicityOfIssuance(newPeriodicityOfIssuance);
			
			Category category;
			
			if(newCategory==1){
				category = Category.VARIETIES;
			
			}else if (newCategory==2){
				category = Category.DESIGN;

			}else{
				category = Category.SCIENTIFIC;
			}
			magazine.setCategory(category);	
		}
		
		return "The product has been succesfully registered";
		

	}

	public boolean deleteBibliographicProducts(String productName){
		for (BibliographicProducts product : productList) {
			if (product.getName().equals(productName)) {
				productList.remove(product);
				return true;
			}
		}
		return false;
	}
	
	//Lista para ver todos los productos registrados 
	public void displayProductListAll() {

		System.out.println("--------------------");
		System.out.println("LIST OF BIBLIOGRAPHIC PRODUCTS");
		
		for (BibliographicProducts product : productList) {
			
			String id = product.generateRandomId();
			System.out.println("Product ID: " + id);
			System.out.println("Name: " + product.getName());
			System.out.println("Pages Number: " + product.getPagesNumber());
			System.out.println("Publication Date: " + formatPublicationDate(product.getPublicationDate()));
			System.out.println("Accumulated Pages Read: " + product.getAccumulatedPagesRead());
			System.out.println("Product Value: " + product.getProductValue());
			System.out.println("URL: " + product.getURL());
			
			if (product instanceof Book) {
				Book book = (Book) product;
				
				System.out.println("Short Review: " + book.getShortReview());
				System.out.println("Copies Sold: " + book.getCopiesSold());
				System.out.println("Genre: " + book.getGenre());
			} else if (product instanceof Magazine) {
				Magazine magazine = (Magazine) product;
				
				System.out.println("Periodicity of Issuance: " + magazine.getPeriodicityOfIssuance());
				System.out.println("Active Subscriptions: " + magazine.getActiveSubscriptions());
				System.out.println("Category: " + magazine.getCategory());
			}
			
			System.out.println("--------------------");
		}
	}

	public void saveBill(Bill bill){
		billList.add(bill);
	}

	
	public void buyBook(String userName, String bookName, Calendar operationDate, double amountPaid) {
		User user = findUserByName(userName);
		if (user == null) {
			System.out.println("User not found");
			return;
		}
	
		BibliographicProducts product = findProductByName(bookName);
		if (product instanceof Book) {
			Book book = (Book) product;
			double price = book.getProductValue();
	
			if (amountPaid >= price) {
				double change = amountPaid - price;
				Bill bill = new Bill(operationDate, amountPaid);
				book.updateCopiesSold();
				saveBill(bill);
	
				user.addPurchasedProduct(book);
	
				System.out.println("The book has been purchased successfully. Change: $" + change);
			} else {
				System.out.println("Insufficient payment. The book price is: $" + price);
			}
		} else {
			System.out.println("Invalid product type");
		}
	}

	public void subscribeToMagazine(String userName, String magazineName, Calendar operationDate, double amountPaid) {
		User user = findUserByName(userName);
		if (user == null) {
			System.out.println("User not found");
			return;
		}
	
		BibliographicProducts product = findProductByName(magazineName);
		if (product instanceof Magazine) {
			Magazine magazine = (Magazine) product;
			double price = magazine.getProductValue();
	
			if (amountPaid >= price) {
				double change = amountPaid - price;
				Bill bill = new Bill(operationDate, amountPaid);
				magazine.increaseActiveSubscriptions();
				saveBill(bill);
	
				user.addPurchasedProduct(magazine);
	
				System.out.println("The magazine has been subscribed successfully. Change: $" + change);
			} else {
				System.out.println("Insufficient payment. The magazine price is: $" + price);
			}
		} else {
			System.out.println("Invalid product type");
		}
	}

	public void unsubscribeMagazine(String userName, String magazineName) {
		User user = findUserByName(userName);
		if (user == null) {
			System.out.println("User not found");
			return;
		}
	
		BibliographicProducts product = findProductByName(magazineName);

		if (product instanceof Magazine) {
			Magazine magazine = (Magazine) product;
	
			if (magazine.getActiveSubscriptions() > 0) {
				magazine.unsubscribeMagazine();
				System.out.println("Subscription to the magazine has been canceled successfully");
			} else {
				System.out.println("There are no active subscriptions for the magazine");
			}
		} else {
			System.out.println("Invalid product type");
		}
	}

	
	public int getAccumulatedPagesRead(BibliographicProducts product) {
		if (product != null) {
			return product.getAccumulatedPagesRead();
		} else {
			return 0; 
		}
	}

	
	public void startReadingSession(BibliographicProducts product, int currentPage) {
		if (product != null) {
			System.out.println("Starting reading session for: " + product.getName());
			System.out.println("Actual progress: " + product.getAccumulatedPagesRead() + " pages read");
			System.out.println("Total pages: " + product.getPagesNumber());
			System.out.println("Current page: " + currentPage);
	
			
		} else {
			System.out.println("The product was not found. Please verify the name entered.");
		}
	}
	
	public int processOption(String option, int currentPage, int totalPages, BibliographicProducts product) {
		switch (option) {
			case "A":
				if (currentPage > 1) {
					currentPage--;
				} else {
					System.out.println("You are already on the first page of the book.");
				}
				break;
			case "S":
				if (currentPage < totalPages) {
					currentPage++;
					product.setAccumulatedPagesRead(product.getAccumulatedPagesRead() + 1);
				} else {
					System.out.println("You are already on the last page of the book.");
				}
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				
		}
		return currentPage;
	}

	public void showLibrary(String userName) {
		User user = findUserByName(userName);
		if (user != null) {
			ArrayList<BibliographicProducts> userProducts = user.getPurchasedProducts();
			Collections.sort(userProducts, Comparator.comparing(BibliographicProducts::getPublicationDate));
	
			int rows = 5;
			int columns = 5;
	
			int currentPage = 1;
			int startIndex = (currentPage - 1) * (rows * columns);
			int endIndex = Math.min(startIndex + (rows * columns), userProducts.size());
	
			Scanner scanner = new Scanner(System.in);
	
			while (true) {
				System.out.println("Biblioteca de: " + userName);
				System.out.println();
	
				for (int i = startIndex; i < endIndex; i++) {
					int row = (i - startIndex) / columns;
					int column = (i - startIndex) % columns;
	
					if (i < userProducts.size()) {
						BibliographicProducts product = userProducts.get(i);
						System.out.print(product.generateRandomId() + " | ");
					} else {
						System.out.print("    | ");
					}
	
					if (column == columns - 1) {
						System.out.println();
					}
				}
	
				System.out.println("----------------------------------");
				System.out.println("Options:");
				System.out.println("Enter the x,y coordinate or the corresponding code of the bibliographic product to start a reading session");
				System.out.println("Enter 'A' to go to the previous page");
				System.out.println("Enter 'S' to go to the next page");
				System.out.println("Enter 'E' to exit");
				System.out.println();
	
				String option = scanner.next();
	
				if (option.equalsIgnoreCase("A")) {
					if (currentPage > 1) {
						currentPage--;
						startIndex = (currentPage - 1) * (rows * columns);
						endIndex = Math.min(startIndex + (rows * columns), userProducts.size());
					} else {
						System.out.println("You are already on the first page.");
					}
				} else if (option.equalsIgnoreCase("S")) {
					if (endIndex < userProducts.size()) {
						currentPage++;
						startIndex = (currentPage - 1) * (rows * columns);
						endIndex = Math.min(startIndex + (rows * columns), userProducts.size());
					} else {
						System.out.println("You are already on the last page.");
					}
				} else if (option.equalsIgnoreCase("E")) {
					System.out.println("Exiting library.");
					break;
				} else {
					try {
						String[] coordinates = option.split(",");
						int x = Integer.parseInt(coordinates[0]);
						int y = Integer.parseInt(coordinates[1]);
	
						int index = startIndex + (x * columns) + y;
	
						if (index >= startIndex && index < endIndex) {
							BibliographicProducts selectedProduct = userProducts.get(index);
							int currentPageForProduct = 1; // Definir la página actual para el producto
							startReadingSession(selectedProduct, currentPageForProduct);
						} else {
							System.out.println("Invalid option. Please try again.");
						}
					} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
						System.out.println("Invalid option. Please try again.");
					}
				}
			}
	
			scanner.close();
		} else {
			System.out.println("User not found. Please check the username entered.");
		}
	}
	
	

	

	
	
	
	

	


}







