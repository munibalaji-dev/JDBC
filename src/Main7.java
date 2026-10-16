import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main7 {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String UPDATE_QUERY = "UPDATE student SET photo = ? where id = ?";


    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = con.prepareStatement(UPDATE_QUERY);

            FileInputStream fis = new FileInputStream("images/image3.png");

            preparedStatement.setBinaryStream(1, fis);
            System.out.println("Enter id: ");
            preparedStatement.setInt(2, sc.nextInt());

            preparedStatement.executeUpdate();

            System.out.println("UPDATED");

        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        } catch (SQLException s) {
            s.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
