package ru.alexnov.cementingquality;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.poi.hwpf.HWPFDocument;

public class Window extends JFrame {
	
	Container c = getContentPane();
	HWPFDocument aks = null;
	static JPanel panel = new JPanel();
	JPanel panel01 = new JPanel();
	JPanel panel02 = new JPanel();
	JLabel field1 = new JLabel();
	JLabel field2 = new JLabel();
	JMenuBar menu = new JMenuBar();
	JMenu fileMenu = new JMenu("Файл");
	JMenu aboutMenu = new JMenu("Помощь");
	JMenuItem aboutItem = new JMenuItem("О программе");
	JMenuItem saveasItem = new JMenuItem("Сохранить как...");
	
	//Обрабатываем нажатие кнопки
	private void loadFileActionPerformed(ActionEvent e){
		aks = HandleButton.readFile();
		field1.setText("файл успешно прочитан");
	}
	
	public Window(){
		super("Magic GGK");
		JButton loadFile = new JButton("Загрузи АКЦшку");
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel01.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel02.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel01.add(loadFile);
		panel02.add(field1);
		panel02.add(field2);
		panel.add(panel01);
		panel.add(panel02);
		fileMenu.add(saveasItem);
		aboutMenu.add(aboutItem);
		menu.add(fileMenu);
		menu.add(aboutMenu);
		c.add(panel);
		setJMenuBar(menu);
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//Добавляем слушатель к кнопке
		loadFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				loadFileActionPerformed(e);
			}
		});
		//Меню о программе
		aboutItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				About ab = new About();
				ab.setLocationRelativeTo(c);
				ab.setVisible(true);
				ab.setSize(new Dimension(200, 100));
				ab.setResizable(false);
			}
		});
		
		//Меню сохранить как
		saveasItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				HandleButton.saveFile(aks);
			}
		});
	}
	
	public static void main(String[] args){
		new Window();
	}

}
