package thomasdixini.jdbcdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    public static void createTable(Connection con, String table, String query) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch(SQLException err) {
            System.out.println(
                err.getSQLState() + "\n" +
                err.getErrorCode() + "\n" +
                err.getMessage() + "\n" +
                err.getCause()
                );
        }
    }
}
