import java.sql.*;
import java.util.Scanner;

public class Main6 {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//            CallableStatement callableStatement = con.prepareCall(("call GETCOUNTOFEMPLOYEE(?, ?)"));
//            callableStatement.setInt(1, 90000);
//            callableStatement.registerOutParameter(2, Types.INTEGER);
//            callableStatement.execute();
//            int result = callableStatement.getInt(2);
//            System.out.println(result);


            CallableStatement callableStatement = con.prepareCall(("call getemployees(?)"));
            callableStatement.setInt(1, 90000);
            callableStatement.execute();
            ResultSet resultSet = callableStatement.getResultSet();
            Main2.printResultSet(resultSet);
        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        catch (SQLException s){
            s.printStackTrace();
        }
    }
}
