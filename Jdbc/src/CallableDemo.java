import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDemo {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			CallableStatement stmt = conn.prepareCall("{call getName(?,?)}");
			stmt.setInt(1, 123);
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.execute(); 
			System.out.println("Name: " + stmt.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}