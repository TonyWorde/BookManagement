package Service.Impl;

import java.util.ArrayList;
import java.util.List;

import Dao.ReaderDao;
import Dao.Impl.ReaderDaoImpl;
import Service.ReaderService;
import Values.TB_Reader;

public class ReaderServiceImpl implements ReaderService{

	@Override
	public Boolean judge(String id, String pwd) {
		ReaderDao result = new ReaderDaoImpl();
		Boolean j = false;
		TB_Reader tr = new TB_Reader();
		tr = result.queryReader(id);
		if(tr!=null){
			if((id.equals(tr.getRe_id()))&&(pwd.equals(tr.getRe_pwd()))){
				j = true;
				return j;
			}
		}
		return j;
	}

	@Override
	public String getReaderNameById(String id) {
		String  name = null;
		ReaderDao result = new ReaderDaoImpl();
		TB_Reader tr = new TB_Reader();
		tr = result.queryReader(id);
		if(tr!=null)
			name = tr.getRe_name();
		
		return name;
	}

	@Override
	public int getReaderSyjysById(String id) {
		int syjys = 0;
		TB_Reader tr = new TB_Reader();
		ReaderDao result = new ReaderDaoImpl();
		tr = result.queryReader(id);
		if(tr!=null)
			syjys = tr.getRe_syjys();
		
		return syjys;
	}

	@Override
	public TB_Reader getReader(String id) {
		TB_Reader tr = new TB_Reader();
		ReaderDao result = new ReaderDaoImpl();
		tr = result.queryReader(id);
		if(tr!=null)
			return tr;
		return null;
	}

	@Override
	public Boolean setReaderNum(String id)
	{
		boolean result=false;
		TB_Reader tr =new TB_Reader();
		ReaderDao tb = new ReaderDaoImpl();
		tr = tb.queryReader(id);
		if(tr==null)
		{
			return result;
		}
		else
		{
			tr.setRe_yjys(tr.getRe_yjys()-1);
			tr.setRe_syjys(tr.getRe_syjys()+1);
			tb.updateReader(id, tr);
			result=true;
		}
		return result;
	}

	@Override
	public List<TB_Reader> getReaderAll() {
		ReaderDaoImpl result = new ReaderDaoImpl();
		List<TB_Reader> list = new ArrayList<TB_Reader>();
		list = result.queryReaderAll();
		if((!list.isEmpty())&&(list!=null))
			return list;
		return null;
	}

	@Override
	public List<TB_Reader> getReaderById(String id) {
		List<TB_Reader> tr = new ArrayList<TB_Reader>();
		ReaderDao result = new ReaderDaoImpl();
		tr = result.queryReaderById(id);
		if(tr!=null)
			return tr;
		return null;
	}
}
