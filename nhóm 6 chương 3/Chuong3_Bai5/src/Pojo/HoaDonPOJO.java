package Pojo;

public class HoaDonPOJO {
	private int iID;
    private String Ngay;
    private String NhanVien;
    private String TenKH;
    private String GhiChu;
    
    public HoaDonPOJO(){ }
    
    public HoaDonPOJO(int id, String Ngay, String NhanVien, String TenKH, String GhiChu) {
        this.iID = id;
        this.Ngay = Ngay;
        this.NhanVien = NhanVien;
        this.TenKH = TenKH;
        this.GhiChu = GhiChu;
    }
    
    public HoaDonPOJO(HoaDonPOJO HD) {
        this.iID = HD.iID;
        this.Ngay = HD.Ngay;
        this.NhanVien = HD.NhanVien;
        this.TenKH = HD.TenKH;
        this.GhiChu = HD.GhiChu;
    }
    
    public int getiID() {
        return this.iID;
    }
    
    public void setiID(int iID) {
        this.iID = iID;
    }
    
    public String getNgay() {
        return this.Ngay;
    }
    
    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }
    
    public String getNhanVien() {
        return this.NhanVien;
    }
    
    public void setNhanVien(String NhanVien) {
        this.NhanVien = NhanVien;
    }
    
    public String getTenKH() {
        return this.TenKH;
    }
    
    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }
    
    public String getGhiChu() {
        return this.GhiChu;
    }
    
    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
}
