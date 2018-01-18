package ru.alexnov.wellcementing;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cement {
	
	JPanel mixCem = new JPanel(); 
	JLabel title = new JLabel("Рецептура раствора");
	
	public Cement(){
		mixCem.add(title);
	}

}
