package ru.alexnov.thermal;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class ThermalMainWindow extends JFrame {
	
	JTabbedPane tabPanel = new JTabbedPane();
	JScrollPane scroll1 = new JScrollPane();
	JScrollPane scroll2 = new JScrollPane();
	JPanel geolPanel = new JPanel();
	JPanel boxPanel[] = new JPanel[13];
	JPanel boxPanelLeft[] = new JPanel[13];
	JPanel boxPanelRight[] = new JPanel[13];
	
	ThermalMainWindow(){
		super("Расчет теплопроводности цементного камня");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(620, 300);
		
		geolPanel.setLayout(new BoxLayout(geolPanel, BoxLayout.Y_AXIS));
		
		for (int i=0; i<13; i++){
			boxPanel[i].setLayout(new BoxLayout(boxPanel[i], BoxLayout.X_AXIS));
		}
		
		tabPanel.addTab("Геологические данные", scroll1);
		tabPanel.addTab("Конструкция скважины", scroll2);
		
		setContentPane(tabPanel);
		
	} 
}
