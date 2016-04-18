/*
 * 
 */
package com.helloweenvsfei.tags2;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ToUpperCaseTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		// �� ��ǩ�����ݶ���� writer
		StringWriter writer = new StringWriter();

		// ��ǩ�� Ϊ JspFragment ����ʽ
		JspFragment jspFragment = this.getJspBody();
		
		// ͨ�� invoke �����ָ���� writer �С�
		// �������Ϊ null���������Ĭ�ϵ� writer �У��� getJspContext().getOut() �����HTML��
		jspFragment.invoke(writer);

		String content = writer.getBuffer().toString();
		this.getJspContext().getOut().print(content.toUpperCase());
	}

}

// end
