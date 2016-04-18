package com.helloweenvsfei.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class ApplicationConstants {

	// ���е� Session
	public static Map<String, HttpSession> SESSION_MAP = new HashMap<String, HttpSession>();

	// ��ǰ��¼���û�����
	public static int CURRENT_LOGIN_COUNT = 0;

	// ��ʷ�ÿ�����
	public static int TOTAL_HISTORY_COUNT = 0;

	// ����������ʱ��
	public static Date START_DATE = new Date();

	// �������ʱ��
	public static Date MAX_ONLINE_COUNT_DATE = new Date();

	// �����������
	public static int MAX_ONLINE_COUNT = 0;
}
