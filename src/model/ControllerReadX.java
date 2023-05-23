package model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ControllerReadX {

	private ArrayList <User> userList;
	private ArrayList<BibliographicProducts> productList;

	public ControllerReadX(){

		userList = new ArrayList<User>();
		productList = new ArrayList<BibliographicProducts>();
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
				System.out.println("Active Subscriptions: " + magazine.getActiveSuscriptions());
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

	
	
	public String modifyProduct(BibliographicProducts product, String productName , String newName , int newPagesNumber ,Calendar newPublicationDate, double newProductValue , String newURL , String newShortReview , String newPeriodicityOfIssuance, int newGenre , int newCategory  ){

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
				System.out.println("Active Subscriptions: " + magazine.getActiveSuscriptions());
				System.out.println("Category: " + magazine.getCategory());
			}
			
			System.out.println("--------------------");
		}
	}
}







