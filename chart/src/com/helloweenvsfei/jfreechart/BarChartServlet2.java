package com.helloweenvsfei.jfreechart;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class BarChartServlet2 extends HttpServlet {

	private static final long serialVersionUID = 935480272440185396L;

	public BarChartServlet2() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置返回类型为图片
		response.setContentType("image/png");
		// 获取数据集对象
		IntervalXYDataset dataset = createDataset();
		// 创建图形对象
		JFreeChart jfreechart = ChartFactory.createXYBarChart("08年图书销售量", null,
				false, "销量", dataset, PlotOrientation.VERTICAL, true, false,
				false);
		// 设置背景为白色
		jfreechart.setBackgroundPaint(Color.white);
		// 获得图表区域对象
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		// 设置区域对象背景为灰色
		xyplot.setBackgroundPaint(Color.lightGray);
		// 设置区域对象网格线调为白色
		xyplot.setDomainGridlinePaint(Color.white);
		xyplot.setRangeGridlinePaint(Color.white);
		// 获显示图形对象
		XYBarRenderer xybarrenderer = (XYBarRenderer) xyplot.getRenderer();
		// 设置不显示边框线
		xybarrenderer.setDrawBarOutline(false);

		// 将图表已数据流的方式返回给客户端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,
				500, 270);
	}

	/**
	 * 返回数据集
	 * 
	 * @return
	 */
	private static IntervalXYDataset createDataset() {
		// 创建基本数据
		XYSeries xyseries = new XYSeries("JAVA");
		XYSeries xyseries1 = new XYSeries("PHP");
		for (int i = 1; i <= 12; i++) {
			// 添加数据
			xyseries.add(i,DataUtils.getRandomData());
			xyseries1.add(i,DataUtils.getRandomData());
		}
		XYSeriesCollection xyseriescollection = new XYSeriesCollection();
		xyseriescollection.addSeries(xyseries);
		xyseriescollection.addSeries(xyseries1);
		return new XYBarDataset(xyseriescollection, 0.90000000000000002D);
	}
}
