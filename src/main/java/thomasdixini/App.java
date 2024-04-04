package thomasdixini;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import thomasdixini.jdbcdao.DAO;
import thomasdixini.rowsets.JdbcRowSetRepository;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/rowsetjdbc", "root", "1234");

            /*Date date = new Date(System.currentTimeMillis());

            DAO.createTable(con, "cliente");
            DAO.select(con, "cliente");
            DAO.insert(con, "cliente", 1, "Wesley", "wesleyteste", "1234", date, date);
            DAO.update(con, "cliente");*/

            JdbcRowSetRepository repository = new JdbcRowSetRepository("jdbc:mysql://localhost:3306/rowsetjdbc", "root", "1234");
            repository.setConnection();
            //repository.createTable(con2,"cliente");
            repository.insert("cliente");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException err) {
            System.out.println(err);
        }
    }
}
