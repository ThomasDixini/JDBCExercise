package thomasdixini.rowsets;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetRepository {
    private String url;
    private String username;
    private String password;
    private RowSetFactory factory;
    private JdbcRowSet jdbcRs;

    public JdbcRowSetRepository(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void setConnection() {
        try {
            factory = RowSetProvider.newFactory();
            jdbcRs = factory.createJdbcRowSet();
            jdbcRs.setUrl(url);
            jdbcRs.setUsername(username);
            jdbcRs.setPassword(password);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage() + " - " + sqle.getErrorCode());
        }
    }

    public void createTable(Connection con, String table) throws SQLException {
        Statement stmt = con.createStatement();
        stmt.executeUpdate(
            "CREATE TABLE " + table +
            " (ID INT, NAME VARCHAR(255)," +
            " USERNAME CHAR(20), PASSWORD CHAR(20), CREATED_AT DATETIME, LAST_MODIFIED_AT DATETIME," +
            " PRIMARY KEY (ID));"
        );
    }
    public void insert(String table) throws SQLException {
        jdbcRs.setCommand("SELECT * FROM " + table);
        jdbcRs.execute();

        jdbcRs.moveToInsertRow();
        jdbcRs.updateInt("ID", 1);
        jdbcRs.updateString("NAME", "Teste");
        jdbcRs.updateString("USERNAME", "usertest");
        jdbcRs.updateString("PASSWORD", "1234");
        jdbcRs.updateDate("CREATED_AT", new Date(System.currentTimeMillis()));
        jdbcRs.updateDate("LAST_MODIFIED_AT", new Date(System.currentTimeMillis()));
        jdbcRs.insertRow();
    }
}
