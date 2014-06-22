package model.zjc;

import java.util.Date;

/**
 * MessageBox entity. @author MyEclipse Persistence Tools
 */

public class MessageBox implements java.io.Serializable {

	// Fields

	private long MId;
	private String content;
	private Date writeDate;

	// Constructors

	/** default constructor */
	public MessageBox() {
	}

	/** full constructor */
	public MessageBox(String content, Date writeDate) {
		this.content = content;
		this.writeDate = writeDate;
	}

	// Property accessors

	public long getMId() {
		return this.MId;
	}

	public void setMId(long MId) {
		this.MId = MId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "MessageBox [MId=" + MId + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}

}