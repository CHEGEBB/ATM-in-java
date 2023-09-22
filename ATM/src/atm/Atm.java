package atm;
import java.util.Scanner;

public class Atm {

    public static void main(String[] args) {
        int pin = 3456;
        double balance = 10000.0; 
        double Amount; 
        double deposit; 
        int maxAttempts = 3;
        int attempts = 0;

        System.out.println("****Welcome to Elitebank, your Trusted partner in keeping your money safe****");
        System.out.println("**Please insert your ATM card to continue**");

        Scanner input = new Scanner(System.in);

        while (attempts < maxAttempts) {
            System.out.print("**Please enter your PIN:");
            int x = input.nextInt();

            if (x == pin) {
                System.out.println("**How can we serve you today? Select from the options below**");
                break;
            } else {
                System.out.println("**You have entered the wrong PIN!!!! Try again**");
                attempts++;

                if (attempts == maxAttempts) {
                    System.out.println("Card suspended. Please contact your bank.");
                    input.close();
                    System.exit(0);
                }
            }
        }

        if (attempts < maxAttempts) {
            while (true) {
                System.out.println("**How can we serve you today? Select from the options below:");
                System.out.println("1. Balance Inquiry");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Exit");

                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your balance is: $" + balance);
                        break;
                    case 2:
                        System.out.print("Enter the amount to withdraw: $");
                        Amount = input.nextDouble();

                        if (Amount <= balance) {
                            balance -= Amount;
                            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
                        } else {
                            System.out.println("Insufficient funds. Your balance is: $" + balance);
                        }
                        break;
                    case 3:
                        System.out.print("Enter the amount to deposit: $");
                        deposit = input.nextDouble();
                        balance += deposit;
                        System.out.println("Deposit successful. Your new balance is: $" + balance);
                        break;
                    case 4:
                        System.out.println("Thank you for using Elitebank ATM. Goodbye!");
                        input.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }
    }
}
