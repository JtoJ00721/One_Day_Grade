package com.biz.grade.vo;

public class ScoreVO {
	private String scoreNum = "";
	private int kor = 0;
	private int eng = 0;
	private int math = 0;
	private int music = 0;
	private int sum = 0;
	private int avg = 0;
	
	public String getScoreNum() {
		return scoreNum;
	}
	public void setScoreNum(String scoreNum) {
		this.scoreNum = scoreNum;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getMusic() {
		return music;
	}
	public void setMusic(int music) {
		this.music = music;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
}
