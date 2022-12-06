import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("What is your name?");
        String userName = myObj.nextLine();
        Bank myBank = new Bank();
        BagelShop myBagelShop = new BagelShop(userName, 30, 6, myBank);
        CreditCard myCreditCard = new CreditCard(userName, "1234");
        BankApp app = new BankApp(userName, myBank, myBagelShop, myCreditCard);
        int userChoice;
        while (app.isQuit() == false) {
            System.out.println("\n" + app.actionMenu());
            app.actionMenu();
            userChoice = Integer.parseInt(myObj.nextLine());
            System.out.println(app.actionResults(userChoice));
            if (app.isQuit() == false) {
                System.out.println("Enter the needed inputs. (Format: \"input1, input2, ...\")");
                String inputs = myObj.nextLine();
                System.out.println(app.doAction(inputs));
            }

        }
        // call methods from your BankApp object to handle program logic
    }
}

