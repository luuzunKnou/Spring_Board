package com.luuzun.dgit.domain;

import java.util.Date;

public class ReplyVO {
	private Integer rno;
	private Integer bno;
	private String replytext;
	private String replyer;
	private Date regdate;
	private Date updatedate;
	
	public ReplyVO() {}
	
	public ReplyVO(Integer rno, Integer bno, String replytext, String replyer, Date updatedate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.replytext = replytext;
		this.replyer = replyer;
		this.updatedate = updatedate;
	}

	public ReplyVO(Integer bno, String replytext, String replyer) {
		super();
		this.bno = bno;
		this.replytext = replytext;
		this.replyer = replyer;
	}

	public ReplyVO(Integer rno, Integer bno, String replytext, String replyer, Date regdate, Date updatedate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.replytext = replytext;
		this.replyer = replyer;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return String.format("ReplyVO [rno=%s, bno=%s, replytext=%s, replyer=%s, regdate=%s, updatedate=%s] \n", rno, bno,
				replytext, replyer, regdate, updatedate);
	}

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
}
