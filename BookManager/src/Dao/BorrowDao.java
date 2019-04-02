package Dao;

import java.util.List;

import Values.TB_Borrow;

public interface BorrowDao {
	public List<TB_Borrow> queryBorrowById(String id);
	public Boolean insertBorrow(TB_Borrow tb);
	public Boolean updateBorrow(String re_id,String id,int num);
	public Boolean deleteBorrow();
	public TB_Borrow queryBorrowByIdId(String re_id,String id);
	public List<TB_Borrow> queryBorrow();
}
