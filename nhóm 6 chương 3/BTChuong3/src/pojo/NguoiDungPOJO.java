package pojo;

public class NguoiDungPOJO {
	public NguoiDungPOJO(int iND_ID, String strHoTen) {
		
		this.iND_ID = iND_ID;
		StrHoTen = strHoTen;
	}
	public NguoiDungPOJO()
	{}
	
	private int iND_ID;
	public int getiND_ID() {
		return iND_ID;
	}
	public void setiND_ID(int iND_ID) {
		this.iND_ID = iND_ID;
	}
	public String getStrHoTen() {
		return StrHoTen;
	}
	public void setStrHoTen(String strHoTen) {
		StrHoTen = strHoTen;
	}
	private String StrHoTen	;
}
