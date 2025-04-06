
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;

public class DebtManagement {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/KBL DB";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "saintjohn@2737! ";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD) ){

            String avalancheQuery = "SELECT Debt_Amount, Debt_InterestRate FROM Debts ORDER BY Debt_InterestRate DESC";
            String snowballQuery = "SELECT Debt_Amount FROM debt ORDER BY Debt_Amount ASCE";
            String expiryQuery = "SELECT Debt_Amount FROM Debts ORDER BY Debt_ExpiryDate ASCE";

            Statement stmt = conn.createStatement();

            ResultSet AvalancheResults = stmt.executeQuery(avalancheQuery);

            while (AvalancheResults.next()) {
                System.out.println("Debt Amount: " + AvalancheResults.getDouble("Debt_Amount") +
                        ", Interest Rate: " + AvalancheResults.getDouble("Debt_InterestRate"));
            }
            System.out.println("Debt Avalanche strategy prioritizes debts with highest interest rate first.");
            System.out.println("Debt Avalanche helps you sort out high value debts first to save money.");

            ResultSet SnowballResult = stmt. executeQuery(snowballQuery);

            While (SnowballResult.next()){
                System.out.println( "Debt Amount:" + SnowballResults.getDouble("Debt_Amount") + "Interest Rate:"
                + SnowballResults.getDouble("Debt"));
            }
            System.out.println(SnowballResult);
            System.out.println("Snowball strategy advocates for settling smallest debts first in that order");
            System.out.println(" This habit then encourages & motivates the debtor to continue paying his debts");

            ResultSet ExpiryResult = stmt.executeQuery(expiryQuery);

            System.out.println(ExpiryResult);
            System.out.println("Expiry strategy advocates for settling debts with earlier expiry date first in that order");
            System.out.println( "This strategy ensures that you do not fall short on due dates of debts and end up suffering " +
                    "late payment penalties");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}