package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Values.TB_Book;
import DBUtil.DBUtil;
import Dao.BookDao;

public class BookDaoImpl implements BookDao{

	@Override
	public List<TB_Book> queryBookByName(String name) {
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		List<TB_Book> list = new ArrayList<TB_Book>();
		String sql = "select * from TB_Book where book_name like ?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				TB_Book b = new TB_Book();
				b.setB_id(rs.getString(1));
				b.setB_name(rs.getString(2));
				b.setB_author(rs.getString(3));
				b.setB_img(rs.getString(4));
				b.setB_press(rs.getString(5));
				b.setB_pubdate(rs.getString(6));
				b.setB_stock(rs.getInt(7));
				list.add(b);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return list;
	}

	@Override
	public List<TB_Book> queryBook() {
		Connection conn = DBUtil.open();
		Statement stmt = null;
		List<TB_Book> list = new ArrayList<TB_Book>();
		String sql = "SELECT * from tb_Book;";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TB_Book b = new TB_Book();
				b.setB_id(rs.getString(1));
				b.setB_name(rs.getString(2));
				b.setB_author(rs.getString(3));
				b.setB_img(rs.getString(4));
				b.setB_press(rs.getString(5));
				b.setB_pubdate(rs.getString(6));
				b.setB_stock(rs.getInt(7));
				list.add(b);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt);
		}
		return null;
	}

	@Override
	public TB_Book queryBookById(String id) {
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		TB_Book tb = new TB_Book();
		String sql = "select * from TB_Book where book_id=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				tb.setB_id(rs.getString(1));
				tb.setB_name(rs.getString(2));
				tb.setB_author(rs.getString(3));
				tb.setB_img(rs.getString(4));
				tb.setB_press(rs.getString(5));
				tb.setB_pubdate(rs.getString(6));
				tb.setB_stock(rs.getInt(7));
				return tb;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return null;
	}

	@Override
	public Boolean updateBookStock(String id,int stock) {
		
		Boolean result = false;
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		String sql = "update tb_book set book_stock=? where book_id=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stock);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			result = true;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt);
		}
		
		return result;
	}

}
