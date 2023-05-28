package model;
import java.util.Calendar;
import java.util.ArrayList;

public abstract class User {

	private String name;
	private String cc;
	private Calendar vinculationDate;
	private ArrayList<BibliographicProducts> purchasedProducts;

	/**
	 * 
	 * @param name
	 * @param cc
	 * @param vinculationDate
	 */
	public User(String name, String cc, Calendar vinculationDate) {
		this.name = name;
		this.cc=cc;
		this.vinculationDate=vinculationDate;

		purchasedProducts = new ArrayList<>();
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

	public String getCC() {
		return cc;
	}

	/**
	 * 
	 * @param cc
	 */
	public void setCC(String cc) {
		this.cc= cc;
	}

	public Calendar getVinculationDate() {
		return vinculationDate;
	}

	/**
	 * 
	 * @param date
	 */
	public void setVinculationDate(Calendar date) {
		this.vinculationDate = date;
	}

	public String toString(){
		return name;
	}

	public void addPurchasedProduct(BibliographicProducts product) {
		purchasedProducts.add(product);
	}

	public ArrayList<BibliographicProducts> getPurchasedProducts() {
		return purchasedProducts;
	}

}