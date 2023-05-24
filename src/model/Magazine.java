package model;
import java.util.Random;

import java.util.Calendar;

public class Magazine extends BibliographicProducts {

	private String periodicityOfIssuance;
	private int activeSuscriptions;
	private Category category;
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
	 * @param periodicityOfIssuance
	 * @param activeSuscriptions
	 * @param category
	 */
	public Magazine(String name, int pagesNumber, Calendar publicationDate, int accumulatedPagesRead, double productValue, String URL, String periodicityOfIssuance, int activeSuscriptions, Category category ) {
		super(name , pagesNumber, publicationDate , accumulatedPagesRead,  productValue , URL);
		this.periodicityOfIssuance = periodicityOfIssuance;
		this.activeSuscriptions = activeSuscriptions;
		this.category = category;
		this.id=generateRandomId();

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

	@Override
	public String generateRandomId(){
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

	public Category getCategory() {
        return category;
    }
    
	public void setCategory(Category category){
		this.category = category;
		
	}
    
	@Override
	public void increaseActiveSuscriptions(){
		activeSuscriptions ++;
	}
    
	@Override
	public void unsbscribeMagazine(){
		activeSuscriptions--;
	}

	@Override
	public void updateCopiesSold(){
		
	}



}

