package Pojo;

public class PhieuNhapSachPOJO {
	private int iID;
    private String strGhiChu;
    private String Ngay;
    private String strNhanVien;
    
    public PhieuNhapSachPOJO(){ }
    
    public PhieuNhapSachPOJO(int id, String GhiChu, String Ngay,  String NhanVien) {
        this.iID = id;
        this.strGhiChu = GhiChu;
        this.Ngay = Ngay;
        this.strNhanVien = NhanVien;
    }
    
    public PhieuNhapSachPOJO(PhieuNhapSachPOJO PNS) {
        this.iID = PNS.iID;
        this.strGhiChu = PNS.strGhiChu;
        this.Ngay = PNS.Ngay;
        this.strNhanVien = PNS.strNhanVien;
    }
    
    public int getiID() {
        return this.iID;
    }
    
    public void setiID(int iID) {
        this.iID = iID;
    }
    
    public String getStrGhiChu() {
        return this.strGhiChu;
    }
    
    public void setStrGhiChu(String strGhiChu) {
        this.strGhiChu = strGhiChu;
    }
    
    public String getNgay() {
        return this.Ngay;
    }
    
    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }
    
    public String getStrNhanVien() {
        return this.strNhanVien;
    }
    
    public void setStrNhanVien(String strNhanVien) {
        this.strNhanVien = strNhanVien;
    }
}
