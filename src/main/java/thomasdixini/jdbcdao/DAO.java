package thomasdixini.jdbcdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

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
    public static void select(Connection con, String table, String query) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                Date created_at = rs.getDate("CREATED_AT");
                Date last_modified_at = rs.getDate("LAST_MODIFIED_AT"); 
                System.out.println(id + name + username + password + created_at + last_modified_at);
            }
        } catch(SQLException err) {
            System.out.println(
                err.getSQLState() + "\n" +
                err.getErrorCode() + "\n" +
                err.getMessage() + "\n" +
                err.getCause()
                );
        }
    }
    public static void insert(Connection con, String table, String query, int id, String name, String username, String password, Date created_at, Date last_modified_at) throws SQLException {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query);
            rs.moveToInsertRow();
            rs.updateInt("ID", id);
            rs.updateString("NAME", name);
            rs.updateString("USERNAME", username);
            rs.updateString("PASSWORD", password);
            rs.updateDate("CREATED_AT", created_at);
            rs.updateDate("LAST_MODIFIED_AT", last_modified_at);
            rs.insertRow();
        } catch(SQLException err) {
            System.out.println(
                err.getSQLState() + "\n" +
                err.getErrorCode() + "\n" +
                err.getMessage() + "\n" +
                err.getCause()
                );
        }
    }
    public static void update(Connection con, String table, String query) throws SQLException {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE CLIENTE SET USERNAME = ? WHERE NAME = ?");
            stmt.setString(1, "thomas");
            stmt.setString(2, "Wesley");
            stmt.executeUpdate();
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
