package ru.alexnov.gidra;

public class Reynolds {
	
	//Re ��� ������������ �������� � ��������� ������������
	public static double anNuRe(double Q, double ro, double D, double d, double mu){
		double Re = (4*Q*ro)/(Math.PI*(D-d)*mu);
		return Re;
	}

}
