package Service.Impl;


import Dao.AdministerDao;
import Dao.Impl.AdministerDaoImpl;
import Service.AdministerService;
import Values.TB_Administer;

public class AdministerServiceImpl implements AdministerService{

	@Override
	public Boolean judge(String id, String pwd) {
		AdministerDao result = new AdministerDaoImpl();
		Boolean j = false;
		TB_Administer ta = new TB_Administer();
		ta = result.queryAdmin(id);
		if(ta!=null){
			if((id.equals(ta.getAd_account()))&&(pwd.equals(ta.getAd_pwd()))){
				j = true;
				return j;
			}
		}
		return j;
	}

	@Override
	public String getAdminNameById(String id) {
		String  name = null;
		AdministerDao result = new AdministerDaoImpl();
		TB_Administer ta = new TB_Administer();
		ta = result.queryAdmin(id);
		if(ta!=null)
			name = ta.getAd_name();
		
		return name;
	}
}
