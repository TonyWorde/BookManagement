package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Values.TB_Borrow;
import DBUtil.DBUtil;
import Dao.BorrowDao;

public class BorrowDaoImpl implements BorrowDao{

	@Override
	public List<TB_Borrow> queryBorrowById(String id) {
		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		String sql = "select * from tb_borrow where reader_id=?;";
		List<TB_Borrow> list = new ArrayList<TB_Borrow>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				TB_Borrow tb = new TB_Borrow();
				tb.setRe_id(rs.getString(1));
				tb.setBr_id(rs.getString(2));
				tb.setBr_name(rs.getString(3));
				tb.setBr_author(rs.getString(4));
				tb.setBr_img(rs.getString(5));
				tb.setBr_num(rs.getInt(6));
				list.add(tb);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return null;
	}

	@Override
	public Boolean insertBorrow(TB_Borrow tb) {
		
		Boolean result = false;
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		String sql = "insert into TB_Borrow values(?,?,?,?,?,?);";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, tb.getRe_id());
			pstmt.setString(2,tb.getBr_id());
			pstmt.setString(3,tb.getBr_name());
			pstmt.setString(4, tb.getBr_author());
			pstmt.setString(5,tb.getBr_img());
			pstmt.setInt(6, tb.getBr_num());
			
			pstmt.executeUpdate();
			result = true;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Boolean updateBorrow(String re_id,String id,int num) {
		
		Boolean result = false;
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		String sql = "update tb_borrow set book_num=? where reader_id=? and book_id=?;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, re_id);
			pstmt.setString(3,id);
			pstmt.executeUpdate();
			
			result = true;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Boolean deleteBorrow() {
		
		Boolean result = false;
		Connection conn = DBUtil.open();
		Statement stmt = null;
		String sql = "delete from tb_borrow where book_num=1;";
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			result = true;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public TB_Borrow queryBorrowByIdId(String re_id, String id) {
		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		String sql = "select * from tb_borrow where reader_id=? and book_id=?;";
		TB_Borrow tb = new TB_Borrow();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, re_id);
			pstmt.setString(2, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				tb.setRe_id(rs.getString(1));
				tb.setBr_id(rs.getString(2));
				tb.setBr_name(rs.getString(3));
				tb.setBr_author(rs.getString(4));
				tb.setBr_img(rs.getString(5));
				tb.setBr_num(rs.getInt(6));
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
	public List<TB_Borrow> queryBorrow() {
		Connection conn = DBUtil.open();
		Statement stmt = null;
		List<TB_Borrow> list = new ArrayList<TB_Borrow>();
		String sql = "SELECT * from tb_Borrow;";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TB_Borrow tb = new TB_Borrow();
				tb.setRe_id(rs.getString(1));
				tb.setBr_id(rs.getString(2));
				tb.setBr_name(rs.getString(3));
				tb.setBr_author(rs.getString(4));
				tb.setBr_img(rs.getString(5));
				tb.setBr_num(rs.getInt(6));
				list.add(tb);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt);
		}
		return null;
	}


}
