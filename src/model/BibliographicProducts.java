public abstract class BibliographicProducts {

	private String name;
	private int pagesNumber;
	private date publicationDate;
	private int accumulatedPagesRead;
	private String id;
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
	public BibliographicProducts(String name, int pagesNumber, date publicationDate, int accumulatedPagesRead, String id, double productValue, String URL) {
		// TODO - implement BibliographicProducts.BibliographicProducts
		throw new UnsupportedOperationException();
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

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
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

}