import java.sql.*;
import java.util.Scanner;

public class Main5 {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final Scanner scanner = new Scanner(System.in);

    private static final String UPDATE_QUERY_S = "UPDATE employee SET salary = salary - ? where name = ?";
    private static final String UPDATE_QUERY_R = "UPDATE employee SET salary = salary + ? where name = ?";

    private static Connection connection;

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

//            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            Statement statement = con.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("SELECT * from employee");
//
//            Main2.printResultSet(resultSet);
//
//            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM employee where id = ?");
//
//            System.out.println("Enter employee id to delete: ");
//            int id = scanner.nextInt();
//            preparedStatement.setInt(1, id);
//
//            int rows = preparedStatement.executeUpdate();
//            System.out.println(rows+" deleted");
//
//
//            Statement conStatement = con.createStatement();
//            ResultSet resultSet1 = conStatement.executeQuery("SELECT * FROM EMPLOYEE");
//            Main2.printResultSet(resultSet1);


            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            Main4.printTable(connection);
            transaction();
            Main4.printTable(connection);




        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException s){
            s.printStackTrace();
        }
    }
    public static void transaction() throws SQLException{
        System.out.println("Enter the name of sender: ");
        String sender = scanner.nextLine();
        System.out.println("Enter the amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the receiver name: ");
        String receiver = scanner.nextLine();


       int rowsSender = updateSender(sender, amount);
        int rowsReceiver = updateReceiver(receiver, amount);

        verify(rowsSender, rowsReceiver);
    }
    public static int updateSender(String sender, int amount) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY_S);

        preparedStatement.setInt(1, amount);
        preparedStatement.setString(2, sender);


        int rows = preparedStatement.executeUpdate();
//        System.out.println(rows);
        return rows;
    }
    public static int updateReceiver(String receiver, int amount) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY_R);

        preparedStatement.setInt(1, amount);
        preparedStatement.setString(2, receiver);

        int rows = preparedStatement.executeUpdate();
//        System.out.println(rows);
        return rows;
    }
    public static void verify(int rowsSender, int rowsReceiver) throws SQLException{


        if(rowsSender == 1 && rowsReceiver == 1){
            connection.commit();
        }
        else{
            connection.rollback();
        }

    }
}
