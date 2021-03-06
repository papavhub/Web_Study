package hyemin_free.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hyemin_free.domain.MovieVO;

public class MovieDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	
	
	
	public ArrayList<MovieVO> getMovieList() {
		connect();
		ArrayList<MovieVO> movieList = new ArrayList<MovieVO>();
		String sql = "select * from movie";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setMovie_name(rs.getString("movie_name"));
				vo.setMovie_info(rs.getString("movie_info"));
				vo.setMovie_age(Integer.parseInt(rs.getString("movie_age")));
				vo.setMovie_genre(rs.getString("movie_genre"));
				vo.setMovie_image(rs.getString("movie_image"));
				vo.setMovie_row(Integer.parseInt(rs.getString("movie_row")));
				vo.setMovie_column(Integer.parseInt(rs.getString("movie_column")));
				
				movieList.add(vo);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return movieList;
	}
	
	public MovieVO getInfofromName(String movie_name) {
		connect();
		ArrayList<MovieVO> movieList = new ArrayList<MovieVO>();
		String sql = "select * from movie where movie_name='" + movie_name + "'";
		MovieVO vo = new MovieVO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setMovie_name(rs.getString("movie_name"));
				vo.setMovie_info(rs.getString("movie_info"));
				vo.setMovie_age(Integer.parseInt(rs.getString("movie_age")));
				vo.setMovie_genre(rs.getString("movie_genre"));
				vo.setMovie_image(rs.getString("movie_image"));
				vo.setMovie_row(Integer.parseInt(rs.getString("movie_row")));
				vo.setMovie_column(Integer.parseInt(rs.getString("movie_column")));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;
	}
	
	public boolean add(MovieVO vo) {
		connect();
		String sql = "insert into movie values (?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMovie_name());
			pstmt.setString(2, vo.getMovie_info());
			pstmt.setInt(3, vo.getMovie_age());
			pstmt.setString(4, vo.getMovie_genre());
			pstmt.setString(5, vo.getMovie_image());
			pstmt.setInt(6, vo.getMovie_row());
			pstmt.setInt(7, vo.getMovie_column());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean update(MovieVO movieVO) {
		connect();
		String sql = "update movie set movie_info=?, movie_age=?, movie_genre=?, movie_image=?, movie_row=?, movie_column=? where movie_name=" + "\"" + movieVO.getMovie_name() + "\"";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieVO.getMovie_info());
			pstmt.setInt(2, movieVO.getMovie_age());
			pstmt.setString(3, movieVO.getMovie_genre());
			pstmt.setString(4, movieVO.getMovie_image());
			pstmt.setInt(5, movieVO.getMovie_row());
			pstmt.setInt(6, movieVO.getMovie_column());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
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
