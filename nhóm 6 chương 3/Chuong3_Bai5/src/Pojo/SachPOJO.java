package Pojo;

public class SachPOJO {
	private int iID;
    private String strTen;
    private String strTacGia;
    private int NXB;
    private int iLSID;
    private String strMota;
    
    public SachPOJO(){ }
    
    public SachPOJO(int id, String Ten, String TacGia, int NXB, int LSID,  String Mota) {
        this.iID = id;
        this.strTen = Ten;
        this.strTacGia = TacGia;
        this.NXB = NXB;
        this.iLSID = LSID;
        this.strMota = Mota;
    }
    
    public SachPOJO(SachPOJO s) {
        this.iID = s.iID;
        this.strTen = s.strTen;
        this.strTacGia = s.strTacGia;
        this.NXB = s.NXB;
        this.iLSID = s.iLSID;
        this.strMota = s.strMota;
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
    
    public String getStrTacGia() {
        return this.strTacGia;
    }
    
    public void setStrTacGia(String strTacGia) {
        this.strTacGia = strTacGia;
    }
    
    public int getNXB() {
        return this.NXB;
    }
    
    public void setNXB(int NXB) {
        this.NXB = NXB;
    }
    
    public int getiLSID() {
        return this.iLSID;
    }
    
    public void setiLSID(int iLSID) {
        this.iLSID = iLSID;
    }
    
    public String getStrMoTa() {
        return this.strMota;
    }
    
    public void setStrMoTa(String strMota) {
        this.strMota = strMota;
    }
}
