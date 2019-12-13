package pkgLogic;

public class Payment {
	
	//TODO: I've accounted for PaymentNbr, you need to add all the other fields for the class
	private double PaymentNbr;
	private String PaymentDate;
	private double BegBal;
	private double SchedPay;
	private double ExPay;
	private double TotalPay;
	private double Prin;
	private double Interest;
	private double EndingBal;
	private double CumIn;
	
	//TODO: Fix the constructor, add the fields you've added.
	public Payment(double paymentNbr, String paymentDate, double begBal, double schedPay, double exPay, double totalPay, double prin, double interest, double endingBal, double cumIn) {
		super();
		PaymentNbr = paymentNbr;
		PaymentDate = paymentDate;
		BegBal = begBal;
		SchedPay = schedPay;
		ExPay = exPay;
		TotalPay = totalPay;
		Prin = prin;
		Interest = interest;
		EndingBal = endingBal;
		CumIn = cumIn;
		
	}

	public double getPaymentNbr() {
		return PaymentNbr;
	}

	public void setPaymentNbr(double paymentNbr) {
		PaymentNbr = paymentNbr;
	}
	
	public String getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}
	
	public double getBegBal() {
		return PaymentNbr;
	}

	public void setBegBal(double begBal) {
		BegBal = begBal;
	}
	
	public double getSchedPay() {
		return SchedPay;
	}

	public void setSchedPay(double schedPay) {
		SchedPay = schedPay;
	}
	
	public double getExPay() {
		return ExPay;
	}

	public void setExPay(double exPay) {
		ExPay = exPay;
	}
	
	public double getTotalPay() {
		return TotalPay;
	}

	public void setTotalPay(double totalPay) {
		TotalPay = totalPay;
	}
	
	public double getPrin() {
		return Prin;
	}

	public void setPrin(double prin) {
		Prin = prin;
	}
	
	public double getInterest() {
		return Interest;
	}

	public void setInterest(double interest) {
		Interest = interest;
	}
	
	public double getEndingBal() {
		return EndingBal;
	}

	public void setEndingBal(double endingBal) {
		EndingBal = endingBal;
	}
	
	public double getCumIn() {
		return CumIn;
	}

	public void setCumIn(double cumIn) {
		CumIn = cumIn;
	}
	//TODO: Add getters and setters for new fields.	
}
