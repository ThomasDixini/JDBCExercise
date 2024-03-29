package thomasdixini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;
            String url = "jdbc:mysql://localhost:3306/jdbc";

            RowSetFactory factory = RowSetProvider.newFactory();

            JdbcRowSet jdbcRs = factory.createJdbcRowSet();
            jdbcRs.setUrl(url);
            jdbcRs.setUsername("root");
            jdbcRs.setPassword("1234");

            jdbcRs.setCommand("select * from suppliers");
            jdbcRs.execute();

            jdbcRs.moveToInsertRow();
            jdbcRs.updateString("SUP_ID", "123");
            jdbcRs.insertRow();
            
            while (jdbcRs.next()) {
                String sup_id = jdbcRs.getString("SUP_ID");
                System.out.println("sup_id: " + sup_id);
            }

        } catch (ClassNotFoundException e) {
            System.out.printf("Class Not Found" + e.getMessage());
        } catch (SQLException e) {
            System.out.printf(e.getMessage() + " - " + e.getErrorCode());
        }
    }
}
