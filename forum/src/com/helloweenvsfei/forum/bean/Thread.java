package com.helloweenvsfei.forum.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@org.hibernate.annotations.Entity
public class Thread extends BaseBean {

	@ManyToOne
	@JoinColumn(name = "board_id")
	private Board board;

	private String title;

	@Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition="longtext")
	private String content;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Person author;

	private String ipCreated;

	private int hit;

	@ManyToOne
	@JoinColumn(name = "author_last_replied_id")
	private Person authorLastReplied;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLastReplied;

	private boolean readonly;

	private boolean topped;

	private int replyCount;

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public Person getAuthorLastReplied() {
		return authorLastReplied;
	}

	public void setAuthorLastReplied(Person authorLastReplied) {
		this.authorLastReplied = authorLastReplied;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateLastReplied() {
		return dateLastReplied;
	}

	public void setDateLastReplied(Date dateLastReplied) {
		this.dateLastReplied = dateLastReplied;
	}

	public String getIpCreated() {
		return ipCreated;
	}

	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isTopped() {
		return topped;
	}

	public void setTopped(boolean topped) {
		this.topped = topped;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

}
