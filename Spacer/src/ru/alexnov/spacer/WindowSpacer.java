package ru.alexnov.spacer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class WindowSpacer extends JFrame {
	
	String[] models = new String[]{"Бингамовская", "Степенная", "Гершеля-Балкли"};
	//Главная панель
	JPanel mainPanel = new JPanel();
	//Левая и правая панели
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	//Панель графика
	JPanel toprightPanel = new JPanel(new BorderLayout(5, 5));
	//Панель данных по скважине
	JPanel bottomrightPanel = new JPanel();
	JPanel well1 = new JPanel();
	JPanel well11 = new JPanel();
	JPanel well12 = new JPanel();
	JPanel well2 = new JPanel();
	JPanel well21 = new JPanel();
	JPanel well22 = new JPanel();
	JPanel well3 = new JPanel();
	JPanel well31 = new JPanel();
	JPanel well32 = new JPanel();
	JPanel well4 = new JPanel();
	JPanel well41 = new JPanel();
	JPanel well42 = new JPanel();
	JPanel well5 = new JPanel();
	JLabel wl1 = new JLabel("Диаметр скважины, м");
	JTextField dWell = new JTextField();
	JLabel wl2 = new JLabel("Наружный диаметр обсадной колонны, м");
	JTextField dCasing = new JTextField();
	JLabel wl3 = new JLabel("Минимальная производительность, л/с");
	JLabel wl4 = new JLabel("Максимальная производительность, л/с");
	JTextField minFlowRate = new JTextField();
	JTextField maxFlowRate = new JTextField();
	JButton execute = new JButton("Рассчитать");
	//Панель бурового раствора
	JPanel topLPanel = new JPanel();
	JPanel tlp1 = new JPanel();
	JPanel tlp11 = new JPanel();
	JPanel tlp12 = new JPanel();
	JPanel tlp2 = new JPanel();
	JPanel tlp3 = new JPanel();
	JPanel tlp31 = new JPanel();
	JPanel tlp32 = new JPanel();
	JPanel tlp4 = new JPanel();
	JPanel tlp41 = new JPanel();
	JPanel tlp42 = new JPanel();
	JPanel tlp5 = new JPanel();
	JPanel tlp51 = new JPanel();
	JPanel tlp52 = new JPanel();
	JPanel tlp61 = new JPanel();
	JPanel tlp62 = new JPanel();
	JPanel tlp6 = new JPanel();
	JLabel mudw1 = new JLabel("Плотность, кг/м3");
	public JTextField mudWeight = new JTextField();
	JLabel w1 = new JLabel("Реологическая модель");
	JComboBox mudModel = new JComboBox(models);
	JLabel mudv = new JLabel("ПВ, Па*с");
	JTextField mudVisc = new JTextField();
	JLabel mudy = new JLabel("ДНС, Па");
	JTextField mudYeld = new JTextField();
	JLabel mudn = new JLabel("n");
	JTextField mudNfield = new JTextField();
	JLabel mudK = new JLabel("K");
	JTextField mudKfield = new JTextField();
	//панель 1-го буфера
	JPanel med1LPanel = new JPanel();
	JPanel m1lp1 = new JPanel();
	JPanel m1lp11 = new JPanel();
	JPanel m1lp12 = new JPanel();
	JPanel m1lp2 = new JPanel();
	JPanel m1lp3 = new JPanel();
	JPanel m1lp31 = new JPanel();
	JPanel m1lp32 = new JPanel();
	JPanel m1lp4 = new JPanel();
	JPanel m1lp41 = new JPanel();
	JPanel m1lp42 = new JPanel();
	JPanel m1lp5 = new JPanel();
	JPanel m1lp51 = new JPanel();
	JPanel m1lp52 = new JPanel();
	JPanel m1lp6 = new JPanel();
	JPanel m1lp61 = new JPanel();
	JPanel m1lp62 = new JPanel();
	JLabel mudw2 = new JLabel("Плотность");
	JTextField sp1Weight = new JTextField();
	JLabel w2 = new JLabel("Реологическая модель");
	JComboBox sp1Model = new JComboBox(models);
	JLabel sp1v = new JLabel("ПВ, Па*с");
	JTextField sp1Visc = new JTextField();
	JLabel sp1y = new JLabel("ДНС, Па");
	JTextField sp1Yeld = new JTextField();
	JLabel sp1n = new JLabel("n");
	JTextField sp1Nfield = new JTextField();
	JLabel sp1K = new JLabel("K");
	JTextField sp1Kfield = new JTextField();
	//панель 2-го буфера
	JPanel med2LPanel = new JPanel();
	JPanel m2lp1 = new JPanel(new BorderLayout(5, 5));
	JPanel m2lp2 = new JPanel();
	JPanel m2lp3 = new JPanel(new BorderLayout(5, 5));
	JPanel m2lp4 = new JPanel(new BorderLayout(5, 5));
	JPanel m2lp5 = new JPanel(new BorderLayout(5, 5));
	JPanel m2lp6 = new JPanel(new BorderLayout(5, 5));
	JLabel mudw3 = new JLabel("Плотность");
	JTextField sp2Weight = new JTextField();
	JLabel sp2 = new JLabel("Реологическая модель");
	JComboBox sp2Model = new JComboBox(models);
	JLabel sp2v = new JLabel("ПВ, Па*с");
	JTextField sp2Visc = new JTextField();
	JLabel sp2y = new JLabel("ДНС, Па");
	JTextField sp2Yeld = new JTextField();
	JLabel sp2n = new JLabel("n");
	JTextField sp2Nfield = new JTextField();
	JLabel sp2K = new JLabel("K");
	JTextField sp2Kfield = new JTextField();
	//Панель цем. раствора
	JPanel botLPanel = new JPanel();
	JPanel cemp1 = new JPanel(new BorderLayout(5, 5));
	JPanel cemp2 = new JPanel();
	JPanel cemp3 = new JPanel(new BorderLayout(5, 5));
	JPanel cemp4 = new JPanel(new BorderLayout(5, 5));
	JPanel cemp5 = new JPanel(new BorderLayout(5, 5));
	JPanel cemp6 = new JPanel(new BorderLayout(5, 5));
	JLabel mudw4 = new JLabel("Плотность");
	JTextField cemWeight = new JTextField();
	JLabel cem = new JLabel("Реологическая модель");
	JComboBox cemModel = new JComboBox(models);
	JLabel cemv = new JLabel("ПВ, Па*с");
	JTextField cemVisc = new JTextField();
	JLabel cemy = new JLabel("ДНС, Па");
	JTextField cemYeld = new JTextField();
	JLabel cemn = new JLabel("n");
	JTextField cemNfield = new JTextField();
	JLabel cemK = new JLabel("K");
	JTextField cemKfield = new JTextField();
	//Обрамление
	Border border1 = BorderFactory.createTitledBorder("Буровой раствор");
	Border border2 = BorderFactory.createTitledBorder("Буфер 1");
	Border border3 = BorderFactory.createTitledBorder("Буфер 2");
	Border border4 = BorderFactory.createTitledBorder("Цементный раствор");
	Border border5 = BorderFactory.createTitledBorder("Данные по скважине");
	
	public WindowSpacer(){
		super("Реологическая иерархия");
		
		//Данные для графика
		XYSeries series = new XYSeries("Потери давления в затрубном пространстве");
		for (float i=0; i<Math.PI; i+=0.1){
			series.add(i, Math.sin(i));
		}
		XYDataset xyDataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart("Реологическая иерархия", "x", "y", xyDataset, PlotOrientation.VERTICAL, true, true, true);
		ChartPanel graph = new ChartPanel(chart);
		graph.setMinimumDrawHeight(0);
		graph.setMinimumDrawWidth(0);
		graph.setMaximumDrawHeight(1200);
		graph.setMaximumDrawWidth(1920);
		
		//Разметка панелей
		mudWeight.setPreferredSize(new Dimension(50, 20));
		mudVisc.setPreferredSize(new Dimension(50, 20));
		mudYeld.setPreferredSize(new Dimension(50, 20));
		mudNfield.setPreferredSize(new Dimension(50, 20));
		mudKfield.setPreferredSize(new Dimension(50, 20));
		sp1Weight.setPreferredSize(new Dimension(50, 20));
		sp1Visc.setPreferredSize(new Dimension(50, 20));
		sp1Yeld.setPreferredSize(new Dimension(50, 20));
		sp1Nfield.setPreferredSize(new Dimension(50, 20));
		sp1Kfield.setPreferredSize(new Dimension(50, 20));
		sp2Weight.setPreferredSize(new Dimension(50, 20));
		sp2Visc.setPreferredSize(new Dimension(50, 20));
		sp2Yeld.setPreferredSize(new Dimension(50, 20));
		sp2Nfield.setPreferredSize(new Dimension(50, 20));
		sp2Kfield.setPreferredSize(new Dimension(50, 20));
		cemWeight.setPreferredSize(new Dimension(50, 20));
		cemVisc.setPreferredSize(new Dimension(50, 20));
		cemYeld.setPreferredSize(new Dimension(50, 20));
		cemNfield.setPreferredSize(new Dimension(50, 20));
		cemKfield.setPreferredSize(new Dimension(50, 20));
		cemWeight.setPreferredSize(new Dimension(50, 20));
		dWell.setPreferredSize(new Dimension(60, 20));
		dCasing.setPreferredSize(new Dimension(60, 20));
		minFlowRate.setPreferredSize(new Dimension(60, 20));
		maxFlowRate.setPreferredSize(new Dimension(60, 20));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		topLPanel.setLayout(new BoxLayout(topLPanel, BoxLayout.Y_AXIS));
		med1LPanel.setLayout(new BoxLayout(med1LPanel, BoxLayout.Y_AXIS));
		med2LPanel.setLayout(new BoxLayout(med2LPanel, BoxLayout.Y_AXIS));
		botLPanel.setLayout(new BoxLayout(botLPanel, BoxLayout.Y_AXIS));
		bottomrightPanel.setLayout(new BoxLayout(bottomrightPanel, BoxLayout.Y_AXIS));
		tlp1.setLayout(new BoxLayout(tlp1, BoxLayout.X_AXIS));
		tlp11.setLayout(new FlowLayout(FlowLayout.LEFT));
		tlp12.setLayout(new FlowLayout(FlowLayout.RIGHT));
		tlp3.setLayout(new BoxLayout(tlp3, BoxLayout.X_AXIS));
		tlp31.setLayout(new FlowLayout(FlowLayout.LEFT));
		tlp32.setLayout(new FlowLayout(FlowLayout.RIGHT));
		tlp4.setLayout(new BoxLayout(tlp4, BoxLayout.X_AXIS));
		tlp41.setLayout(new FlowLayout(FlowLayout.LEFT));
		tlp42.setLayout(new FlowLayout(FlowLayout.RIGHT));
		tlp5.setLayout(new BoxLayout(tlp5, BoxLayout.X_AXIS));
		tlp51.setLayout(new FlowLayout(FlowLayout.LEFT));
		tlp52.setLayout(new FlowLayout(FlowLayout.RIGHT));
		tlp6.setLayout(new BoxLayout(tlp6, BoxLayout.X_AXIS));
		tlp61.setLayout(new FlowLayout(FlowLayout.LEFT));
		tlp62.setLayout(new FlowLayout(FlowLayout.RIGHT));
		m1lp1.setLayout(new BoxLayout(m1lp1, BoxLayout.X_AXIS));
		m1lp11.setLayout(new FlowLayout(FlowLayout.LEFT));
		m1lp12.setLayout(new FlowLayout(FlowLayout.RIGHT));
		m1lp3.setLayout(new BoxLayout(m1lp3, BoxLayout.X_AXIS));
		m1lp31.setLayout(new FlowLayout(FlowLayout.LEFT));
		m1lp32.setLayout(new FlowLayout(FlowLayout.RIGHT));
		m1lp4.setLayout(new BoxLayout(m1lp4, BoxLayout.X_AXIS));
		m1lp41.setLayout(new FlowLayout(FlowLayout.LEFT));
		m1lp42.setLayout(new FlowLayout(FlowLayout.RIGHT));
		m1lp5.setLayout(new BoxLayout(m1lp5, BoxLayout.X_AXIS));
		m1lp51.setLayout(new FlowLayout(FlowLayout.LEFT));
		m1lp52.setLayout(new FlowLayout(FlowLayout.RIGHT));
		m1lp6.setLayout(new BoxLayout(m1lp6, BoxLayout.X_AXIS));
		m1lp61.setLayout(new FlowLayout(FlowLayout.LEFT));
		m1lp62.setLayout(new FlowLayout(FlowLayout.RIGHT));
		well1.setLayout(new BoxLayout(well1, BoxLayout.X_AXIS));
		well11.setLayout(new FlowLayout(FlowLayout.LEFT));
		well12.setLayout(new FlowLayout(FlowLayout.RIGHT));
		well2.setLayout(new BoxLayout(well2, BoxLayout.X_AXIS));
		well21.setLayout(new FlowLayout(FlowLayout.LEFT));
		well22.setLayout(new FlowLayout(FlowLayout.RIGHT));
		well3.setLayout(new BoxLayout(well3, BoxLayout.X_AXIS));
		well31.setLayout(new FlowLayout(FlowLayout.LEFT));
		well32.setLayout(new FlowLayout(FlowLayout.RIGHT));
		well4.setLayout(new BoxLayout(well4, BoxLayout.X_AXIS));
		well41.setLayout(new FlowLayout(FlowLayout.LEFT));
		well42.setLayout(new FlowLayout(FlowLayout.RIGHT));
		topLPanel.setBorder(border1);
		med1LPanel.setBorder(border2);
		med2LPanel.setBorder(border3);
		botLPanel.setBorder(border4);
		bottomrightPanel.setBorder(border5);
		//Сборка панели бурового раствора
		tlp11.add(mudw1);
		tlp12.add(mudWeight);
		tlp1.add(tlp11);
		tlp1.add(tlp12);
		tlp2.add(w1);
		tlp2.add(mudModel);
		tlp31.add(mudv);
		tlp32.add(mudVisc);
		tlp3.add(tlp31);
		tlp3.add(tlp32);
		tlp41.add(mudy);
		tlp42.add(mudYeld);
		tlp4.add(tlp41);
		tlp4.add(tlp42);
		tlp51.add(mudn);
		tlp52.add(mudNfield);
		tlp5.add(tlp51);
		tlp5.add(tlp52);
		tlp61.add(mudK);
		tlp62.add(mudKfield);
		tlp6.add(tlp61);
		tlp6.add(tlp62);
		topLPanel.add(tlp1);
		topLPanel.add(tlp2);
		topLPanel.add(tlp3);
		topLPanel.add(tlp4);
		topLPanel.add(tlp5);
		topLPanel.add(tlp6);
		//Сборка панели 1-го буфера
		m1lp11.add(mudw2);
		m1lp12.add(sp1Weight);
		m1lp1.add(m1lp11);
		m1lp1.add(m1lp12);
		m1lp2.add(w2);
		m1lp2.add(sp1Model);
		m1lp31.add(sp1v);
		m1lp32.add(sp1Visc);
		m1lp3.add(m1lp31);
		m1lp3.add(m1lp32);
		m1lp41.add(sp1y);
		m1lp42.add(sp1Yeld);
		m1lp4.add(m1lp41);
		m1lp4.add(m1lp42);
		m1lp51.add(sp1n);
		m1lp52.add(sp1Nfield);
		m1lp5.add(m1lp51);
		m1lp5.add(m1lp52);
		m1lp61.add(sp1K);
		m1lp62.add(sp1Kfield);
		m1lp6.add(m1lp61);
		m1lp6.add(m1lp62);
		med1LPanel.add(m1lp1);
		med1LPanel.add(m1lp2);
		med1LPanel.add(m1lp3);
		med1LPanel.add(m1lp4);
		med1LPanel.add(m1lp5);
		med1LPanel.add(m1lp6);
		//Сборка панели 2-го буфера
		m2lp1.add(mudw3, BorderLayout.WEST);
		m2lp1.add(sp2Weight, BorderLayout.EAST);
		m2lp2.add(sp2);
		m2lp2.add(sp2Model);
		m2lp3.add(sp2v, BorderLayout.WEST);
		m2lp3.add(sp2Visc, BorderLayout.EAST);
		m2lp4.add(sp2y, BorderLayout.WEST);
		m2lp4.add(sp2Yeld, BorderLayout.EAST);
		m2lp5.add(sp2n, BorderLayout.WEST);
		m2lp5.add(sp2Nfield, BorderLayout.EAST);
		m2lp6.add(sp2K, BorderLayout.WEST);
		m2lp6.add(sp2Kfield, BorderLayout.EAST);
		med2LPanel.add(m2lp1);
		med2LPanel.add(m2lp2);
		med2LPanel.add(m2lp3);
		med2LPanel.add(m2lp4);
		med2LPanel.add(m2lp5);
		med2LPanel.add(m2lp6);
		//Сборка панели цем. раствора
		cemp1.add(mudw4, BorderLayout.WEST);
		cemp1.add(cemWeight, BorderLayout.EAST);
		cemp2.add(cem);
		cemp2.add(cemModel);
		cemp3.add(cemv, BorderLayout.WEST);
		cemp3.add(cemVisc, BorderLayout.EAST);
		cemp4.add(cemy, BorderLayout.WEST);
		cemp4.add(cemYeld, BorderLayout.EAST);
		cemp5.add(cemn, BorderLayout.WEST);
		cemp5.add(cemNfield, BorderLayout.EAST);
		cemp6.add(cemK, BorderLayout.WEST);
		cemp6.add(cemKfield, BorderLayout.EAST);
		botLPanel.add(cemp1);
		botLPanel.add(cemp2);
		botLPanel.add(cemp3);
		botLPanel.add(cemp4);
		botLPanel.add(cemp5);
		botLPanel.add(cemp6);
		//Сборка панели данных по скважине
		well11.add(wl1);
		well12.add(dWell);
		well1.add(well11);
		well1.add(well12);
		well21.add(wl2);
		well22.add(dCasing);
		well2.add(well21);
		well2.add(well22);
		well31.add(wl3);
		well32.add(minFlowRate);
		well3.add(well31);
		well3.add(well32);
		well41.add(wl4);
		well42.add(maxFlowRate);
		well4.add(well41);
		well4.add(well42);
		well5.add(execute);
		bottomrightPanel.add(well1);
		bottomrightPanel.add(well2);
		bottomrightPanel.add(well3);
		bottomrightPanel.add(well4);
		bottomrightPanel.add(well5);
		//Сборка главных панелей
		leftPanel.add(topLPanel);
		leftPanel.add(med1LPanel);
		leftPanel.add(med2LPanel);
		leftPanel.add(botLPanel);
		toprightPanel.add(graph);
		rightPanel.add(toprightPanel);
		rightPanel.add(bottomrightPanel);
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		
		String f1 = "mudw";
		String f2 = "mudv";
		String f3 = "mudy";
		String f4 = "mudn";
		String f5 = "mudk";
		//Метки для идентификации полей в обработчике
		mudWeight.getDocument().putProperty("owner", f1);
		mudVisc.getDocument().putProperty("owner", f2);
		mudYeld.getDocument().putProperty("owner", f3);
		mudNfield.getDocument().putProperty("owner", f4);
		mudKfield.getDocument().putProperty("owner", f5);
		//Добавляем слушатели
		mudWeight.getDocument().addDocumentListener(isNumListener);
		mudVisc.getDocument().addDocumentListener(isNumListener);
		mudYeld.getDocument().addDocumentListener(isNumListener);
		mudNfield.getDocument().addDocumentListener(isNumListener);
		mudKfield.getDocument().addDocumentListener(isNumListener);
		
		//Разметка главной панели
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		JScrollPane scroll = new JScrollPane(mainPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 700);
		getContentPane().add(scroll);
		//setVisible(true);
	}
	//При вводе или удалении с клавиатуры проверяем, является ли строка числом	
	IsNumericDocListener isNumListener = new IsNumericDocListener();
	
	
	
	/**
	 * @param args
	 */
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	WindowSpacer win = new WindowSpacer();
//	}

}
