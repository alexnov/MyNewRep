package ru.alexnov.spacer;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SpacerWindow extends JFrame {
	
	Graph gr; // класс графика
	
	public SpacerWindow(){
		super("Реологиеская иерархия");
		Container c = getContentPane();
		c.setLayout(new BorderLayout()); //менеджер разметки
		gr = new Graph(); //инициализация графика
		gr.setSize(600, 450); //задаем размеры
		c.add(gr, BorderLayout.CENTER);
		setSize(700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	//public static void main(String[] args){
	//	new SpacerWindow();
//	}
}
