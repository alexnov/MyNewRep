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
		ny = 10; //���� ������� �� ������
		ky = (float) 0.5; //����. ����� �� y
		kx = (float) 0.5; //����. ����� �� x
		oyn = 50; //��������� ������ �� y
		oxn = 50; //��������� ������ �� �
		ly = 400; //����� ��� y
		lx = 600; //����� ��� x
		hx = (float) 0.011; //��� ���������
	}
	
	public void paint(Graphics g){
		//��������� ������ ��� �� ��� ����� ��� �������� ��������
		//������ ���������
		//��� Y
		g.drawLine( (int) (lx*kx+oxn), oyn,
				(int) (lx*kx+oxn), ly+oyn);
		//�������
		g.drawLine( (int) (lx*kx+oxn), oyn,
				(int) (lx*kx+oxn)-3, oyn+10);
		g.drawLine((int) (lx*kx+oxn), oyn,
				(int) (lx*kx+oxn)+3, oyn+10);
		//�������
		g.drawString("Y", (int) (lx*kx+oxn)-10, oyn+10);
		g.drawString("O", (int) (lx*kx+oxn)-10, (int) (ly*ky+oyn));
		//�������
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
		//��� �
		g.drawLine(oxn, (int) (ly*ky+oyn), lx+oxn, (int)(ly*ky+oyn));
		g.drawLine(lx+oxn, (int)(ly*ky+oyn), lx+oxn-10, (int)(ly*ky+oyn)-3);
		g.drawLine(lx+oxn, (int)(ly*ky+oyn), lx+oxn-10, (int)(ly*ky+oyn)+3);
		//�������
		g.drawString("X", lx+oyn-10, (int)(ly*ky+oyn)-10);
		//�������
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
		//�����, �������� ������ �������
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
