package com.helloweenvsfei.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results(value = { @Result(name = "input", value = "/divNews.jsp") })
public class DivNewsAction extends ActionSupport {

	private static final long serialVersionUID = 6560408661223488775L;

	private static String[] ALL_NEWS = { "�й����ٰ�2008����˻�, ��Ļʽ���� 2008��8��8��",
			"��ˮ������, ��һ���˽�������������ǰ����", "�϶�̽�����ǳɹ���������", "�������ź�����ɴ�ʤ������",
			"�й�A�ɹ��г�������", };

	private String key;

	private List<String> news = new ArrayList<String>();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String execute() {

		if (key == null)
			key = "";

		for (String n : ALL_NEWS) {
			if (n.contains(key)) {
				news.add(n);
			}
		}

		return INPUT;
	}

	public List<String> getNews() {
		return news;
	}

	public void setNews(List<String> news) {
		this.news = news;
	}

}
