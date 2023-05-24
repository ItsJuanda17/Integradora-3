package model;
import java.util.Calendar;

public class Bill {

	private Calendar operationDate;
	private double amountPaid;

	/**
	 * 
	 * @param operationDate
	 * @param amountPaid
	 */
	public Bill(Calendar operationDate, double amountPaid) {
		this.operationDate = operationDate;
		this.amountPaid = amountPaid;
	}

	public Calendar getOperationDate() {
		return this.operationDate;
	}

	/**
	 * 
	 * @param operationDate
	 */
	public void setOperationDate(Calendar operationDate) {
		this.operationDate = operationDate;
	}

	public double getAmountPaid() {
		return this.amountPaid;
	}

	/**
	 * 
	 * @param amountPaid
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

}