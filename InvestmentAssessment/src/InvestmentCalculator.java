import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class InvestmentCalculator {
    public double ReturnOnInvestment(double currentValue,double InitialValue){

        double ROI = (currentValue - InitialValue)/InitialValue * 100;
        System.out.println("ROI is: "+ ROI + "%");
        return ROI;
    }
    public double PaybackPeriod(double InitialInvestment,double AnnualIncome){

        double PBP = InitialInvestment/AnnualIncome;
        System.out.println("PBP is: " + PBP + "Year(s)");
        return PBP;
    }
    public double AccountingRateReturn(double annualProfit,double averageInvestmentValue){
        double ARR = (annualProfit - averageInvestment)* 100;
        System.out.println("ARR is: " + ARR + "%");
        return ARR;

    }

  public static void main(String[] args) {

          Scanner myobj = new Scanner(System.in);
          System.out.println("--------------------------------------");
          System.out.println("Enter the following information to help determine the return on your investment:");
          System.out.println("Enter the initial value of investment");
          double InitialValue =myobj.nextDouble();

          System.out.println("Enter the current value of investment(initial value + any salvage value)");
          double currentValue =myobj.nextDouble();

          System.out.println("--------------------------------------");
          System.out.println("Enter the following information to help determine the payback period:");
          System.out.println("Enter InitialInvestment");
          double InitialInvestment = myobj.nextDouble();


          System.out.println("Enter the annual income");
          double AnnualIncome = myobj.nextDouble();
          System.out.println("--------------------------------------");
          System.out.println("\nEnter the following information to help determine the rate of return on your investment:");

          System.out.println("Enter the expected payback period(years)");
          double expectedPayback = myobj.nextDouble();

          System.out.println("Enter your annual profit ");
          double annualProfit = myobj.nextDouble();

          System.out.println("--------------------------------------");
          System.out.println("\nEnter the following information to help determine the rate of return on your investment:");
          System.out.println("Enter the average value of your investment(initial value + any salvage value added to the investment)");
          double averageInvestmentValue = myobj.nextDouble();

          System.out.println("Enter the minimum required rate of return(20 if 20%, 10 if 10%)");
          double minRequiredRate = myobj.nextDouble();

          InvestmentCalculator obj = new InvestmentCalculator();
          double ARRresult,PBPresult,ROIresult;

          ARRresult = obj.AccountingRateReturn( annualProfit,averageInvestment);
          PBPresult = obj.PaybackPeriod( InitialInvestment,AnnualIncome);
          ROIresult = obj.ReturnOnInvestment( currentValue,InitialValue);

      if (ARRresult < minRequiredRate){
            System.out.println( "\nThe rate of return of this investment is lower than the expected rate of return");
            System.out.println(" This investment is not viable to you.");
            System.out.println(" Consider pursuing another investment or check the other metrics of this investment to determine whether you are going to pursue it.");
        }
        else if (ARRresult == minRequiredRate){
            System.out.println("\nThe rate of return of this investment matches your expected rate of return");
            System.out.println("  This investment is viable to you");
            System.out.println("  Consider pursuing this investment.");
        }
        else {
            System.out.println("\nThe rate of return of this investment exceeds your expected rate of return");
            System.out.println(" This investment is highly recommended");
            System.out.println(" Consider pursuing this investment.");
        }

        if (PBPresult < expectedPayback){
            System.out.println("\nThe payback period of this investment is lower than the expected payback period");
            System.out.println("   This investment is not viable to you. ");
            System.out.println("   Consider pursuing another investment or check the other metrics of this investment to determine whether you are going to pursue it.");
        }
        else if (PBPresult == expectedPayback){
            System.out.println("\nThe payback period of this investment matches your expected payback period");
            System.out.println("  This investment is viable to you.");
            System.out.println("  Consider pursuing this investment.");
        }
        else{
            System.out.println("\nThe payback period of this investment exceeds your expected payback period");
            System.out.println("  This investment is highly recommended ");
            System.out.println("  Consider pursuing this investment.");
        }

      if (ROIresult >0.05 && ROIresult <=0.10){
          System.out.println("\n The return on investment on this investment is good and is an average return ");
          System.out.println("This investment is good for you if you the investment is new");
          System.out.println(" Consider pursuing this investment, but in the future see if you can optimise operations and costs to get a higher return ");

      }
      else if( ROIresult > 0.10){
          System.out.println("\n The return on investment on this investment is favourable");
          System.out.println(" This investment is highly viable");
          System.out.println("Consider pursuing this investment.");

      }
      else{
          System.out.println("\n The return on investment on this investment is not favourable");
          System.out.println(" This investment is not viable");
          System.out.println("Consider pursuing another investment or review your investment operations to find ways to optimise and maximize your return");
      }



      myobj.close();

    }

}
