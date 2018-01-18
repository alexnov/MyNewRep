package ru.alexnov.complex;

import java.lang.Math;

public class Complex {
	private double Re;
	private double Im;
	public Complex(double a, double b){
	Re = a;
	Im = b;
	}
	public double getRe(){
		return Re;
	}
	public double getIm(){
		return Im;
	}
	private void setRe(double newRe){
		Re = newRe;
	}
	private void setIm(double newIm){
		Im = newIm;
	}
	//сложение комплексных чисел
	public Complex plus(Complex ads){
		double thisRe = getRe();
		double thisIm = getIm();
		double adsRe = ads.getRe();
		double adsIm = ads.getIm();
		Complex res = new Complex(thisRe+adsRe, thisIm+adsIm);
		return res;
	}
	//вычитание комплексных чисел
	public Complex minus(Complex ads){
		double thisRe = getRe();
		double thisIm = getIm();
		double adsRe = ads.getRe();
		double adsIm = ads.getIm();
		Complex res = new Complex(thisRe-adsRe, thisIm-adsIm);
		return res;
	}
	//умножение комплексного числа на действительное число
	public Complex mulRe(double x){
		double thisRe = getRe();
		double thisIm = getIm();
		Complex res = new Complex(thisRe*x, thisIm*x);
		return res;
	}
	//Модуль комплексного числа
	public double absComp(){
		double thisRe = getRe();
		double thisIm = getIm();
		double res = Math.sqrt(thisRe*thisRe+thisIm*thisIm);
		return res;
	}
	//Из полярных координат в декартовы
	public Complex toDecart(double r, double phi){
		double thisRe = r*Math.cos(phi);
		double thisIm = r*Math.sin(phi);
		Complex res = new Complex(thisRe, thisIm);
		return res;
	}
	//Умножение двух комплексных чисел
	public Complex mulCom(Complex ads){
		double thisRe = getRe();
		double thisIm = getIm();
		double adsRe = ads.getRe();
		double adsIm = ads.getIm();
		double resRe = thisRe*adsRe - thisIm*adsIm;
		double resIm = thisRe*adsIm + adsRe*thisIm;
		return new Complex(resRe, resIm);
	}
	//Деление комплексных чисел
	//Наше число делим на ads
	public Complex divCom(Complex ads){
		double thisRe = getRe();
		double thisIm = getIm();
		double adsRe = ads.getRe();
		double adsIm = ads.getIm();
		double resRe = (thisRe*adsRe + thisIm*adsIm)/(ads.absComp()*ads.absComp());
		double resIm = (thisRe*adsIm - adsRe*thisIm)/(ads.absComp()*ads.absComp());
		return new Complex(resRe, resIm);
	}
	//Возведение комплексного числа в целую степень
	public Complex powerCom(Complex ads, int n){
		for (int i=1; i<n; i++){
		ads = ads.mulCom(ads);
		}
		return ads;
	}
}
