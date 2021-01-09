package cn.edu.jsu.ll.vo;

public class Grade {
	private String id;
	private String pno;
	private float score;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "编号" + id + "\t项目编号：" + pno + "\t分数：" + score ;
	}
}

