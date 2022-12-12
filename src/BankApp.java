import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
    private String name;
    private Bank bank;
    private BagelShop bagelShop;
    private CreditCard creditCard;
    private CreditCard secondCreditCard;
    private CreditCard mainCreditCard;
    private boolean quit;
    private int actionNum;

    public BankApp(String n, Bank userBank, BagelShop shop, CreditCard card) {
        name = n;
        bank = userBank;
        bagelShop = shop;
        creditCard = card;
        mainCreditCard = card;
        quit = false;
        secondCreditCard = null;
        actionNum = 0;
    }

    public String actionMenu() {
        return "Welcome to your bank app. What would you like to do?\n" +
                "1. Buy some bagels\n" +
                "2. Return some bagels\n" +
                "3. Open a second credit card\n" +
                "4. Compare the balances in your credit cards\n" +
                "5. Deposit profits into the bank\n" +
                "6. Check bagel shop inventory\n" +
                "7. Quit";
    }

    public String actionResults(int choiceNum) {
        Scanner myObj = new Scanner(System.in);
        String results = "";
        if (choiceNum == 1) {
            System.out.println("How many bagels do you want to buy?");
            int amnt = Integer.parseInt(myObj.nextLine());
            System.out.println("Please provide your personal pin.");
            String pin = myObj.nextLine();
            if (bagelShop.payForBagels(mainCreditCard, amnt, pin)) {
                results = "Bought " + amnt + " bagels.";
            } else {
                results = "Failed. Incorrect Pin.";
            }
        }
        if (choiceNum == 2) {
            System.out.println("How many bagels do you want to return?");
            int amnt = Integer.parseInt(myObj.nextLine());
            System.out.println("Please provide your personal pin.");
            String pin = myObj.nextLine();
            if (bagelShop.returnBagels(mainCreditCard, amnt, pin)) {
                results = "Returned " + amnt + " bagels.";
            } else {
                results = "Failed. Incorrect Pin.";
            }
        }
        if (choiceNum == 3) {
            if (secondCreditCard == null) {
                System.out.println("Adding a new credit card. Please provide it's personal pin.");
                String pin = myObj.nextLine();
                secondCreditCard = new CreditCard(name, pin);
            } else {
                System.out.println("Which credit card would you like to use as your main? (Please type \"1\" or \"2\"");
                if (myObj.nextLine() == "1") {
                    mainCreditCard = creditCard;
                    results = "First credit card was set as main";
                }  else if (myObj.nextLine() == "2") {
                    mainCreditCard = secondCreditCard;
                    results = "Second credit card was set as main";
                } else {
                    results = "Not a valid answer";
                }
            }
        }
        if (choiceNum == 4) {
            if (secondCreditCard == null) {
                results = "Don't have a second credit card. Please add one if you wish to compare";
            } else if (creditCard.getBalanceOwed() > secondCreditCard.getBalanceOwed()) {
                results = "Credit card 1 has a higher balance than credit card 2";
            } else if (creditCard.getBalanceOwed() < secondCreditCard.getBalanceOwed()) {
                results = "Credit card 2 has a higher balance than credit card 1";
            } else {
                results = "Both have the same balance";
            }
        }
        if (choiceNum == 5) {
            System.out.println("How much money do you want to deposit into the bank?");
            int amnt = Integer.parseInt(myObj.nextLine());
            bank.vendorDeposit(amnt);
            results = "Deposited $" + amnt + " into the bank";
        }
        if (choiceNum == 6) {
            results = bagelShop.toString();
        }
        if (choiceNum == 7) {
            results = "Exited the bank app.";
            quit = true;
        }
        return results;
    }



    public boolean isQuit() {
        return quit;
    }
}
