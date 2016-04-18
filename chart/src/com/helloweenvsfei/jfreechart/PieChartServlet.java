package com.helloweenvsfei.jfreechart;

import java.awt.Font;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChartServlet extends HttpServlet {

	private static final long serialVersionUID = -3798298158506030366L;

	public PieChartServlet() {
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
		PieDataset dataset = createPieDataset();
		// 创建图形对象
		JFreeChart jfreechart = ChartFactory.createPieChart3D("08年图书销量排行榜",
				dataset, true, true, false);
		// 获得图表区域对象
		PiePlot pieplot = (PiePlot) jfreechart.getPlot();
		// 设置图表区域的标签字体
		pieplot.setLabelFont(new Font("宋体", 0, 12));
		// 设置图表区域无数据时的默认显示文字
		pieplot.setNoDataMessage("没有销售数据");
		// 设置图表区域不是圆形，由于是3D的饼形图，建议设置为false
		pieplot.setCircular(false);
		// 设置图表区域文字与图表区域的间隔距离，0.02表示2%
		pieplot.setLabelGap(0.02D);
		// 将图表已数据流的方式返回给客户端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,
				500, 270);
	}

	/**
	 * 返回数据集
	 * 
	 * @return
	 */
	private static PieDataset createPieDataset() {
		// 创建饼形图数据集对象
		DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
		// 分别图形区域的说明和数据
		defaultpiedataset.setValue("JAVA", DataUtils.getRandomData());
		defaultpiedataset.setValue("C/C++", DataUtils.getRandomData());
		defaultpiedataset.setValue("PHP", DataUtils.getRandomData());
		defaultpiedataset.setValue("JavaScript", DataUtils.getRandomData());
		defaultpiedataset.setValue("Ajax", DataUtils.getRandomData());
		return defaultpiedataset;
	}

}
