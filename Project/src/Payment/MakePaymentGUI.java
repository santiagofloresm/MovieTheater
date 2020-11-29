package Payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakePaymentGUI {

    private BufferedReader reader;
    private MakePayment makePayment;

    public MakePaymentGUI(MakePayment makePayment) {
        setMakePayment(makePayment);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean makePayment(double amount) {
        int option = 0;
        System.out.println("Select 1 to pay with credit card, 2 to pay with a voucher or 3 to pay with store credit");
        try {
            option = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (option == 1) {
            return payWithCreditCard(amount);
        }
        else if (option == 2) {
            return payWithVoucher(amount);
        }
        else if (option == 3) {
            return payWithStoreCredit(amount);
        }
        else
            System.out.println("ERROR");
    return false;
    }

    private boolean payWithCreditCard(double amount) {
        String cc = "";
        int cvv = 0;
        try {
            System.out.println("Enter your credit card number");
            cc = reader.readLine();
            System.out.println("Enter the CVV number of your card");
            cvv = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return makePayment.payWithCreditCard(cc, cvv, amount);
    }

    private boolean payWithVoucher(double amount) {
        int vouchNum = 0;
        try {
            System.out.println("Enter your voucher number");
            vouchNum = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        double remainder = makePayment.payWithVoucher(vouchNum, amount);
        if (remainder == 0)
            return true;
        else if (remainder == -1)
            return false;
        else
            return payWithCreditCard(remainder);
    }

    private boolean payWithStoreCredit(double amount) {
        int creditNum = 0;
        try {
            System.out.println("Enter your store credit number");
            creditNum = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO finish this with the gui
        return true;
    }

    public void setMakePayment(MakePayment makePayment) {
        this.makePayment = makePayment;
    }
}
