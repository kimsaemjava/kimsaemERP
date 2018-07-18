package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static void main(String[] args){
		System.out.println(getConnect());
	}
	//1. ����̹��ε�
	//==> �޼ҵ帶�� ����̹��� �ε��ϴ� �۾��� �������� �ʰ� Ŭ�����δ��� �۾�Ŭ������ �ε��Ҷ�
	//    �� ���� ����ǵ��� �۾��ϱ� ���ؼ� static���� �����ϰ� �ڵ带 �ۼ�
	static{
		try {
			//1. JDBC����̹��ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2. DB���� ���� - Ŀ�ؼǼ���
	public static Connection getConnect(){
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		try{
			con =DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	//3. �ڿ��ݳ� - ������ �޼ҵ�� ���� or �Ѳ����� �ݳ��ϴ� �޼ҵ带 ����
	public static void close(ResultSet rs, Statement stmt, 
			Connection con){
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//Ŀ�ؼ��� �ݳ��ϴ� �޼ҵ�
	public static void close(Connection con){
		try{
			if(con!=null) con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//Statement�ݳ�
	public static void close(Statement stmt){
		try{
			if(stmt!=null) stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//ResultSet�ݳ�
	public static void close(ResultSet rs){
		try{
			if(rs!=null) rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}











