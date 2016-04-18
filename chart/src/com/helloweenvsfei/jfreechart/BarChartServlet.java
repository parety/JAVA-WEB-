package com.helloweenvsfei.jfreechart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartServlet extends HttpServlet {

	private static final long serialVersionUID = 227116552657325813L;

	public BarChartServlet() {
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
		CategoryDataset dataset = createDataset();
		// 创建图形对象
		JFreeChart jfreechart = ChartFactory.createBarChart3D("08年图书销售量排名",
				"按季度", "销量", dataset, PlotOrientation.VERTICAL, true, true,
				false);
		// 获得图表区域对象
		CategoryPlot categoryPlot = (CategoryPlot) jfreechart.getPlot();
		// 设置网格线可见
		categoryPlot.setDomainGridlinesVisible(true);
		// 获得x轴对象
		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		// 设置x轴显示的分类名称的显示位置，如果不设置则水平显示
		// 设置后，可以斜像显示，但分类角度，图表空间有限时，建议采用
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions
				.createUpRotationLabelPositions(0.39269908169872414D));
		categoryAxis.setCategoryMargin(0.0D);
		// 获显示图形对象
		BarRenderer3D barRenderer3d = (BarRenderer3D) categoryPlot
				.getRenderer();
		// 设置不显示边框线
		barRenderer3d.setDrawBarOutline(false);
		// 将图表已数据流的方式返回给客户端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,
				500, 270);
	}

	/**
	 * 返回数据集
	 * 
	 * @return
	 */
	private static CategoryDataset createDataset() {
		// 时间维度
		String[] category1 = { "第一季度", "第二季度", "第三季度", "第四季度" };
		// 分类维度
		String[] category2 = { "JAVA", "C/C++", "PHP" };
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for (int i = 0; i < category1.length; i++) {
			String category = category1[i];
			for (int j = 0; j < category2.length; j++) {
				String cat = category2[j];
				// 模拟添加数据
				defaultdataset.addValue(DataUtils.getRandomData(), cat, category);
			}
		}
		return defaultdataset;
	}

}
