package Service;

import java.util.List;

import Values.TB_Reader;


public interface ReaderService {
	public Boolean judge(String id,String pwd);
	public String getReaderNameById(String id);
	public int getReaderSyjysById(String id);
	public TB_Reader getReader(String id);
	public Boolean setReaderNum(String id);
	public List<TB_Reader> getReaderAll();
	public List<TB_Reader> getReaderById(String id);
}
