package com.helloweenvsfei.forum.struts.interceptor;

import java.lang.reflect.Method;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.springframework.aop.MethodBeforeAdvice;

import com.helloweenvsfei.forum.struts.action.BoardAction;
import com.helloweenvsfei.forum.struts.action.CategoryAction;
import com.helloweenvsfei.forum.struts.action.ForumAction;
import com.helloweenvsfei.forum.struts.action.PersonAction;
import com.helloweenvsfei.forum.struts.action.ReplyAction;
import com.helloweenvsfei.forum.struts.action.ThreadAction;
import com.helloweenvsfei.forum.struts.form.ForumForm;
import com.helloweenvsfei.forum.struts.util.PersonUtil;

public class LoginInterceptor implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object instance)
			throws Throwable {

		ActionMapping mapping = (ActionMapping) args[0];
		ActionForm form = (ActionForm) args[1];
		HttpServletRequest request = (HttpServletRequest) args[2];
		HttpServletResponse response = (HttpServletResponse) args[3];

		ForumAction forumAction = (ForumAction) instance;
		ForumForm forumForm = (ForumForm) form;

		boolean needsCheck = false;

		if (forumAction instanceof PersonAction) {

		} else if (forumAction instanceof CategoryAction
				|| forumAction instanceof BoardAction
				|| forumAction instanceof ThreadAction
				|| forumAction instanceof ReplyAction) {

			if ("initAdd".equals(forumForm.getAction())
					|| "add".equals(forumForm.getAction())) {

				needsCheck = true;
			}
		}

		if (needsCheck && PersonUtil.getPersonInfo(request, response) == null)
			throw new AccountException("您还没有登录");

	}
}
