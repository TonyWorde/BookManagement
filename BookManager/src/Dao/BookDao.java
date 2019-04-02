package Dao;

import java.util.List;

import Values.*;

public interface BookDao {
	public List<TB_Book> queryBookByName(String name);
	public TB_Book queryBookById(String id);
	public List<TB_Book> queryBook();
	public Boolean updateBookStock(String id,int stock);
}
