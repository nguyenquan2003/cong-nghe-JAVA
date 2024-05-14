package pojo;

public class SachPOJO {
	
	public SachPOJO(int iS_ID, String strTieuDe, String strTacGia, int iNamXuatBan, int iLS_ID, String strMota) {
		
		this.iS_ID = iS_ID;
		this.strTieuDe = strTieuDe;
		this.strTacGia = strTacGia;
		this.iNamXuatBan = iNamXuatBan;
		this.iLS_ID = iLS_ID;
		this.strMota = strMota;
	}
	public SachPOJO(SachPOJO s) {
		
		this.iS_ID = s.iLS_ID;
		this.strTieuDe = s.strTieuDe;
		this.strTacGia = s.strTacGia;
		this.iNamXuatBan =s.iNamXuatBan;
		this.iLS_ID = s.iLS_ID;
		this.strMota = s.strMota;
	}
	public SachPOJO() { }
	private int iS_ID;
	public int getiS_ID() {
		return iS_ID;
	}
	public void setiS_ID(int iS_ID) {
		this.iS_ID = iS_ID;
	}
	public String getStrTieuDe() {
		return strTieuDe;
	}
	public void setStrTieuDe(String strTieuDe) {
		this.strTieuDe = strTieuDe;
	}
	public String getStrTacGia() {
		return strTacGia;
	}
	public void setStrTacGia(String strTacGia) {
		this.strTacGia = strTacGia;
	}
	public int getiNamXuatBan() {
		return iNamXuatBan;
	}
	public void setiNamXuatBan(int iNamXuatBan) {
		this.iNamXuatBan = iNamXuatBan;
	}
	public int getiLS_ID() {
		return iLS_ID;
	}
	public void setiLS_ID(int iLS_ID) {
		this.iLS_ID = iLS_ID;
	}
	public String getStrMota() {
		return strMota;
	}
	public void setStrMota(String strMota) {
		this.strMota = strMota;
	}
	private String strTieuDe;
	private String strTacGia;
	private int iNamXuatBan;
	private int iLS_ID;
	private String strMota;
}
