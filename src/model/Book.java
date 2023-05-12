package model;
import java.util.Calendar;

public class Book extends BibliographicProducts {

	private String shortReview;
	private int copiesSold;
	private Genre genre;

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
	public Book(String name, int pagesNumber, Calendar publicationDate, int accumulatedPagesRead, String id ,double productValue, String URL, String shortReview, int copiesSold, Genre genre ) {
		super(name, pagesNumber, publicationDate, accumulatedPagesRead, id, productValue, URL);
		this.shortReview = shortReview;
		this.copiesSold= copiesSold;
		this.genre = genre;
		

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

}