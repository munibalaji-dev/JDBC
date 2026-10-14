import java.sql.*;
import java.util.Scanner;

public class Main4 {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String INSERT_QUERY = "INSERT INTO employee (id, name, email, salary, dept) values (?, ?, ?, ?, ?)";
    private static  Scanner sc;

    public static void main(String[] args) {

        PreparedStatement preparedStatement;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            printTable(con);

            String choice;

            preparedStatement = con.prepareStatement(INSERT_QUERY);

            do {

                sc = new Scanner(System.in);
                System.out.println("Enter the id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the name: ");
                String name = sc.nextLine();
                System.out.println("Enter the email: ");
                String email = sc.nextLine();
                System.out.println("Enter the salary: ");
                int salary = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the dept: ");
                String dept = sc.nextLine();

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, email);
                preparedStatement.setInt(4, salary);
                preparedStatement.setString(5, dept);

//                int rows = preparedStatement.executeUpdate();
//                System.out.println("Rows " + rows + " affected");

                preparedStatement.addBatch();

                System.out.println("Do you want to add one more employee: ");
                choice = sc.nextLine();
            }
            while (choice.equalsIgnoreCase("Yes"));

            preparedStatement.executeBatch();

            printTable(con);

        }

        catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        catch (SQLException s){
            s.printStackTrace();
        }
    }
    public static void printTable(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("SELECT * FROM EMPLOYEE");
        while(res.next()){
            int id = res.getInt("id");
            String name = res.getString("name");
            String email = res.getString("email");
            int salary = res.getInt("salary");
            String dept = res.getString("dept");

            System.out.printf("%-2d %-10s %-20s %-7d %-10s \n", id, name, email, salary, dept);
        }
    }
}
