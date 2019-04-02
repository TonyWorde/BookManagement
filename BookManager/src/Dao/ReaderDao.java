package Dao;


import java.util.List;

import Values.TB_Reader;

public interface ReaderDao {
	public TB_Reader queryReader(String id);
	public Boolean updateReader(String id,TB_Reader tr);
	public List<TB_Reader> queryReaderAll();
	public List<TB_Reader> queryReaderById(String id);
}
