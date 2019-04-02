package Service.Impl;

import java.util.ArrayList;
import java.util.List;

import Dao.BookDao;
import Dao.Impl.BookDaoImpl;
import Service.BookService;
import Values.TB_Book;

public class BookServiceImpl implements BookService{

	@Override
	public int getBookStockById(String id) {
		int stock = 0;
		BookDao result = new BookDaoImpl();
		TB_Book tb = new TB_Book();
		tb = result.queryBookById(id);
		if(tb!=null)
			stock = tb.getB_stock();
		return stock;
	}

	@Override
	public TB_Book getBookById(String id) {
		BookDao result =new BookDaoImpl();
		TB_Book tb = new TB_Book();
		tb = result.queryBookById(id);
		if(tb!=null)
			return tb;
		return null;
	}

	@Override
	public Boolean setBookStock(String id, int stock) {
		Boolean result = false;
		BookDao bd = new BookDaoImpl();
		result = bd.updateBookStock(id, stock);
		return result;
	}

	@Override
	public List<TB_Book> getBookAll() {
		BookDaoImpl result = new BookDaoImpl();
		List<TB_Book> list = new ArrayList<TB_Book>();
		list = result.queryBook();
		if((!list.isEmpty())&&(list!=null))
			return list;
		return null;
	}


}
