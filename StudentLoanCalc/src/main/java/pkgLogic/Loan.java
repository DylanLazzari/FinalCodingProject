package pkgLogic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Loan {
	private LocalDate startDate;
	private double LoanAmount;
	private double LoanBalanceEnd;
	private double InterestRate;
	private double AdditionalPayment;
	private int LoanPaymentCnt;
	private boolean bCompoundingOption;

	private ArrayList<Payment> loanPayments = new ArrayList<Payment>();

	public Loan(LocalDate startDate, double loanAmount, double interestRate, double additionalPayment,
			int loanPaymentCnt) {
		super();
		this.startDate = startDate;
		LoanAmount = loanAmount;
		InterestRate = interestRate;
		AdditionalPayment = additionalPayment;
		LoanPaymentCnt = loanPaymentCnt;
		bCompoundingOption = false;
		LoanBalanceEnd = 0;

	}

	public Loan(LocalDate startDate, double loanAmount, double loanBalanceEnd, double interestRate,
			double additionalPayment, int loanPaymentCnt, boolean bCompoundingOption) {
		super();
		this.startDate = startDate;
		LoanAmount = loanAmount;
		LoanBalanceEnd = loanBalanceEnd;
		InterestRate = interestRate;
		AdditionalPayment = additionalPayment;
		LoanPaymentCnt = loanPaymentCnt;
		this.bCompoundingOption = bCompoundingOption;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public double getLoanAmount() {
		return LoanAmount;
	}

	public double getLoanBalanceEnd() {
		return LoanBalanceEnd;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public double getAdditionalPayment() {
		return AdditionalPayment;
	}

	public int getLoanPaymentCnt() {
		return LoanPaymentCnt;
	}

	public boolean isbCompoundingOption() {
		return bCompoundingOption;
	}

	
}