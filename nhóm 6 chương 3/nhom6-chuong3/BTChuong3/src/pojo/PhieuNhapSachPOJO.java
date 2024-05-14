package pojo;

import java.util.Date;

public class PhieuNhapSachPOJO {
	public PhieuNhapSachPOJO(int iPNS_ID, String strGhiChu, Date dNgay, String strNhanVien) {
		
		this.iPNS_ID = iPNS_ID;
		this.strGhiChu = strGhiChu;
		this.dNgay = dNgay;
		this.strNhanVien = strNhanVien;
	}
	public PhieuNhapSachPOJO()
	{
	}
	public PhieuNhapSachPOJO(PhieuNhapSachPOJO pns) {
		
		this.iPNS_ID = pns.iPNS_ID;
		this.strGhiChu = pns.strGhiChu;
		this.dNgay = pns.dNgay;
		this.strNhanVien = pns.strNhanVien;
	}
	private int iPNS_ID;
	public int getiPNS_ID() {
		return iPNS_ID;
	}
	public void setiPNS_ID(int iPNS_ID) {
		this.iPNS_ID = iPNS_ID;
	}
	public String getStrGhiChu() {
		return strGhiChu;
	}
	public void setStrGhiChu(String strGhiChu) {
		this.strGhiChu = strGhiChu;
	}
	public Date getdNgay() {
		return dNgay;
	}
	public void setdNgay(Date dNgay) {
		this.dNgay = dNgay;
	}
	public String getStrNhanVien() {
		return strNhanVien;
	}
	public void setStrNhanVien(String strNhanVien) {
		this.strNhanVien = strNhanVien;
	}
	private String strGhiChu;
	private Date dNgay;
	private String strNhanVien;
	
}
