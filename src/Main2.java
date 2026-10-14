
import java.sql.*;


public class Main2 {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet result;

    private static final String SELECT_QUERY = "SELECT * FROM employee";


    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            stmt = con.createStatement();

            result = stmt.executeQuery(SELECT_QUERY);

            printResultSet(result);

        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        catch (SQLException s){
            s.printStackTrace();
        }
        finally{
            try {
                result.close();
                stmt.close();
                con.close();
            }
            catch (SQLException s){
                s.printStackTrace();
            }
        }
    }
    public static void printResultSet(ResultSet res) throws SQLException{
        while(res.next()){
            int id = res.getInt("ID");
            String name = res.getString("NAME");
            String email = res.getString("EMAIL");
            int salary = res.getInt("SALARY");
            String dept = res.getString("DEPT");


            System.out.printf("%-2d %-10s %-20s %-7d %s \n", id, name, email, salary, dept);
        }
    }
}
