package Swing;

public class Bai9_Employee {
	String empCode, empName;
	int salary;
	
	public Bai9_Employee(String empCode, String empName, int salary) {
		this.empCode = empCode;
		this.empName = empName;
		this.salary = salary;
	}
	
	public String toString() {
		return empCode + "-" + empName;
	}
	
	public String getEmpCode() {
		return empCode;
	}
	
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
