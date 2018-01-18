package ru.alexnov.spacer;

public class Reynolds {
	
	public static double anNuRe(double Q, double ro, double D, double dn, double mu){
		double re = 0.0;
		re = 4*Q*ro/(Math.PI*(D-dn)*mu);
		return re;
	}
	public static double anBiRe(double v, double D, double dn, double ro, double eta){
		double re = 0.0;
		re = (v*(D-dn)*ro)/eta;
		return re;
	}
	public static double anBiSen(double tau0, double D, double dn, double v, double eta){
		double sen = 0.0;
		sen = (tau0*(D-dn))/(v*eta);
		return sen;
	}
	public static double anBiReGen(double v, double D, double dn, double ro, double eta, double tau0){
		double regen = 0.0;
		regen = anBiRe(v, D, dn, ro, eta)/(1+(anBiSen(tau0, D, dn, v, eta)/6));
		return regen;
	}

}
