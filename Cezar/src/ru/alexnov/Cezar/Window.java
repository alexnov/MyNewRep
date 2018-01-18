package ru.alexnov.Cezar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane tabPanel = new JTabbedPane();
	JPanel panel1 = new JPanel();
	JPanel panel01 = new JPanel();
	JPanel panel02 = new JPanel();
	JPanel panel03 = new JPanel();
	JPanel panel04 = new JPanel();
	JPanel panel001 = new JPanel();
	JPanel panel002 = new JPanel();
	JButton crypt = new JButton("Зашифровать");
	JLabel lab1 = new JLabel("Сдвиг");
	JLabel lab2 = new JLabel("Исходный текст");
	JLabel lab3 = new JLabel("Шифр");
	JTextField shear = new JTextField("3");
	JTextArea source = new JTextArea();
	JTextArea cypher = new JTextArea();
	
	private void cryptActionPerformed(ActionEvent e){
		String sl = shear.getText();
		int slide = Integer.parseInt(sl);
		cypher.setText(Cezar.cezarCypher(source.getText(), slide));
	}
	
	public Window(){
		super("Шифрование");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel01.setLayout(new BoxLayout(panel01, BoxLayout.X_AXIS));
		//panel02.setLayout(new GridLayout(1,2,5,5));
		panel02.setLayout(new BoxLayout(panel02, BoxLayout.X_AXIS));
		panel03.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel001.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel002.setLayout(new FlowLayout(FlowLayout.CENTER));
		source.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		cypher.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		//panel03.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		shear.setPreferredSize(new Dimension(30,20));
		shear.setHorizontalAlignment(JTextField.CENTER);
		source.setLineWrap(true);
		cypher.setLineWrap(true);
		
		panel001.add(lab2);
		panel002.add(lab3);
		panel01.add(panel001);
		panel01.add(panel002);
		panel02.add(source);
		panel02.add(cypher);
		panel03.add(lab1);
		panel03.add(shear);
		panel04.add(crypt);
		panel1.add(panel01);
		panel1.add(panel02);
		panel1.add(panel03);
		panel1.add(panel04);
		tabPanel.addTab("шифр Цезаря", panel1);
		getContentPane().add(tabPanel);
		
		crypt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cryptActionPerformed(e);
			}
		});
	}

}
