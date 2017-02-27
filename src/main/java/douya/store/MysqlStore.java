package douya.store;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 
public class MysqlStore {
	public  static  void insert (String url,String title,String Content) {
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "spider";
        String passwrod = "root";
        String userName = "root";
        String dburl = "jdbc:mysql://localhost:3306/" + dbName+"?useUnicode=true&characterEncoding=utf-8";
        String sql = "insert into blog values(\""+url+"\",\""+title+"\",\""+Content+"\")" ;
 
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(dburl, userName,passwrod);
            
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
}
