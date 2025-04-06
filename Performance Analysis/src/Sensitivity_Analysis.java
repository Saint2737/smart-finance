
import java.util.Scanner;

public class Sensitivity_Analysis{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double revenue, cogs, fixedCosts, variableCosts, TaxRate;
        System.out.print("Enter the base case values of this business: ");

        System.out.println("\nEnter the revenue: ");
        revenue = sc.nextDouble();

        System.out.println("Enter the cogs(Cost of goods sold - costs of producing or selling the goods eg raw materials):");
        cogs = sc.nextDouble();
        System.out.println("Enter the fixed costs eg rent,insurance,salaries");
        fixedCosts = sc.nextDouble();

        System.out.println("Enter the variable costs(costs that change depending on production eg shipping fees):");
        variableCosts = sc.nextDouble();

        System.out.println("Enter the Tax Rate( as a percentage, eg ., 20 f0r 20%): ");
        TaxRate = sc.nextDouble();

        double baseProfit = calculateProfit(revenue,cogs,fixedCosts,variableCosts,TaxRate);
        System.out.println("The profit is: " + baseProfit);

        System.out.println("\n Conducting Sensitivity Analysis:");

        System.out.println(" \n Enter percentage change in revenue( eg., 10 for 10% increase):");
        double revenueChange = sc.nextDouble();
        double newRevenue = revenue * (1 + revenueChange/100);
        double newProfit = calculateProfit(newRevenue,cogs,fixedCosts,variableCosts,TaxRate);
        System.out.println("The new profit with" + revenueChange + "% change in revenue:" + newProfit);


        System.out.println(" \n Enter percentage change in cogs(eg., -10 f0r 10 % decrease):");
        double cogsChange = sc.nextDouble();
        double newCogs = cogs * (1 + cogsChange/100);
        double newProfit2= calculateProfit(newCogs,fixedCosts,variableCosts,revenue,TaxRate);
        System.out.println("The new profit with" + cogsChange + "% change in cogs:" + newProfit2);

        System.out.println("\n Enter percentage change in fixed costs: ");
        double fixedCostsChange = sc.nextDouble();
        double newFixedCosts = fixedCosts * (1 + fixedCostsChange/100);
        double newProfit3 = calculateProfit(newFixedCosts, cogs,variableCosts,revenue,TaxRate);
        System.out.println("The new profit with" + fixedCostsChange + "% change in fixed costs:" + newProfit3);

        System.out.println("\n Enter percentage change in variable costs: ");
        double variableCostsChange = sc.nextDouble();
        double newVariableCosts = variableCosts * (1 + variableCostsChange/100);
        double newProfit4 = calculateProfit(newVariableCosts,cogs,revenue,fixedCosts,TaxRate);
        System.out.println("The new profit with" + variableCostsChange + "% change in variable costs:" + newProfit4);

        System.out.println("\n Enter percentage change in Tax rate: ");
        double TaxRateChange = sc.nextDouble();
        double newTaxRate = TaxRate * (1 + TaxRateChange/100);
        double newProfit5 = calculateProfit(newTaxRate,cogs,revenue,fixedCosts,variableCosts);
        System.out.println("The new profit with" + TaxRateChange + "% change in Tax rate:" + newTaxRate);

        sc.close();
    }
        public static double calculateProfit(double revenue,double cogs, double fixedCosts, double variableCosts, double
        TaxRate){
        double profitBeforeTax = revenue - cogs - fixedCosts - variableCosts;
        double tax = profitBeforeTax * (TaxRate/100);
        double FinalProfit = profitBeforeTax - tax;
        return FinalProfit;
    }
}