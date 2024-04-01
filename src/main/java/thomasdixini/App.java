package thomasdixini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import thomasdixini.jdbcdao.DAO;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");

            String queryString = 
            "CREATE TABLE " + "CLIENTE" +  
            " (ID INT, NAME VARCHAR(255)," +
            " USERNAME CHAR(20), PASSWORD CHAR(20), CREATED_AT DATETIME, LAST_MODIFIED_AT DATETIME," +
            " PRIMARY KEY (ID));";
            
            DAO.createTable(con, "cliente", queryString);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException err) {
            System.out.println(err);
        }
    }
}
