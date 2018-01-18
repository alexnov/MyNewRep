package ru.alexnov.spacer;

import java.awt.Color;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class IsNumericDocListener implements DocumentListener {

	@Override
	public void changedUpdate(DocumentEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertUpdate(DocumentEvent event) {
		// TODO Auto-generated method stub
		String d = event.getDocument().getProperty("owner").toString();
		System.out.println(d);
		switch (d){
		case "mudw":{
			if (!checkString(Prog.win.mudWeight.getText())){
				Prog.win.mudWeight.setBackground(Color.RED);
			}
			else{
				Prog.win.mudWeight.setBackground(Color.WHITE);
			}
			return;
		}
		case "mudv":{
			if (!checkString(Prog.win.mudVisc.getText())){
				Prog.win.mudVisc.setBackground(Color.RED);
			}
			else{
				Prog.win.mudVisc.setBackground(Color.WHITE);
			}
			return;
		}
		case "mudy":{
			if (!checkString(Prog.win.mudYeld.getText())){
				Prog.win.mudYeld.setBackground(Color.RED);
			}
			else{
				Prog.win.mudYeld.setBackground(Color.WHITE);
			}
			return;
			
		}
		case "mudn":{
			if (!checkString(Prog.win.mudNfield.getText())){
				Prog.win.mudNfield.setBackground(Color.RED);
			}
			else{
				Prog.win.mudNfield.setBackground(Color.WHITE);
			}
			return;
		}
		case "mudk":{
			if (!checkString(Prog.win.mudKfield.getText())){
				Prog.win.mudKfield.setBackground(Color.RED);
			}
			else{
				Prog.win.mudKfield.setBackground(Color.WHITE);
			}
			return;
		}
		}

	}

	@Override
	public void removeUpdate(DocumentEvent event) {
		// TODO Auto-generated method stub
		String d = event.getDocument().getProperty("owner").toString();
		System.out.println(d);
		switch (d){
		case "mudw":{
			if (!checkString(Prog.win.mudWeight.getText())){
				Prog.win.mudWeight.setBackground(Color.RED);
			}
			else{
				Prog.win.mudWeight.setBackground(Color.WHITE);
			}
			return;
		}
		case "mudv":{
			if (!checkString(Prog.win.mudVisc.getText())){
				Prog.win.mudVisc.setBackground(Color.RED);
			}
			else{
				Prog.win.mudVisc.setBackground(Color.WHITE);
			}
			return;
		}
		case "mudy":{
			if (!checkString(Prog.win.mudYeld.getText())){
				Prog.win.mudYeld.setBackground(Color.RED);
			}
			else{
				Prog.win.mudYeld.setBackground(Color.WHITE);
			}
			return;
		}
		case "mudn":{
			if (!checkString(Prog.win.mudNfield.getText())){
				Prog.win.mudNfield.setBackground(Color.RED);
			}
			else{
				Prog.win.mudNfield.setBackground(Color.WHITE);
			}
			return;
		}
		case "mudk":{
			if (!checkString(Prog.win.mudKfield.getText())){
				Prog.win.mudKfield.setBackground(Color.RED);
			}
			else{
				Prog.win.mudKfield.setBackground(Color.WHITE);
			}
			return;
		}
		}

	}
	
	//Проверяем, является ли строка числом
		public boolean checkString(String string) {
	        try {
	            Double.parseDouble(string);
	        } catch (Exception e) {
	            return false;
	        }
	        return true;
	    }

}
