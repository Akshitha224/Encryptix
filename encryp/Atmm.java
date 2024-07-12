import java.util.Scanner;
public class Atmm {
    private static double balance = 1000.0;
    private static String accNum = "123456789";
    private static String pin = "1020";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account Number:");
        String inputAccNum = sc.nextLine();

        System.out.println("Enter Your pin:");
        String inputPin = sc.nextLine();
        if (authenticate(inputAccNum, inputPin)) {
            System.out.println("Authentication Successful.");
            while (true) {
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.println("Enter Your Choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again...");
                }
            }
        } else {
            System.out.println("Authentication failed. Try again...");
        }
    }

    private static boolean authenticate(String inputAccNum, String inputPin) {
        return accNum.equals(inputAccNum) && pin.equals(inputPin);
    }

    private static void checkBalance() {
        System.out.println("Your Balance is $" + balance);
    }

    private static void deposit() {
        Scanner sca = new Scanner(System.in);
        System.out.println("Enter the deposit amount: ");
        double amount = sca.nextDouble();
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit successful! Your new balance is $" + balance);
        } else {
            System.out.println("Invalid amount. Deposit Failed");
        }
    }

    private static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the withdraw amount: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is $" + balance);
        } else {
            System.out.println("Insufficient amount.");
        }
        sc.close();
    }

}
