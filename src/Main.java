import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("What is your name?");
        String userName = myObj.nextLine();
        System.out.println("What is your pin number?");
        String pin = myObj.nextLine();
        System.out.println("What is the name of your bagel shop?");
        String shopName = myObj.nextLine();
        System.out.println("How many bagels are you starting off with?");
        int inventory = Integer.parseInt(myObj.nextLine());
        System.out.println("How much are your bagels being sold for?");
        int bagelPrice = Integer.parseInt(myObj.nextLine());
        Bank myBank = new Bank();
        BagelShop myBagelShop = new BagelShop(shopName, inventory, bagelPrice, myBank);
        CreditCard myCreditCard = new CreditCard(userName, pin);
        BankApp app = new BankApp(userName, myBank, myBagelShop, myCreditCard);
        int userChoice;
        while (app.isQuit() == false) {
            System.out.println("\n" + app.actionMenu());
            app.actionMenu();
            userChoice = Integer.parseInt(myObj.nextLine());
            System.out.println(app.actionResults(userChoice));
        }
        // call methods from your BankApp object to handle program logic
    }
}

