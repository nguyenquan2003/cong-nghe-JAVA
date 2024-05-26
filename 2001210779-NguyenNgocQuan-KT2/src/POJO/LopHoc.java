package POJO;

import java.util.Date;

public class LopHoc {
	private String tenLop;
	private Date ngayBD;
	private Date ngayKT;
	private float testA;
	private float testB;
	private float testC;
	private int idGV;
	public LopHoc(String tenLop, Date ngayBD, Date ngayKT, float testA, float testB, float testC, int idGV) {
		super();
		this.tenLop = tenLop;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
		this.testA = testA;
		this.testB = testB;
		this.testC = testC;
		this.idGV = idGV;
	}
	public LopHoc() {
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public Date getNgayBD() {
		return ngayBD;
	}
	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}
	public Date getNgayKT() {
		return ngayKT;
	}
	public void setNgayKT(Date ngayKT) {
		this.ngayKT = ngayKT;
	}
	public float getTestA() {
		return testA;
	}
	public void setTestA(float testA) {
		this.testA = testA;
	}
	public float getTestB() {
		return testB;
	}
	public void setTestB(float testB) {
		this.testB = testB;
	}
	public float getTestC() {
		return testC;
	}
	public void setTestC(float testC) {
		this.testC = testC;
	}
	public int getIdGV() {
		return idGV;
	}
	public void setIdGV(int idGV) {
		this.idGV = idGV;
	}
	
	
}
