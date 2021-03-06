package Payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import Reservation.Voucher;
import Registration.ManageAnnualFee;
import Emailer.EmailForm;

public class MakePayment {

    private PaymentSystem paymentSystem;
    private MakePaymentGUI makePaymentGUI;
    private MakeTicketPaymentGUI makeTicketPaymentGUI;
    private ManageAnnualFee manageAnnualFee;
	private String description;

    public MakePayment(MakePaymentGUI makePaymentGUI, PaymentSystem paymentSystem) {
    	setDescription("");
    	setMakePaymentGUI(makePaymentGUI);
        setPaymentSystem(paymentSystem);
        makePaymentGUI.addButtonActionListener(makePaymentGUI.getSubmitPaymentButton(), new SubmitPaymentButtonListener());
    }

    public boolean payWithCreditCard(String cc, String cvv, double amount) {
        TransactionForm tf = new TransactionForm(cc, cvv, amount);
    	boolean result = tf.submit();
//    	System.out.println(tf); //print summary of the payment
    	//send receipt as email when payment is processed
    	if (result) {
    		paymentSystem.generateReceipt(getDescription(), amount);
    		EmailForm email = new EmailForm();
    		email.setSubject("Your Receipt - SLAB CINEMAS");
    		email.setBody(paymentSystem.getLastReceipt().toString());
    		//email.setTo(to); //will send to self
    		email.submit();
    	}
    	// Record payment regardless of fail/success (since it has a field to store that info)
    	paymentSystem.recordPayment(amount, result);
    	return result;
    }

    class SubmitPaymentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            pay();
        }
    }

    private void pay() {
        String cc = makePaymentGUI.getCardNumberField().getText();
        String cvv = makePaymentGUI.getSecurityCodeField().getText();
        boolean payment = payWithCreditCard(cc, cvv, makePaymentGUI.getAmount());
        if (payment) {
            makePaymentGUI.displayMessage("Payment successful");
            // manageAnnualFee.getUserSystem().getManageLogin().getUser().setDateOfLastPayment(LocalDateTime.now());  
            // manageAnnualFee.getMakePaymentGUI().setEnabled(false);
        }
        else {
            makePaymentGUI.displayMessage("Payment unsuccessful");
        }
    }
    
	public void setMakeTicketPaymentGUI(MakeTicketPaymentGUI makeTicketPaymentGUI) {
		this.makeTicketPaymentGUI = makeTicketPaymentGUI;
	}

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }
    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) { this.makePaymentGUI = makePaymentGUI; }
    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return this.description; }
}
