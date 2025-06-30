import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourdatabase";
        String user = "yourusername";
        String password = "yourpassword";

        try {
            // Load JDBC driver (optional in modern versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create statement
            Statement stmt = conn.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Print results
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name") + " - " + rs.getInt("age"));
            }

            // Close
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



// | Database       | JDBC URL Example                                    | Driver Class Name                              |
// | -------------- | --------------------------------------------------- | ---------------------------------------------- |
// | **SQLite**     | `jdbc:sqlite:mydatabase.db`                         | `org.sqlite.JDBC`                              |
// | **PostgreSQL** | `jdbc:postgresql://localhost:5432/mydatabase`       | `org.postgresql.Driver`                        |
// | **SQL Server** | `jdbc:sqlserver://localhost:1433;databaseName=MyDB` | `com.microsoft.sqlserver.jdbc.SQLServerDriver` |

