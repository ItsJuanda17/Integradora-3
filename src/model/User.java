public abstract class User {

	private String name;
	private String cc;
	private Calendar vinculationDate;

	/**
	 * 
	 * @param name
	 * @param cc
	 * @param vinculationDate
	 */
	public User(String name, String cc, date vinculationDate) {
		// TODO - implement User.User
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

	public String getCC() {
		// TODO - implement User.getCC
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cc
	 */
	public void setCC(String cc) {
		// TODO - implement User.setCC
		throw new UnsupportedOperationException();
	}

	public Calendar getVinculationDate() {
		return this.vinculationDate;
	}

	/**
	 * 
	 * @param date
	 */
	public void setVinculationDate(Calendar date) {
		this.vinculationDate = date;
	}

}