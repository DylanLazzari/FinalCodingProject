package app.controller;

import app.StudentCalc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pkgLogic.Payment;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

import java.lang.Math;


public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField ExPay;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private Label lblTotalPayemnts;

	
	@FXML
	private TableView<Payment> tvResults;
	
	@FXML
	private TableColumn<Payment, Integer> colPaymentNumber;
	
	@FXML
	private TableColumn<Payment, Integer> colPaymentDate;
	
	@FXML
	private TableColumn<Payment, Integer> colBeginningBalance;
	
	@FXML
	private TableColumn<Payment, Integer> colSchedPay;
	
	@FXML
	private TableColumn<Payment, Integer> colExtraPay;
	
	@FXML
	private TableColumn<Payment, Integer> colTotPay;
	
	@FXML
	private TableColumn<Payment, Integer> colPr;
	
	@FXML
	private TableColumn<Payment, Integer> colInt;
	
	@FXML
	private TableColumn<Payment, Integer> colEndingBal;
	
	@FXML
	private TableColumn<Payment, Integer> colCumInt;
	
	private ObservableList<Payment> paymentList = FXCollections.observableArrayList();
	
	//TODO: Account for all the other columns		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colPaymentNumber.setCellValueFactory(new PropertyValueFactory<>("paymentNbr"));
		colPaymentDate.setCellValueFactory(new PropertyValueFactory<>("payment date"));
		colBeginningBalance.setCellValueFactory(new PropertyValueFactory<>("Beginning Balance"));
		colSchedPay.setCellValueFactory(new PropertyValueFactory<>("Scheduled Payment"));
		colExtraPay.setCellValueFactory(new PropertyValueFactory<>("Extra Payment"));
		colTotPay.setCellValueFactory(new PropertyValueFactory<>("Total Payment"));
		colPr.setCellValueFactory(new PropertyValueFactory<>("Principle"));
		colInt.setCellValueFactory(new PropertyValueFactory<>("Interest"));
		colEndingBal.setCellValueFactory(new PropertyValueFactory<>("Ending Balance"));
		colCumInt.setCellValueFactory(new PropertyValueFactory<>("Cumulative Interest"));
		//TODO: Add a 'setCellValueFactor' entry for each column, mapping to each attribute in Payment
		
		tvResults.setItems(paymentList);
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		//	Examples- how to read data from the form
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());		
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		double dExPay = Double.parseDouble(ExPay.getText());
		String sNbrOfYears = NbrOfYears.getText();
		
		
		lblTotalPayemnts.setText("123");		
		LocalDate localDate = PaymentStartDate.getValue();
		
		String date = PaymentStartDate.getValue().format(DateTimeFormatter.ofPattern("MM-dd-YYYY"));
		
		
		double Npay = Double.parseDouble(lblTotalPayemnts.getText());
		
		double minPay = ((dLoanAmount * dInterestRate/12.0) / (1.0-Math.pow(1.0+dInterestRate/12.0,-1.0*Npay))); 
		double CumIn =0;
		
		for(double i=1; i<Npay; i++) {
			CumIn += (dLoanAmount* dInterestRate/12);
			double newBal = dLoanAmount + (dLoanAmount* dInterestRate/12) - minPay - dExPay;
			Payment p1 = new Payment(i, date, dLoanAmount, minPay, dExPay, minPay + dExPay, minPay +dExPay - (dLoanAmount * dInterestRate/12), dLoanAmount * dInterestRate/12, newBal, CumIn);
			String[] x = date.split("-");
			
			if(x[0].equals("12")) {
				x[0] ="1";
				int newYear = Integer.parseInt(x[2]);
				newYear++;
				x[2]= Integer.toString(newYear);
			}
			else {
				int newMonth = Integer.parseInt(x[0]);
				newMonth++;
				x[0]= Integer.toString(newMonth);
			}
			
			date = x[0]+x[1]+x[2];
			dLoanAmount = newBal;
			
			paymentList.add(p1);
		}
		
		tvResults.getItems().clear();
		
		LoanAmount.setText("");
		
		InterestRate.setText("");
	
		NbrOfYears.setText("");
		
		
		/*
		 * When this button is clicked, you need to do the following:
		 * 
		 * 1) Clear the table
		 * 2) Clear the results fields (Total Payments, Total Interest)
		 * 3) You're going to create 'n' payments based on the data you give.  You'll calculate and
		 * 		carry forward 'balance', because you're going to have to hand calculate that month's
		 * 		interest.
		 * Payment# - you'll set this, counting from 1 to N
		 * Due Date - based on the given date.  method .plusMonths(1) will calculate date + 1 month.
		 * Payment  - Calculate based on PMT function (which is your minimum payment)
		 * Additional Payment - based on Additional Payment given by user
		 * Interest - Calculate based on 
		 */
		
	}
	
}
