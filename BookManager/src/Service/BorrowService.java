package Service;

import java.util.List;

import Values.TB_Borrow;

public interface BorrowService {
	public Boolean setBorrow(String re_id,String id,int stock);
	public List<TB_Borrow> getBorrowAll(String id);
	public List<TB_Borrow> getBorrowAll();
}
