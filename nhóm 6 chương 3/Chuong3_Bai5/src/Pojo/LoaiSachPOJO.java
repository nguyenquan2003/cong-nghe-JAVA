package Pojo;

public class LoaiSachPOJO {
    private int iID;
    private String strTen;
    private String strMota;
    
    public LoaiSachPOJO(){ }
    
    public LoaiSachPOJO(int id, String Ten, String Mota) {
        this.iID = id;
        this.strTen = Ten;
        this.strMota = Mota;
    }
    
    public LoaiSachPOJO(LoaiSachPOJO ls) {
        this.iID = ls.iID;
        this.strTen = ls.strTen;
        this.strMota = ls.strMota;
    }
    
    public int getiID() {
        return this.iID;
    }
    
    public void setiID(int iID) {
        this.iID = iID;
    }
    
    public String getStrTen() {
        return this.strTen;
    }
    
    public void setStrTen(String strTen) {
        this.strTen = strTen;
    }
    
    public String getStrMoTa() {
        return this.strMota;
    }
    
    public void setStrMoTa(String strMota) {
        this.strMota = strMota;
    }
}
