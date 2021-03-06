package Registration;

import Payment.MakePayment;
import Payment.MakePaymentGUI;

public class ManageAnnualFee {

    private MakePaymentGUI makePaymentGUI;
    private ManageAnnualFeeGUI manageAnnualFeeGUI;
    private MakePayment makePayment;
    private UserSystem userSystem;
    private ManageRegistration manageRegistration;

    public ManageAnnualFee(MakePaymentGUI makePaymentGUI) {
        setMakePaymentGUI(makePaymentGUI);
    }

//    public boolean payAnnualFee() {
//        System.out.println("HERE");
//        makePaymentGUI.showMakePaymentGUI();
//        makePayment.setAmount(20);
//        return makePaymentGUI.payWithCreditCard();
//    }

    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) {
        this.makePaymentGUI = makePaymentGUI;
    }
    
    public void setManageAnnualFeeGUI(ManageAnnualFeeGUI manageAnnualFeeGUI) {
    	this.manageAnnualFeeGUI = manageAnnualFeeGUI;
    }
    
    public void setMakePayment(MakePayment makePayment) {
    	this.makePayment = makePayment;
    }
    
    public void setUserSystem(UserSystem userSystem) {
    	this.userSystem = userSystem;
    }
    
    public void setManageRegistration (ManageRegistration manageRegistration) {
    	this.manageRegistration = manageRegistration;
    }
    
    public UserSystem getUserSystem() {
    	return userSystem;
    }

	public MakePaymentGUI getMakePaymentGUI() {
		return makePaymentGUI;
	}
}
