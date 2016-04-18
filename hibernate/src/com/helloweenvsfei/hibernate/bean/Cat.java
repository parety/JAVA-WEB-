package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@NamedQuery(name = "all cat", query = " select c from Cat c ")
//@NamedNativeQuery(name = "all cat", query = "select * from tb_cat")
@NamedQueries(value = {
		@NamedQuery(name = "all cat", query = " select c from Cat c "),
		@NamedQuery(name = "cat by name", query = " select c from Cat c where c.name = :name ", hints = { @QueryHint(name = "org.hibernate.callable", value = "true") }),
		@NamedQuery(name = "cat by mother", query = " select c from Cat c ") })
//@NamedNativeQueries(value = {
//		@NamedNativeQuery(name = "all cat", query = "select * from tb_cat"),
//		@NamedNativeQuery(name = "all cat", query = "select * from tb_cat"),
//		@NamedNativeQuery(name = "all cat", query = "select * from tb_cat") })
@Entity
// ע��Entity��ʾ�����ܱ�Hibernate�־û�
@Table(name = "tb_cat")
// ָ����Entity��Ӧ�����ݱ���
public class Cat {

	@Id
	@Column(name = "id")
	// ָ������Ϊ����
	@GeneratedValue(strategy = GenerationType.AUTO)
	// ��������, autoΪ���ݿ�����������
	private Integer id;

	@Column(name = "name")
	// ָ�����Զ�Ӧ�����ݿ�����Ϊ��name��
	private String name;

	@Column(name = "description")
	// ͬ�ϡ�@Column��name����ʡ��
	private String description;

	@ManyToOne
	// ָ��POJO֮��Ĺ�ϵ������Ϊ���һ��ϵ
	@JoinColumn(name = "mother_id")
	// �����Զ�Ӧ����
	private Cat mother;

	@Temporal(TemporalType.TIMESTAMP)
	// �������ͣ�DATE, TIME����TIMESTEMP��
	@Column(name = "createDate")
	private Date createDate;

	@OneToMany(mappedBy = "cat")
	// @JoinColumns(value = { @JoinColumn(name = "cat_id", referencedColumnName
	// = "id") })
	private List<Event> events = new ArrayList<Event>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cat getMother() {
		return mother;
	}

	public void setMother(Cat mother) {
		this.mother = mother;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
