package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Values.TB_Reader;

import DBUtil.DBUtil;
import Dao.*;

public class ReaderDaoImpl implements ReaderDao{

	@Override
	public TB_Reader queryReader(String id) {
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		TB_Reader tr = new TB_Reader();
		String sql = "SELECT * from tb_reader where reader_id=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				tr.setRe_id(rs.getString(1));
				tr.setRe_pwd(rs.getString(2));
				tr.setRe_name(rs.getString(3));
				tr.setRe_sex(rs.getString(4));
				tr.setRe_phone(rs.getString(5));
				tr.setRe_yjys(rs.getInt(6));
				tr.setRe_syjys(rs.getInt(7));
			}
			return tr;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return null;
	}

	@Override
	public Boolean updateReader(String id,TB_Reader tr) {
		
		Boolean result = false;
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		String sql = "update tb_reader set reader_hbrd=?,reader_rbrd=? where reader_id=?;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(3, id);
			pstmt.setInt(1, tr.getRe_yjys());
			pstmt.setInt(2, tr.getRe_syjys());
			pstmt.executeUpdate();
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<TB_Reader> queryReaderAll() {
		Connection conn = DBUtil.open();
		Statement stmt = null;
		List<TB_Reader> list = new ArrayList<TB_Reader>();
		String sql = "SELECT * from tb_reader;";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TB_Reader tr = new TB_Reader();
				tr.setRe_id(rs.getString(1));
				tr.setRe_pwd(rs.getString(2));
				tr.setRe_name(rs.getString(3));
				tr.setRe_sex(rs.getString(4));
				tr.setRe_phone(rs.getString(5));
				tr.setRe_yjys(rs.getInt(6));
				tr.setRe_syjys(rs.getInt(7));
				list.add(tr);
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
	public List<TB_Reader> queryReaderById(String id) {
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		List<TB_Reader> list = new ArrayList<TB_Reader>();
		String sql = "SELECT * from tb_reader where reader_id=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				TB_Reader tr = new TB_Reader();
				tr.setRe_id(rs.getString(1));
				tr.setRe_pwd(rs.getString(2));
				tr.setRe_name(rs.getString(3));
				tr.setRe_sex(rs.getString(4));
				tr.setRe_phone(rs.getString(5));
				tr.setRe_yjys(rs.getInt(6));
				tr.setRe_syjys(rs.getInt(7));
				list.add(tr);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return null;
	}

}
