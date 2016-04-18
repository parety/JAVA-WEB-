package javax.servlet;

import java.io.IOException;

public interface Filter2 {

	/**
	 * web ��������ʱ���ô˷���, ���ڳ�ʼ���� Filter
	 * 
	 * @param config
	 *            ���ԴӸò����л�ȡ��ʼ�������Լ�ServletContext��Ϣ��
	 * @throws ServletException
	 */
	public void init(FilterConfig config) throws ServletException;

	/**
	 * �ͻ����������ʱ�ᾭ��
	 * 
	 * @param request
	 *            �ͻ�����
	 * @param response
	 *            ��������Ӧ
	 * @param chain
	 *            �˾���, ͨ�� chain.doFilter(request, response) �����󴫸��¸� Filter ��
	 *            Servlet
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException;

	/**
	 * web ����ر�ʱ���ô˷���, ��������һЩ��Դ
	 */
	public void destroy();

}
