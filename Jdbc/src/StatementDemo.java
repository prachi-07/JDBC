import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

	public static void main(String[] args) {
		String sql = "insert into product values(123,'Marker',25)";
		Connection conn = null;
		try { 
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Record Inserted");
		} catch (Exception e) {
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
