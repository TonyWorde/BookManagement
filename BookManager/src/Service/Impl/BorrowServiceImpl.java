package Service.Impl;

import java.util.ArrayList;
import java.util.List;

import Dao.*;
import Dao.Impl.*;
import Service.*;
import Values.*;

public class BorrowServiceImpl implements BorrowService{

	@Override
	public Boolean setBorrow(String re_id,String id,int stock) {
		
		int re_syjys = 0;
		Boolean result = false;
		
		ReaderService reader1 = new ReaderServiceImpl();
		ReaderDao reader2 = new ReaderDaoImpl();
		BookService book1 = new BookServiceImpl();
		BookDao book2 = new BookDaoImpl();
		BorrowDao borrow = new BorrowDaoImpl();
		
		TB_Borrow tb = new TB_Borrow();
		TB_Book tbook = new TB_Book();
		TB_Reader tr = new TB_Reader();
		
		if(stock<=1)
			return result;
		re_syjys = reader1.getReaderSyjysById(re_id);
		if(re_syjys<=0)
			return result;
		
		tb = borrow.queryBorrowByIdId(re_id,id);
		tbook = book1.getBookById(id);
		tr = reader1.getReader(re_id);
		
		if((tb!=null)&&(tbook!=null)&&(tr!=null)){
			tr.setRe_yjys(tr.getRe_yjys()+1);
			tr.setRe_syjys(tr.getRe_syjys()-1);
			reader2.updateReader(re_id, tr);
			book2.updateBookStock(id,stock-1);
			result = borrow.updateBorrow(re_id, id, tb.getBr_num()+1);
			return result;
		}
		
		if((tb==null)&&(tbook!=null)&&(tr!=null)){
			TB_Borrow tb1 = new TB_Borrow();
			
			tb1.setRe_id(re_id);
			tb1.setBr_id(id);
			tb1.setBr_name(tbook.getB_name());
			tb1.setBr_author(tbook.getB_author());
			tb1.setBr_img(tbook.getB_img());
			tb1.setBr_num(1);
			
			tr.setRe_yjys(tr.getRe_yjys()+1);
			tr.setRe_syjys(tr.getRe_syjys()-1);
			reader2.updateReader(re_id, tr);
			book2.updateBookStock(id,stock-1);
			
			result = borrow.insertBorrow(tb1);
			return result;
		}
		return result;
	}

	@Override
	public List<TB_Borrow> getBorrowAll(String id) {
		
		BorrowDao result = new BorrowDaoImpl();
		List<TB_Borrow> list = new ArrayList<TB_Borrow>();
		list = result.queryBorrowById(id);
		if((!list.isEmpty())&&(list!=null))
			return list;
		return null;

	}

	@Override
	public List<TB_Borrow> getBorrowAll() {
		BorrowDaoImpl result = new BorrowDaoImpl();
		List<TB_Borrow> list = new ArrayList<TB_Borrow>();
		list = result.queryBorrow();
		if((!list.isEmpty())&&(list!=null))
			return list;
		return null;
	}

}
