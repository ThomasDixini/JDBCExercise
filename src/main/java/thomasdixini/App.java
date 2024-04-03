package thomasdixini;

import java.sql.Connection;
import java.sql.Date;
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

            Date date = new Date(System.currentTimeMillis());

            DAO.createTable(con, "cliente");
            DAO.select(con, "cliente");
            DAO.insert(con, "cliente", 1, "Wesley", "wesleyteste", "1234", date, date);
            DAO.update(con, "cliente");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException err) {
            System.out.println(err);
        }
    }
}
