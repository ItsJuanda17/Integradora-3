package model; 
import java.util.Calendar;


public abstract class BibliographicProducts {

	private String name;
	private int currentPage;
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
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Calendar getPublicationDate() {
		return publicationDate;
	}

	/**
	 * 
	 * @param publicationDate
	 */
	public void setPublicationDate(Calendar publicationDate) {
		
	   this.publicationDate = publicationDate;
	}

	

	public double getProductValue() {
		return productValue;
	}

	/**
	 * 
	 * @param productValue
	 */
	public void setProductValue(double productValue) {
		this.productValue = productValue;
	}

	public String getURL() {
		return URL;
	}

	/**
	 * 
	 * @param url
	 */
	public void setURL(String URL) {
		this.URL = URL;
	}

	public int getAccumulatedPagesRead(){
		return accumulatedPagesRead;
	}

	public void setAccumulatedPagesRead(int accumulatedPagesRead){
		this.accumulatedPagesRead = accumulatedPagesRead;
	}

	public int getPagesNumber(){
		return pagesNumber;
	}

	public void setPagesNumber(int pagesNumber){
		this.pagesNumber = pagesNumber;
	}

	

	public abstract String generateRandomId();

	public abstract void updateCopiesSold();

    public abstract void increaseActiveSubscriptions ();



    public abstract void unsubscribeMagazine();

	

}