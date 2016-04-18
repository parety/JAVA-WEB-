package javax.servlet;

import java.io.IOException;

public interface Filter2 {

	/**
	 * web 程序启动时调用此方法, 用于初始化该 Filter
	 * 
	 * @param config
	 *            可以从该参数中获取初始化参数以及ServletContext信息等
	 * @throws ServletException
	 */
	public void init(FilterConfig config) throws ServletException;

	/**
	 * 客户请求服务器时会经过
	 * 
	 * @param request
	 *            客户请求
	 * @param response
	 *            服务器响应
	 * @param chain
	 *            滤镜链, 通过 chain.doFilter(request, response) 将请求传给下个 Filter 或
	 *            Servlet
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException;

	/**
	 * web 程序关闭时调用此方法, 用于销毁一些资源
	 */
	public void destroy();

}
