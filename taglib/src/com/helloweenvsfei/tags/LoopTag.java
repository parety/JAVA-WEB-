/*
 * 
 */
package com.helloweenvsfei.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class LoopTag extends BodyTagSupport {

	private static final long serialVersionUID = 5882067091737658241L;

	private int times;

	@Override
	public int doStartTag() throws JspException {
		times = 5;
		return super.doStartTag();
	}

	@Override
	public int doAfterBody() throws JspException {

		if (times-- > 0) {

			/** ֻҪ times > 0 �ͼ���ѭ����ͬʱ times �Լ� */
			try {
				this.getPreviousOut()
						.println(this.getBodyContent().getString());

			} catch (Exception e) {
			}

			return EVAL_BODY_AGAIN;

		} else {

			/** �������У�ͬʱ��ԭ times */

			times = 5;

			return SKIP_BODY;
		}
	}

}

// end
