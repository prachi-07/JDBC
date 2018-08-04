import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JdbcUtil {
	public static Connection getConnection() throws Exception {
		Properties p = new Properties();
		p.load(new FileReader("src/database.info"));

		Connection conn = null;
 
		try {
			Class.forName(p.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pass"));

		return conn;
	}
}
