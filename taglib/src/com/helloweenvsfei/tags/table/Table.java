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
package com.helloweenvsfei.tags.table;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Table extends BodyTagSupport
{
    private static final long         serialVersionUID = 3358444196409845360L;

    /** �洢����Ϣ */
    private List<Map<String, String>> columns          = new ArrayList<Map<String, String>>();

    /** �洢���ݣ�����Ϊ �������͵Ļ����������͵� */
    private Object                    items;

    /** ȡ�������ݵ� URL */
    private String                    url;

    @Override
    public int doStartTag()
            throws JspException
    {
        columns.clear();
        
        return super.doStartTag();
    }

    @Override
    @SuppressWarnings("unchecked")
    public int doAfterBody()
            throws JspException
    {
        try{
            BodyContent bc = getBodyContent();
            JspWriter out = bc.getEnclosingWriter();

            HttpServletRequest request = (HttpServletRequest) pageContext
                    .getRequest();

            /** ����һ������ */
            String orderName = request.getParameter("orderName");
            /** �������ǽ������� */
            String orderType = request.getParameter("orderType");

            orderType = "desc".equals(orderType) ? "desc" : "asc";

            out.println("<table id=theObjTable");
            out.println("   class=list_table STYLE='table-layout:fixed;' >");
            out.println("   <tr class=tr_title>");
            out.println("   <script>var columns = []; </script>");

            for (int i = 0; i < columns.size(); i++){
            	/** ��ȡ����Ϣ */
                Map<String, String> column = columns.get(i);

                /** ��ͷ */
                String label = column.get("label");
                /** ���ж�Ӧ�� Java Bean ������ */
                String property = column.get("property");

                label = label == null ? property : label;

                out.println("<td id='__id_td_" + property + "'>");
                out.println("<font class='resizeDivClass'");
                out.println("   onmousedown='MouseDownToResize(this);');");
                out.println("   onmousemove='MouseMoveToResize(this);'");
                out.println("   onmouseup='MouseUpToResize(this);'></font>");

                out.println("<span onclick=\"sort('" + property + "'); \"");
                out.println(" style=\"cursor: pointer; \">");

                out.println(label);

                if (property.equals(orderName)){
                	
                    out.println("<img src='images/" + orderType
                            + ".gif' border=0/>");
                }

                out.println("</span>");

                out.println("</td>");
                out.println("<script>columns[columns.length] = '__id_td_" + property + "'; </script>");
            }

            out.println("   </tr>");

            if (items != null){
            	
            	/** �������е����� */
                for (Object obj : (Iterable) items) {
                	
                    out.println("   <tr class=tr_data>");
                    
                    for (int i = 0; i < columns.size(); i++){
                    	
                        Map<String, String> column = columns.get(i);

                        String property = column.get("property");

                        String getterStyle = toGetterStyle(property);

                        try{
                            String getter = "get" + getterStyle;
                            String is = "is" + getterStyle;

                            Method method = null;

                            try{
                            	/** ��ȡ getXxx() ��ʽ�ķ��� */
                                method = obj.getClass().getMethod(getter);
                            }
                            catch (Exception e){}

                            if (method == null){
                            	/** ���û�У���ȡ isXxx() ��ʽ�ķ��� */
                                method = obj.getClass().getMethod(is);
                            }

                            method.setAccessible(true);

                            /** ��ȡ����ֵ */
                            Object value = method.invoke(obj);
                            out.println("<td><span title='" + value + "'>" + value + "</span></td>");

                        }
                        catch (Exception e)
                        {
                            throw new JspException(e);
                        }
                    }
                    out.println("   </tr>");
                }
            }

            out.println("</table>");

            out.println("<script>");
            out.println("   var orderName = '" + orderName + "'; ");
            out.println("   var orderType = '" + orderType + "'; ");
            out.println("   function sort(column){");
            out.println("       if(orderName == column){");
            out.println("           location='" + url + "?orderName=' + column + '&orderType=' + (orderType=='asc' ? 'desc' : 'asc'); ");
            out.println("       }");
            out.println("       else{");
            out.println("           location='" + url + "?orderName=' + column + '&orderType=' + orderType; ");
            out.println("       }");
            out.println("   }");
            out.println("</script>");

        }
        catch (IOException ioe)
        {
            throw new JspException("Error: " + ioe.getMessage());
        }

        return SKIP_BODY;
    }

    public Object getItems()
    {
        return items;
    }

    public void setItems(Object items)
    {
        this.items = items;
    }

    /**
     * ����ĸ��д
     * @param column
     * @return
     */
    public String toGetterStyle(String column)
    {
        if (column.length() == 1)
            return column.toUpperCase();

        char ch = column.charAt(0);

        return Character.toUpperCase(ch) + column.substring(1);

    }

    public List<Map<String, String>> getColumns()
    {
        return columns;
    }

    public void setColumns(List<Map<String, String>> columns)
    {
        this.columns = columns;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

}
