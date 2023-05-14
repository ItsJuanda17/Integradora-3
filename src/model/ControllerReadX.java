package model;


import java.util.ArrayList;
import java.util.Calendar;

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

	public String registerBook(String name,  int pagesNumber, Calendar publicationDate, int accumulatedPagesRead,double productValue, String URL, String shortReview, int copiesSold, int genre   ){

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

		return "The book has been successfully registered";

	}

	
	public String registerMagazine(String name, int pagesNumber, Calendar publicationDate, int accumulatedPagesRead, double productValue, String URL, String periodicityOfIssuance, int activeSuscriptions, int category){

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

		return "The magazine has been successfully registered";

	}



	

}
