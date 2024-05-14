package pojo;

public class LoaiSachPOJO {
	private int iID;
	public int getiID() {
		return iID;
	}
	public void setiID(int iID) {
		this.iID = iID;
	}
	public String getStrTen() {
		return strTen;
	}
	public void setStrTen(String strTen) {
		this.strTen = strTen;
	}
	public String getStrMoTa() {
		return strMoTa;
	}
	public void setStrMoTa(String strMoTa) {
		this.strMoTa = strMoTa;
	}
	private String strTen;
	private String strMoTa;
	public LoaiSachPOJO () { }
	public LoaiSachPOJO (int id, String ten, String mota) {
		this.iID= id;
		this.strTen = ten;
		this.strMoTa = mota;
	}
	public LoaiSachPOJO (LoaiSachPOJO ls) {
		this.iID= ls.iID;
		this.strTen = ls.strTen;
		this.strMoTa=ls.strMoTa;
	}
}


