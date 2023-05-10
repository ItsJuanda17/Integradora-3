public class Book extends BibliographicProducts {

	private String shortReview;
	private int copiesSold;

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
	public Book(String name, int pagesNumber, date publicationDate, int accumulatedPagesRead, String id, double productValue, String URL, String shortReview, int copiesSold, Genre genre) {
		// TODO - implement Book.Book
		throw new UnsupportedOperationException();
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