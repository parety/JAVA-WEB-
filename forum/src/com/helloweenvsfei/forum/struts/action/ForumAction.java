package com.helloweenvsfei.forum.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.helloweenvsfei.forum.struts.form.ForumForm;

public abstract class ForumAction extends DispatchAction {

	protected Log log = LogFactory.getLog(getClass());

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ForumForm forumForm = (ForumForm) form;
		
		forumForm.setTitle("轻量级 Java EE 论坛程序");

		if (forumForm.getAction() == null
				|| forumForm.getAction().trim().length() == 0) {

			return this.list(mapping, form, request, response);
		}

		return super.execute(mapping, form, request, response);
	}

	public abstract ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
