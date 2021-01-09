package cn.edu.jsu.ll.vo;

public class Project {
	private String pname;
	private String pno;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	@Override
	public String toString() {
		return "项目名：" + pname + "\t项目编号：" + pno;
	}
	
}
