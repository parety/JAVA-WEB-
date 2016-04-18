package com.helloweenvsfei.struts.exceptionhandler;

import javax.security.auth.login.AccountException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.config.ExceptionConfig;

public class AccountExceptionHandler extends
		org.apache.struts.action.ExceptionHandler {

	@Override
	public ActionForward execute(Exception exception, ExceptionConfig config,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		if (exception instanceof AccountException) {
			return mapping.findForward("login");
		}

		return super.execute(exception, config, mapping, form, request,
				response);
	}

}
