/*
 * IBM Confidential
 * 
 * OCO Source Materials
 * 
 * #ID# IBM CRL Supply Chain Management Research
 * 
 * (C) Copyright IBM Corp. 2005, 2006
 * 
 * The source code for this program is not published or otherwise divested of
 * its trade secrets.
 * 
 */
package com.helloweenvsfei.tags;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Copyright2 extends TagSupport
{

    private static final long serialVersionUID = -2936770589554413334L;

    @Override
    public int doEndTag()
            throws JspException
    {
        JspWriter out = pageContext.getOut();

        try
        {
            out.println("<div align=center style='line-height: 22px; font-size: 12px; '>");
            out.println(ResourceBundle.getBundle("copyright").getString("copyright"));
            out.println("</div>");
        }
        catch (IOException e)
        {
            throw new JspException(e);
        }

        return EVAL_PAGE;
    }

    @Override
    public int doStartTag()
            throws JspException
    {
        return super.doStartTag();
    }

}

// end
