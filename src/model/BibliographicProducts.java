package model; 
import java.util.Calendar;


public abstract class BibliographicProducts {

	private String name;
	private int pagesNumber;
	private Calendar publicationDate;
	private int accumulatedPagesRead;
	private double productValue;
	private String URL;

	/**
	 * 
	 * @param name
	 * @param pagesNumber
	 * @param publicationDate
	 * @param accumulatedPagesRead
	 * @param id
	 * @param productValue
	 * @param URL
	 */
	public BibliographicProducts(String name, int pagesNumber, Calendar publicationDate, int accumulatedPagesRead,  double productValue, String URL) {
		this.name = name;
		this.pagesNumber= pagesNumber;
		this.publicationDate= publicationDate;
		this.accumulatedPagesRead=accumulatedPagesRead;
		this.productValue = productValue;
		this.URL= URL;


		
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Calendar getPublicationDate() {
		// TODO - implement BibliographicProducts.getPublicationDate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param publicationDate
	 */
	public void setPublicationDate(Calendar publicationDate) {
		// TODO - implement BibliographicProducts.setPublicationDate
		throw new UnsupportedOperationException();
	}

	

	public double getProductValue() {
		return this.productValue;
	}

	/**
	 * 
	 * @param productValue
	 */
	public void setProductValue(double productValue) {
		this.productValue = productValue;
	}

	public String getURL() {
		// TODO - implement BibliographicProducts.getURL
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param url
	 */
	public void setURL(String url) {
		// TODO - implement BibliographicProducts.setURL
		throw new UnsupportedOperationException();
	}

	public abstract String generateRandomId();

	

}