import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import java.sql.SQLOutput;

public class ExpensesTracking {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/KBL_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "saintjohn@2737!";

    public static void main(String[] args) {

            try (Connection conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD) ) {

                String budgetQuery =" SELECT Category, Allocated_amount FROM Budget";
                String expensesQuery = "SELECT  Category, SUM(Amount_spent) FROM Expenses GROUP BY category";

                Statement stmt = conn.createStatement();
                ResultSet budgetResult = stmt. executeQuery(budgetQuery);

                HashMap<String, Double> BudgetMap = new HashMap<>();

                while(budgetResult.next()){
                    BudgetMap.put(budgetResult.getString("Category"), budgetResult.getDouble("Allocated_amount"));

                }

                ResultSet expensesResult = stmt. executeQuery(expensesQuery);
                System.out.println("Comparison of expenses vs budget");
                System.out.println("-----------------------------------");
                System.out.printf("category","Budgeted(ksh)","spent(ksh)","status" );

                while (expensesResult.next()){
                    String category = expensesResult.getString("category");
                    double Spent = expensesResult.getDouble("spent");
                    double Budgeted = BudgetMap.getOrDefault(category,0.0);

                    String status;
                    if (Spent > Budgeted){
                        status = "Over budget";

                    } else if (Spent == Budgeted) {
                        status = "On Budget";
                    } else{
                        status = "Under budget";
                    }

                    System.out.println("%-20s,%-15.2f,%-15.2f,%-10s\n, category, budgeted, spent, status");

                }
            }catch(SQLException e){
                e.printStackTrace();



        }
    }
}