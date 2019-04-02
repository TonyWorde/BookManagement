package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Values.TB_Administer;

import DBUtil.*;
import Dao.*;

public class AdministerDaoImpl implements AdministerDao {

	@Override
	public TB_Administer queryAdmin(String id) {
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		TB_Administer ta = new TB_Administer();
		String sql = "SELECT * from tb_Administer where admin_account=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				ta.setAd_account(rs.getString(1));
				ta.setAd_pwd(rs.getString(2));
				ta.setAd_name(rs.getString(3));
				ta.setAd_sex(rs.getString(4));
				ta.setAd_phone(rs.getString(5));
				return ta;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return null;
	}

/*	@Override
	public List<TB_Administer> getAdminAll() {
		Connection conn = DBUtil.open();
		Statement stmt = null;
		List<TB_Administer> list = new ArrayList<TB_Administer>();
		String sql = "SELECT * from tb_administer;";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TB_Administer ta = new TB_Administer();
				ta.setAd_account(rs.getString(1));
				ta.setAd_pwd(rs.getString(2));
				ta.setAd_name(rs.getString(3));
				ta.setAd_sex(rs.getString(4));
				ta.setAd_phone(rs.getString(5));
				list.add(ta);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt);
		}
		return null;
	}
*/
}
