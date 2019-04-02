package Service;

import java.util.List;

import Values.TB_Book;

public interface BookService {
	public int getBookStockById(String id);
	public TB_Book getBookById(String id);
	public Boolean setBookStock(String id,int stock);
	public List<TB_Book> getBookAll();
}
