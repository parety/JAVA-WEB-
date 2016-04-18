package com.helloweenvsfei.filter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.helloweenvsfei.exception.AccountException;

public class PrivilegeFilter implements Filter {

	private Properties pp = new Properties();

	public void init(FilterConfig config) throws ServletException {

		// �� ��ʼ������ �л�ȡȨ �������ļ� ��λ��
		String file = config.getInitParameter("file");
		String realPath = config.getServletContext().getRealPath(file);
		try {
			pp.load(new FileInputStream(realPath));
		} catch (Exception e) {
			config.getServletContext().log("��ȡȨ�޿����ļ�ʧ�ܡ�", e);
		}
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;

		// ��ȡ���ʵ�·�������磺admin.jsp
		String requestURI = request.getRequestURI().replace(
				request.getContextPath() + "/", "");

		// ��ȡ action ���������磺add
		String action = req.getParameter("action");
		action = action == null ? "" : action;

		// ƴ�ӳ� URI�����磺log.do?action=list
		String uri = requestURI + "?action=" + action;

		// �� session �л�ȡ�û�Ȩ�޽�ɫ��
		String role = (String) request.getSession(true).getAttribute("role");
		role = role == null ? "guest" : role;

		boolean authentificated = false;
		// ��ʼ�����û���ɫ�Ƿ���Ȩ�޷��� uri
		for (Object obj : pp.keySet()) {
			String key = ((String) obj);
			// ʹ��������ʽ��֤ ��Ҫ�� ? . �滻һ�£�����ͨ��� * ����һ��
			if (uri.matches(key.replace("?", "\\?").replace(".", "\\.")
					.replace("*", ".*"))) {
				// ��� role ƥ��
				if (role.equals(pp.get(key))) {
					authentificated = true;
					break;
				}
			}
		}
		if (!authentificated) {
			throw new RuntimeException(new AccountException(
					"����Ȩ���ʸ�ҳ�档���Ժ��ʵ���ݵ�½��鿴��"));
		}
		// ��������
		chain.doFilter(req, res);
	}

	public void destroy() {
		pp = null;
	}
}
