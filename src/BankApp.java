import java.util.ArrayList;

public class BankApp {
    private String name;
    private Bank bank;
    private BagelShop bagelShop;
    private CreditCard creditCard;
    private CreditCard secondCreditCard;
    private boolean quit;
    private int actionNum;

    public BankApp(String n, Bank userBank, BagelShop shop, CreditCard card) {
        name = n;
        bank = userBank;
        bagelShop = shop;
        creditCard = card;
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
        this.actionNum = choiceNum;
        String results = "";
        if (choiceNum == 1) {
            results = "How many bagels would you like to purchase and provide your card pin.";
        }
        if (choiceNum == 7) {
            results = "Exited the bank app.";
            quit = true;
        }
        return results;
    }

    public String doAction(String userInputs) {
        ArrayList<String> inputs = new ArrayList<>();
        while (userInputs.indexOf(",") != -1) {
            String input = userInputs.substring(0, userInputs.indexOf(","));
            userInputs = userInputs.substring(userInputs.indexOf(",") + 2);
            inputs.add(input);
        }
        inputs.add(userInputs);
        if (actionNum == 1) {
            if (bagelShop.payForBagels(creditCard, Integer.parseInt(inputs.get(0)), inputs.get(1))) {
                return "You have bought " + inputs.get(0) + " bagels!";
            } else {
                return "Incorrect card number";
            }
        } else {
            return "failed";
        }
    }

    public boolean isQuit() {
        return quit;
    }
}
