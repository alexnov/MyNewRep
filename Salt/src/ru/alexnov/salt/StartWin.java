package ru.alexnov.salt;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartWin extends JFrame {
	
	JPanel contentPanel = new JPanel();
	
	public StartWin(){
		super("Справочник");
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		getContentPane().add(contentPanel);
	}

}
