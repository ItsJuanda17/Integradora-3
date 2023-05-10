public class Bill {

	private Calendar operationDate;
	private double amountPaid;

	/**
	 * 
	 * @param operationDate
	 * @param amountPaind
	 */
	public Bill(Calendar operationDate, double amountPaind) {
		// TODO - implement Bill.Bill
		throw new UnsupportedOperationException();
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