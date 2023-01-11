package xueshe.com.model;

import java.io.Serializable;

public class StudentClub implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Sno;
	private String Clno;
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getClno() {
		return Clno;
	}
	public void setClno(String clno) {
		Clno = clno;
	}
}
