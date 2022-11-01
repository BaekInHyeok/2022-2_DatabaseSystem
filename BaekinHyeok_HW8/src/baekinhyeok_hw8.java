import java.sql.*;

public class baekinhyeok_hw8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://192.168.89.6:4567/madang", "baekinhyeok", "ajskduy6380");
			Statement stmt=con.createStatement();
			PreparedStatement pstmt;
			int ret;
			
			//madang 데이터베이스의 Book Table에 데이터 추가
			pstmt=con.prepareStatement("INSERT INTO Book(bookid,bookname,publisher,price) VALUES(24,'데이터베이스시스템','충북대학교',50000)");
			ret=pstmt.executeUpdate();
			
			//madang 데이터베이스의 Book Table에서 bookid가 14인 데이터를 삭제
			pstmt=con.prepareStatement("DELETE FROM Book WHERE bookid='14'");
			ret=pstmt.executeUpdate();
			
			//madang 데이터베이스의 Book Table 전체를 검색해 자바 콘솔에 출력
			ResultSet rs=stmt.executeQuery("SELECT * FROM Book");
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
