package Service.Impl;

import Dao.*;
import Dao.Impl.*;
import Service.*;
import Values.*;

public class ReturnServiceImpl implements ReturnService{

	@Override
	public Boolean setReturn(String re_id,String id)
	{
		Boolean result = false;
		int stock = 0;
		TB_Borrow tb = new TB_Borrow();
		BookService bs = new BookServiceImpl();
		BorrowDao bd = new BorrowDaoImpl();
		ReaderService rs = new ReaderServiceImpl();
		
		tb = bd.queryBorrowByIdId(re_id, id);
		stock = bs.getBookStockById(id);
		
		if(tb==null)
			return result;
		if(tb.getBr_num()>1){
			result = bd.updateBorrow(re_id, id, tb.getBr_num()-1);
			rs.setReaderNum(re_id);
			bs.setBookStock(id, ++stock);
		}
		else{
			result = bd.deleteBorrow();
			rs.setReaderNum(re_id);
			bs.setBookStock(id, ++stock);
		}
		
		return result;
	}
}

