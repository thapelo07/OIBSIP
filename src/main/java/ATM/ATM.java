package ATM;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM implements ATM_Interface{

    private User currentUser;
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void transactionsHistory() {
        if (transactions.isEmpty()){
            System.out.println("No transactions have been made yet.");
        }else {
            System.out.println("Transactions History: ");
            for (Transaction transaction : transactions){
                System.out.println(transaction);
            }
        }
    }

    @Override
    public void withdrawCash(double amount) {
       if (amount > 0){
           Transaction transaction = new Transaction("Withdrawal",amount,currentUser);
           transactions.add(transaction);
           System.out.println("Cash withdrawn successfully. Please take your cash.");
       }else {
           System.out.println("Invalid amount. Please enter a positive number.");
       }
    }

    @Override
    public void depositCash(double amount) {

        if (amount > 0){
            Transaction transaction = new Transaction("Withdrawal", amount,currentUser);
            transactions.add(transaction);
            System.out.println("Cash deposited successfully. Please take your cash.");
        }else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    @Override
    public void transferCash(String toAccount, double amount) {
        if (amount > 0){
            Transaction transaction = new Transaction("Transfer", amount,currentUser,toAccount);
            transactions.add(transaction);
            System.out.println("Cash transferred successfully."+ transaction.getToAccount()+". Please take your cash.");
        }else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void setCurrentUser(User user){
        this.currentUser = user;
    }


    @Override
    public void quit() {
        System.out.println("Thank you for using our ATM services. Have a great day!.");
    }

    public void display(){
        int option = 0;
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit){
            System.out.println("\nATM Menu");
            System.out.println("1. Check transaction history");
            System.out.println("2. Deposit cash");
            System.out.println("3. Withdraw cash");
            System.out.println("4. Transfer cash");
            System.out.println("5. Quit");

            System.out.println("Enter your option: ");
            option = scanner.nextInt();

            while (true){
                if (option >= 1 && option <= 4){
                    System.out.println("selected option " + option);
                    break;
                }
                else if (option == 5){
                    quit = true;
                    break;
                }
                else {
                    System.out.println("Invalid option. Please enter a valid option.");
                }
            }

            if (option == 1){
                transactionsHistory();
            } else if (option == 2) {
                System.out.println("Enter the amount to deposit: ");
                double amount = scanner.nextDouble();
                depositCash(amount);
            } else if (option == 3) {
                System.out.println("Enter the amount to withdraw: ");
                double amount = scanner.nextDouble();
                withdrawCash(amount);
            } else if (option == 4) {
                System.out.println("Enter the account number to transfer to: ");
                String toAccount = scanner.next();
                System.out.println("Enter the amount to transfer: ");
                double amount = scanner.nextDouble();
                transferCash(toAccount, amount);
            }
        }
        scanner.close();
    }

    public void login(String userId, String pinCode) {
        while (true) {
            System.out.println("Please enter your user ID:");
            Scanner scanner = new Scanner(System.in);
            String inputId = scanner.nextLine();
            System.out.println("Please enter your Pin Code:");
            String inputPin = scanner.nextLine();

            if (inputId.equals(currentUser.getId()) && inputPin.equals(currentUser.getPin())) {
                System.out.println("You have successfully logged in.");
                display();
                break;
            }else {
                System.out.println("Incorrect ID or Pin. Please try again.");
                System.out.println("Do you want to quit? (yes/no)");
                String quit = scanner.nextLine();
                if (quit.equalsIgnoreCase("yes")){
                    System.out.println("Thank you for using our ATM services.");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        User user = new User("123456", "1111");
        user.setId("102377");
        user.setPin("1431");
        atm.setCurrentUser(user);
        atm.login(user.getId(), user.getPin());


    }
}
