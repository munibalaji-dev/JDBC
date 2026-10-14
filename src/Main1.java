import java.sql.*;

public class Main1 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);


            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("select * from employee");

//            String sql = "update employee set salary = 99000 where id = 2";

//            int rows = stmt.executeUpdate(sql);
//            System.out.println(rows+" rows updated");


            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                int salary =  result.getInt("salary");
                String dept = result.getString("dept");


//                System.out.println("id: "+id+" name: "+name+" email: "+email+" salary: "+salary);


//                System.out.printf("%d %-7s %-17s %d %s \n", id, name, email, salary, dept);

                System.out.printf("%-2d %-10s %-20s %-7d %s \n", id, name, email, salary, dept);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException s){
            s.printStackTrace();
        }
    }
}