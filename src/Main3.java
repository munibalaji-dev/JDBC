import java.sql.*;
import java.util.Scanner;

public class Main3 {


    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final Scanner sc = new Scanner(System.in);


    private static final String SELECT_QUERY = "SELECT * FROM EMPLOYEE";
    private static final String UPDATE_QUERY = "UPDATE EMPLOYEE SET SALARY = SALARY+5000 WHERE DEPT = ?";
    private static final String SELECT_QUERY1 = "SELECT * FROM EMPLOYEE WHERE DEPT = ?";
    private static final String INSERT_QUERY = "INSERT INTO EMPLOYEE (id, name, email, salary, dept) values(?, ?, ?, ?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE ID = ?";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//            Statement stmt = con.createStatement();
//            ResultSet res = stmt.executeQuery(SELECT_QUERY);
//            Main2.printResultSet(res);
//
//            PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);
//            System.out.println("Enter the dept: ");
//            String dept = sc.next();
//            pstmt.setString(1, dept);
//
//            int rowsAffected = pstmt.executeUpdate();
//            System.out.println("Rows Affected: "+rowsAffected);
//
//
//            Statement stmt1 = con.createStatement();
//            ResultSet res1 = stmt.executeQuery(SELECT_QUERY);
//            Main2.printResultSet(res1);

//            PreparedStatement stmt1 = con.prepareStatement(SELECT_QUERY1);
//            System.out.println("Enter the dept: ");
//            String dept1 = sc.next();
//            stmt1.setString(1, dept1);
//            ResultSet res1 = stmt1.executeQuery();
//            Main2.printResultSet(res1);


//            PreparedStatement prepareStatement = con.prepareStatement(INSERT_QUERY);
//            System.out.println("Enter id: ");
//            int id = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Enter Name: ");
//            String name = sc.nextLine();
//            System.out.println("Enter Email: ");
//            String email = sc.nextLine();
//            System.out.println("Enter Salary: ");
//            int salary = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Enter Dept: ");
//            String dept = sc.nextLine();
//
//
//
//            prepareStatement.setInt(1, id);
//            prepareStatement.setString(2, name);
//            prepareStatement.setString(3, email);
//            prepareStatement.setInt(4, salary);
//            prepareStatement.setString(5, dept);
//
//            int rows = prepareStatement.executeUpdate();
//            System.out.println("Rows Affected: "+rows);



//            Statement statement = con.createStatement();
//            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
//            Main2.printResultSet(resultSet);


            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(SELECT_QUERY);
            Main2.printResultSet(res);


            PreparedStatement prepareStatement = con.prepareStatement(DELETE_QUERY);
            System.out.println("Enter id to delete: ");
            int id = sc.nextInt();
            prepareStatement.setInt(1, id);
            int rows = prepareStatement.executeUpdate();
            System.out.println("Rows Affected: "+rows);


            Statement conStatement = con.createStatement();
            ResultSet set = conStatement.executeQuery(SELECT_QUERY);
            Main2.printResultSet(set);

        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
