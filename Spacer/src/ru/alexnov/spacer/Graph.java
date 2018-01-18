package ru.alexnov.spacer;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Graph extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ny , nx , oyn , oyk , oyx , oxn , oxk , oxy , ly , lx , sw , xln , l2;
	private float xng , kx , ky , hx , yg , xk;
	
	public Graph(){
		ny = 10; //цена деления по шкалам
		ky = (float) 0.5; //коэф. шкалы по y
		kx = (float) 0.5; //коэф. шкалы по x
		oyn = 50; //начальный отступ по y
		oxn = 50; //начальный отступ по х
		ly = 400; //длина оси y
		lx = 600; //длина оси x
		hx = (float) 0.011; //Шаг табуляции
	}
	
	public void paint(Graphics g){
		//Разбиваем каждую ось на две части для удобства переноса
		//центра координат
		//Ось Y
		g.drawLine( (int) (lx*kx+oxn), oyn,
				(int) (lx*kx+oxn), ly+oyn);
		//Стрелки
		g.drawLine( (int) (lx*kx+oxn), oyn,
				(int) (lx*kx+oxn)-3, oyn+10);
		g.drawLine((int) (lx*kx+oxn), oyn,
				(int) (lx*kx+oxn)+3, oyn+10);
		//Надпись
		g.drawString("Y", (int) (lx*kx+oxn)-10, oyn+10);
		g.drawString("O", (int) (lx*kx+oxn)-10, (int) (ly*ky+oyn));
		//Деления
		int l1 = (int) (lx*kx);
		l2 = lx-l1;
		int k1 = (int) l1/ny;
		int k2 = (int) l2/ny;
		for (int i=1; i<k1+1; i++){
			g.drawLine((int) (lx*kx-2+oxn), l1-ny+oyn, (int) (lx*kx+2+oxn), l1-ny+oyn);
			l1 = l1 - ny;
		}
		l1=ly-l2;
		for (int i=1; i<k2+1; i++){
			g.drawLine((int)(lx*kx-2+oxn), l1+ny+oyn, (int)(lx*kx+2+oxn), l1+ny+oyn);
			l1=l1+ny;
		}
		//Ось х
		g.drawLine(oxn, (int) (ly*ky+oyn), lx+oxn, (int)(ly*ky+oyn));
		g.drawLine(lx+oxn, (int)(ly*ky+oyn), lx+oxn-10, (int)(ly*ky+oyn)-3);
		g.drawLine(lx+oxn, (int)(ly*ky+oyn), lx+oxn-10, (int)(ly*ky+oyn)+3);
		//Надпись
		g.drawString("X", lx+oyn-10, (int)(ly*ky+oyn)-10);
		//Деления
		l1 = (int)(lx*kx);
		l2 = lx-l1;
		k1 = (int) l1/ny;
		k2 = (int) l2/ny;
		for (int i=1; i<k1+1;i++){
			g.drawLine(l1-ny+oxn, (int)(ly*ky-2+oyn), l1-ny+oxn, (int)(ly*ky+2+oyn));
			l1 = l1 - ny;
		}
		l1 = lx - l2;
		double xl = l1/ny;
		double xl1 = l2/ny;
		for (int i=1; i<k2+1; i++){
			g.drawLine(l1+ny+oxn, (int)(ly*ky-2+oyn), l1+ny+oxn, (int)(ly*ky+2+oyn));
			l1 = l1+ny;
		}
		//Метод, рисующий график функции
		funcPar(g);
	}
	void funcPar(Graphics g){
		xln = (lx - l2);
		xk = 0;
		yg = 0;
		int kp = 0;
		while ((xk+hx)*ny<xln&&Math.pow(xk+hx, 2)*ny<ly*ky){
			g.drawLine((int)(xln-xk*ny+oxn), (int)(ly*ky-yg*ny+oyn), (int)(xln-(xk+hx)*ny+oxn), (int)(ly*ky-Math.pow(xk+hx, 2)*ny+oyn));
			xk = xk+hx;
			yg = (float)Math.pow(xk, 2);
			kp++;
		}
		xk=0;
		yg=0;
		while ((xk+hx)*ny<l2&&Math.pow(xk+hx, 2)*ny<ly*ky){
			yg = (float)Math.pow(xk, 2);
			g.drawLine((int)(xln+xk*ny+oxn), (int)(ly*ky-yg*ny+oyn), (int)(xln+(xk+hx)*ny+oxn), (int)(ly*ky-Math.pow(xk+hx, 2)*ny)+oyn);
			xk=xk+hx;
		}
	};

}
