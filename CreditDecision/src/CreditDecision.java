import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreditDecision {

        private static final String JDBC_URL ="jdbc:mysql://localhost:3306/KBL_db";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "saintjohn@2737!";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD) ){

            String debtQuery = "SELECT SUM(Debt_Amount) AS TotalDebt FROM Debts";
            String revenueQuery = "SELECT SUM(Revenue) AS TotalIncome FROM KBL_Income";

            Statement stmt = conn.CreateStatement();

            ResultSet debtResult = stmt.executeQuery(debtQuery);
            System.out.println(debtResult);

            ResultSet revenueResult = stmt.executeQuery(revenueQuery);
            System.out.println(revenueResult);

            double totalDebt = debtResult.getDouble("TotalDebt");
            double totalRevenue = revenueResult.getDouble("TotalIncome");
            double halfRevenue = totalRevenue / 2;

            if (totalDebt < halfRevenue) {
                return "Debt_worthy";
                System.out.println("You have a good capacity for debt");
                System.out.println("You can take on more debt ");
                System.out.println("Your debt to income ratio is 1:2 ");

            } else if (totalDebt > halfRevenue && totalDebt < totalRevenue) {
                return "Debt_unworthy";
                System.out.println("You have a limited capacity for debt");
                System.out.println("You can take on more debt but cautiously; or as a last resort ");
                System.out.println("Your debt to income ratio is 1:1.5 ");

            } else if (totalDebt > totalRevenue) {
                return "Debt_Unworthy";
                System.out.println("You have no capacity for debt");
                System.out.println("You can take up any more debt");
                System.out.println("Your debt to income ratio is 2:1 ");

            } else{
                    return "Debt_Unworthy";
                    System.out.println("You have no capacity for debt");
                    System.out.println("You total debt is equal to your total revenue");
                    
        
        }
    }
}
