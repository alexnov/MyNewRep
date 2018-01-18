package ru.alexnov.spacer;

public class AnnuliPressure {
//D - внутренний диаметр внешнего цилиндра (диаметр скважины)
//d - наружный диаметр внутреннего цилиндра (обсадной колонны)
//Q - производительность, ro - плотность, mu - в€зкость
public static double toNewton(double D, double dn, double Q, double ro, double mu){
	double p = 0.0;
	double lambda = 0.0;
	//Ќаходим критерий –ейнольдса
	double re = Reynolds.anNuRe(Q, ro, D, dn, mu);
	//ќпредел€ем критический расход
	double qkr = (2320*Math.PI*(D-dn)*mu)/(4*ro);
	if (Q<qkr){
		lambda = 64/re; 
	}
	else {
		double power = (0.0003/(D-dn))+(68/re);
		lambda = 0.11*Math.pow(power, 0.25);
	}
	p = (lambda*8*Math.pow(Q, 2)*ro)/(Math.pow(Math.PI, 2)*Math.pow(D-dn, 3)*Math.pow(D+dn, 2));
	return p;
}
public static double toBinghamApprox(double tau0, double ro, double D, double dn, double Q, double eta){
	double p = 0.0;
	//Ќаходим критическую скорость потока
	double vkr = Math.sqrt(25*(tau0/ro));
	//Ќаходим критический расход
	double qkr = (Math.PI/4)*(D*D-dn*dn)*vkr;
	if (Q<qkr){
		p = ((128*Q*eta)/(Math.PI*Math.pow((D-dn), 3)*(D+dn))) + (16*tau0)/(3*(D-dn));
	}
	else{
		double vk = (4*Q)/(Math.PI*(D*D-dn*dn));
		double reg = Reynolds.anBiReGen(vk, D, dn, ro, eta, tau0);
		double lambda = 0.09/Math.pow(reg, 0.125);
		p = (lambda*8*Q*Q*ro)/(Math.PI*Math.PI*Math.pow((D-dn), 3)*Math.pow((D+dn), 2));
	}
	return p;
}
}
