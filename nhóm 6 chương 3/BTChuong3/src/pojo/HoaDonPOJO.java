package pojo;

import java.util.Date;

public class HoaDonPOJO {
	public HoaDonPOJO(int iHD_ID, Date dNgay, int iND_ID, String strTenKhachHang, String strGhiChu) {
	
		this.iHD_ID = iHD_ID;
		this.dNgay = dNgay;
		this.iND_ID = iND_ID;
		this.strTenKhachHang = strTenKhachHang;
		this.strGhiChu = strGhiChu;
	}
	public HoaDonPOJO()
	{}
	public HoaDonPOJO(HoaDonPOJO hd) {
		
		this.iHD_ID = hd.iHD_ID;
		this.dNgay = hd.dNgay;
		this.iND_ID = hd.iND_ID;
		this.strTenKhachHang = hd.strTenKhachHang;
		this.strGhiChu = hd.strGhiChu;
	}
	private int iHD_ID;
	private Date dNgay;
	private int iND_ID;
	private String strTenKhachHang;
	public int getiHD_ID() {
		return iHD_ID;
	}
	public void setiHD_ID(int iHD_ID) {
		this.iHD_ID = iHD_ID;
	}
	public Date getdNgay() {
		return dNgay;
	}
	public void setdNgay(Date dNgay) {
		this.dNgay = dNgay;
	}
	public int getiND_ID() {
		return iND_ID;
	}
	public void setiND_ID(int iND_ID) {
		this.iND_ID = iND_ID;
	}
	public String getStrTenKhachHang() {
		return strTenKhachHang;
	}
	public void setStrTenKhachHang(String strTenKhachHang) {
		this.strTenKhachHang = strTenKhachHang;
	}
	public String getStrGhiChu() {
		return strGhiChu;
	}
	public void setStrGhiChu(String strGhiChu) {
		this.strGhiChu = strGhiChu;
	}
	private String strGhiChu;
}
