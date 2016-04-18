package com.helloweenvsfei.forum.struts.exception;

import javax.security.auth.login.AccountException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

public class ForumExceptionHandler extends ExceptionHandler {

	Logger log = Logger.getLogger(getClass());

	@Override
	public ActionForward execute(Exception exception, ExceptionConfig config,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		request.setAttribute("exception", exception);

		log.info(exception, exception);

		if (exception instanceof AccountException) {
			return new ActionForward("login", "/form/person/login.jsp", false);
		}

		return new ActionForward("exception", "/form/exception.jsp", false);
	}

}
