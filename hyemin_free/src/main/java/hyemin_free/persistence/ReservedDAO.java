package hyemin_free.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hyemin_free.domain.MovieVO;
import hyemin_free.domain.ReservedVO;

public class ReservedDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	
	
	public boolean add(ReservedVO vo) {
		connect();
		String sql = "insert into reserved values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMovie_name());
			pstmt.setString(2, vo.getCustomer_id());
			pstmt.setString(3, vo.getrow_column());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean delete(ReservedVO reservedVO) {
		connect();
		String sql = "delete from reserved where movie_name='" + reservedVO.getMovie_name() + "' and row_column='" + reservedVO.getrow_column() + "'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
		
	}
	
	public ArrayList<ReservedVO> getmyReservedList(String customer_id) {
		connect();
		ArrayList<ReservedVO> myReservedList = new ArrayList<ReservedVO>();
		String sql = "select * from reserved where customer_id='" + customer_id + "'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReservedVO vo = new ReservedVO();
				vo.setMovie_name(rs.getString("movie_name"));
				vo.setCustomer_id(rs.getString("customer_id"));
				vo.setrow_column(rs.getString("row_column"));
				
				myReservedList.add(vo);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return myReservedList;
	}
	
	
	
	public int getMovie_column(String movie_name) {
		connect();
		int movie_column = 0;
		String sql = "select * from movie where movie_name='" + movie_name + "'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				movie_column = Integer.parseInt(rs.getString("movie_column"));
			}
			
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return movie_column;
	}
	
	public int getMovie_row(String movie_name) {
		connect();
		int movie_row = 0;
		String sql = "select * from movie where movie_name='" + movie_name + "'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				movie_row = Integer.parseInt(rs.getString("movie_row"));
			}
			
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return movie_row;
	}
	
	public ArrayList<ReservedVO> getMovieReservedList(String movie_name) {
		connect();
		ArrayList<ReservedVO> reservedList = new ArrayList<ReservedVO>();
		String sql = "select * from reserved where movie_name='" + movie_name + "'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReservedVO vo = new ReservedVO();
				vo.setMovie_name(rs.getString("movie_name"));
				vo.setCustomer_id(rs.getString("customer_id"));
				vo.setrow_column((rs.getString("row_column")));

				reservedList.add(vo);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return reservedList;
	}
	
	
	
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook","passwd");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
