package model;
import java.util.Calendar;
import java.util.Random;

public class Book extends BibliographicProducts {

	private String shortReview;
	private int copiesSold;
	private Genre genre;
	private String id;

	/**
	 * 
	 * @param name
	 * @param pagesNumber
	 * @param publicationDate
	 * @param accumulatedPagesRead
	 * @param id
	 * @param productValue
	 * @param URL
	 * @param shortReview
	 * @param copiesSold
	 * @param genre
	 */
	public Book(String name,  int pagesNumber, Calendar publicationDate, int accumulatedPagesRead, double productValue, String URL, String shortReview, int copiesSold, Genre genre  ) {
		super(name, pagesNumber, publicationDate, accumulatedPagesRead,productValue, URL);
		this.shortReview = shortReview;
		this.copiesSold= copiesSold;
		this.genre = genre;
		this.id = generateRandomId();
		

	}

	public String getShortReview() {
		return this.shortReview;
	}

	/**
	 * 
	 * @param shortReview
	 */
	public void setShortReview(String shortReview) {
		this.shortReview = shortReview;
	}

	public int getCopiesSold() {
		return this.copiesSold;
	}

	/**
	 * 
	 * @param copiesSold
	 */
	public void setCopiesSold(int copiesSold) {
		this.copiesSold = copiesSold;
	}

	@Override
	public String generateRandomId(){

		String character = "0123456789ABCDEF";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 3; i++) {
            int index = random.nextInt(character.length());
            char randomChar = character.charAt(index);
            sb.append(randomChar);
        }
        
        return sb.toString();



	}

}

