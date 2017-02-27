package douya.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlStore {
	public static void insert(String url, String title, String Content) {
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "spider";
		String passwrod = "root";
		String userName = "root";
		String dburl = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
		String sql = "insert into blog values(\"" + url + "\",\"" + title + "\",\"" + Content + "\")";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dburl, userName, passwrod);

			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.execute();

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertUser(String user) {
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "spider";
		String passwrod = "root";
		String userName = "root";
		String dburl = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
		String sql = "insert into author values(null,\"" + user + "\")";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dburl, userName, passwrod);

			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.execute();

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static  ArrayList<String > getAlluser() {
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "spider";
		String passwrod = "root";
		String userName = "root";
		String dburl = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
		String sql = "select DISTINCT name from  author ";
		ArrayList<String > user=new ArrayList<String>();
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dburl, userName, passwrod);

			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);

	 

			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(rs.getString(i) + "\t");
					user.add(rs.getString(i));
				}
				System.out.println("");
			}
			System.out.println("============================");
		} catch ( Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
