public class Magazine extends BibliographicProducts {

	private String periodicityOfIssuance;
	private int activeSuscriptions;

	/**
	 * 
	 * @param name
	 * @param pagesNumber
	 * @param publicationDate
	 * @param accumulatedPagesRead
	 * @param id
	 * @param productValue
	 * @param URL
	 * @param periodicityOfIssuance
	 * @param activeSuscriptions
	 * @param category
	 */
	public void operation(String name, int pagesNumber, date publicationDate, int accumulatedPagesRead, String id, double productValue, String URL, String periodicityOfIssuance, int activeSuscriptions, Category category) {
		// TODO - implement Magazine.operation
		throw new UnsupportedOperationException();
	}

	public String getPeriodicityOfIssuance() {
		return this.periodicityOfIssuance;
	}

	/**
	 * 
	 * @param periodicityOfIssuance
	 */
	public void setPeriodicityOfIssuance(String periodicityOfIssuance) {
		this.periodicityOfIssuance = periodicityOfIssuance;
	}

	public int getActiveSuscriptions() {
		return this.activeSuscriptions;
	}

	/**
	 * 
	 * @param activeSuscriptions
	 */
	public void setActiveSuscriptions(int activeSuscriptions) {
		this.activeSuscriptions = activeSuscriptions;
	}

}