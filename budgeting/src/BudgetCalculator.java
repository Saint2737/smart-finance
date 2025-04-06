
import java.util.Scanner;

public class BudgetCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double OEX_percent = 50.0;
        final double Savings_percent = 20.0;
        final double Growth_percent = 30.0;

        System.out.println("Enter amount you want to budget: ");
        double totalAmount = scanner.nextDouble();

        double OperatingExpenses = (OEX_percent / 100) * totalAmount;
        double Savings = (Savings_percent / 100) * totalAmount;
        double Growth = (Growth_percent / 100) * totalAmount;

        System.out.println("\n_________Budget Breakdown________");
        System.out.println("\n This breakdown balances the amount of capital between the operating expenditure and " +
                "the capital expenditure ( savings,growth & expansion); this helps to maintain business operation and ensure optimal " +
                "performance.");

        System.out.println( "\n OperatingExpenses: " +OperatingExpenses + "ksh" + " " +"_" +
                "_"+ OEX_percent + "%");
        System.out.println("Savings: " +Savings + "ksh"+ " " + "_" + "_" + Savings_percent + "%");
        System.out.println("Growth and Expansion: " + Growth + "ksh" + " " + "_" + "_" + Growth_percent + "%");

        scanner.close();

    }
}



