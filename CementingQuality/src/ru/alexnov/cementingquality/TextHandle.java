package ru.alexnov.cementingquality;

import org.apache.poi.hwpf.usermodel.Table;

public class TextHandle {
	
	//АКЦ БНГКМ или Тамбей?
	public static boolean isBov(Table table){
		boolean res = false;
		for (int row = 0; row<table.numRows(); row++){
			String st = table.getRow(row).text();
			if (st.contains("ВУКТЫЛГАЗГЕОФИЗИКА")){
				res = true;
				break;
			}
		}
		
		return res;
	}

}
