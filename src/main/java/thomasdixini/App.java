package thomasdixini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;

            System.out.println("Entrou");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            Statement stmt = con.createStatement();

            String query = "create table SUPPLIERS" + "(SUP_ID integer NOT NULL, PRIMARY KEY(SUP_ID))";
            stmt.executeUpdate(query);

            ResultSet rs = stmt.executeQuery("select * from SUPPLIERS");
            while (rs.next()) {
                System.out.println(rs.getString("SUP_NAME"));
            }

        } catch (ClassNotFoundException e) {
            System.out.printf("Class Not Found" + e.getMessage());
        } catch (SQLException ex) {
            System.out.printf("Error connecting: %s", ex.getMessage());
        }
    }
}
