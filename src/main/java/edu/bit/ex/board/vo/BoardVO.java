package edu.bit.ex.board.vo;

import java.sql.Timestamp;

public class BoardVO {
	private int iId;
	private String iName;
	private String iTitle;
	private String iContent;
	private Timestamp iDate;
	private int iHit;
	private int iGroup;
	private int iStep;
	private int iIndent;
	

	public BoardVO() {
		
	}

	public BoardVO(int iId, String iName, String iTitle, String iContent, Timestamp iDate, int iHit, int iGroup,
			int iStep, int iIndent) {
		
		this.iId = iId;
		this.iName = iName;
		this.iTitle = iTitle;
		this.iContent = iContent;
		this.iDate = iDate;
		this.iHit = iHit;
		this.iGroup = iGroup;
		this.iStep = iStep;
		this.iIndent = iIndent;
	}

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiTitle() {
		return iTitle;
	}

	public void setiTitle(String iTitle) {
		this.iTitle = iTitle;
	}

	public String getiContent() {
		return iContent;
	}

	public void setiContent(String iContent) {
		this.iContent = iContent;
	}

	public Timestamp getiDate() {
		return iDate;
	}

	public void setiDate(Timestamp iDate) {
		this.iDate = iDate;
	}

	public int getiHit() {
		return iHit;
	}

	public void setiHit(int iHit) {
		this.iHit = iHit;
	}

	public int getiGroup() {
		return iGroup;
	}

	public void setiGroup(int iGroup) {
		this.iGroup = iGroup;
	}

	public int getiStep() {
		return iStep;
	}

	public void setiStep(int iStep) {
		this.iStep = iStep;
	}

	public int getiIndent() {
		return iIndent;
	}

	public void setiIndent(int iIndent) {
		this.iIndent = iIndent;
	}
	   
		
		
	   
}
