package java_tasks;
import java.util.Scanner;
public class Basic_Banking_System 
{
	    public static void main(String[] args)
	    {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter Account Holder Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Initial Balance: ");
	        double balance = sc.nextDouble();

	        BankAccount account = new BankAccount(name, balance);

	        int choice;

	            System.out.println("\n===== Banking Menu =====");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Show Balance");
	            System.out.println("4. Show Transaction History");
	            System.out.println("5. Add Interest");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");

	            choice = sc.nextInt();

	            try {
	                switch (choice) {

	                    case 1:
	                        System.out.print("Enter deposit amount: ");
	                        double depositAmount = sc.nextDouble();
	                        account.deposit(depositAmount);
	                        account.showBalance();
	                        break;

	                    case 2:
	                        System.out.print("Enter withdrawal amount: ");
	                        double withdrawAmount = sc.nextDouble();
	                        account.withdraw(withdrawAmount);
	                        account.showBalance();
	                        break;

	                    case 3:
	                        account.showBalance();
	                        break;

	                    case 4:
	                        account.showTransactionHistory();
	                        break;

	                    case 5:
	                        account.addInterest();
	                        break;

	                    case 6:
	                        System.out.println("Thank you for using Banking System!");
	                        break;

	                    default:
	                        System.out.println("Invalid Choice!");
	                }
	            } 
	            catch (InsufficientBalanceException e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        sc.close();
	    }
}

