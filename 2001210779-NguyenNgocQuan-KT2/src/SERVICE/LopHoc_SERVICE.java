package SERVICE;

import java.util.List;


import DAO.LopHoc_DAO;

import POJO.LopHoc;

public class LopHoc_SERVICE {
	private LopHoc_DAO lh_DAO;
	public LopHoc_SERVICE() {
		lh_DAO = new LopHoc_DAO();
	}
	
	public List<LopHoc> getAllCDDVD() {
		return lh_DAO.getAllClasses();
	}

}
