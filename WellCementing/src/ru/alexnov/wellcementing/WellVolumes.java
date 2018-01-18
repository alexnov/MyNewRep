package ru.alexnov.wellcementing;

import java.util.ArrayList;

public class WellVolumes {
	
	//Единичный элемент массива
	double [] unit =  new double [3];
	//0 - глубина по стволу
	//1 - наружный диаметр
	//2 - диаметр колонны
	ArrayList<double[]> spisok = new ArrayList<double[]>();
	
	public WellVolumes(int prev, int open){
		
		for (int i=0; i<prev; i++){
			double outer = Program.previous[i][2]-2*Program.previous[i][3];
			double [] one = {Program.previous[i][1], outer, 0.0};
			spisok.add(one);
		}
		for (int i=0; i<open; i++){
			double outer = Program.openhole[i][2]*Math.sqrt(Program.openhole[i][3]);
			double [] one = {Program.openhole[i][1], outer, 0.0};
			spisok.add(one);
		}
		
	}

}


