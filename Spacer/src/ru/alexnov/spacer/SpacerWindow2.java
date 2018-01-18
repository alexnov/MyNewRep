package ru.alexnov.spacer;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class SpacerWindow2 extends JFrame {
	
	
	
	public SpacerWindow2(){
		super("Реологиеская иерархия");
		XYSeries series = new XYSeries("sin(a)");
		for (float i=0; i<Math.PI; i+=0.1){
			series.add(i, Math.sin(i));
		}
		XYDataset xyDataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart("y=sin(x)", "x", "y", xyDataset, PlotOrientation.VERTICAL, true, true, true);
		Container c = getContentPane();
		ChartPanel panel = new ChartPanel(chart);
		c.setLayout(new BorderLayout()); //менеджер разметки
		c.add(panel, BorderLayout.CENTER);
		setSize(700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args){
		new SpacerWindow2();
	}
}
