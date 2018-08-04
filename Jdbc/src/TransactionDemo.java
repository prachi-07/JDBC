import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) {
		Connection conn = null;
		String sql = "insert into product values(112,'White Board',500)";
		String sql2 = "update product set price = 30 where code =123";
		String sql3 = "delete from product where code = 121";

		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
 
			Statement stmt = conn.createStatement();
			stmt.addBatch(sql);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);

			stmt.executeBatch();
			conn.commit();
			System.out.println("Transaction completed");
		} catch (SQLException e) {
			System.out.println("Transaction failed");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
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