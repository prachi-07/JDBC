import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String Driver = "oracle.jdbc.OracleDriver";
		Connection conn = null;

		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, "training", "oracle");
			System.out.println("Connection successful");
 
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("DB name: " + meta.getDatabaseProductName());
			System.out.println("DB ver: " + meta.getDatabaseProductVersion());
			System.out.println("Driver name: " + meta.getDriverName());
			System.out.println("Driver ver: " + meta.getDriverVersion());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
