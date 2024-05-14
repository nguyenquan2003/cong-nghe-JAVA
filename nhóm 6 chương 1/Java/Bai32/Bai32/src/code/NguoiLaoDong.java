package code;



public abstract class NguoiLaoDong {
    protected String maSo;
    protected String hoTen;
    protected int namSinh;

    public NguoiLaoDong(String maSo, String hoTen, int namSinh)
    {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    public String getMaSo()
    {
        return maSo;
    }
    public void setMaSo(String maSo)
    {
        this.maSo = maSo;
    }
    public String getHoTen()
    {
        return hoTen;
    }
    public void setHoTen(String hoTen)
    {
        this.hoTen = hoTen;
    }
    public int getNamSinh()
    {
        return namSinh;
    }
    public void setNamSinh(int namSinh)
    {
        this.namSinh = namSinh;
    }

    public abstract void nhap();
    public abstract void xuat(); 
    public abstract double tinhLuong();

}
