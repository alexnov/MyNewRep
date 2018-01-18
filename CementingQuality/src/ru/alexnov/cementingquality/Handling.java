package ru.alexnov.cementingquality;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableRow;

public class Handling {
	
	//Обработка данных ГГК
	public static String[] ggK(HWPFDocument doc){
		Table table = null;
		boolean find = false;
		String[] res = {"Таблица ГГК не найдена", null};
		//Считываем данные файла
		Range range = doc.getRange();
		//Считываем его по абзацам
		for (int i=0; i<range.numParagraphs(); i++){
			Paragraph par = range.getParagraph(i);
			//Ищем заголовок нашей таблицы
			if (par.text().trim().equals("Заключение по ГГКц:")){
				//Ищем таблицу после заголовка
				int j = i;
				while (j<i+5){
					if (range.getParagraph(j).isInTable()){
						Paragraph par1 = range.getParagraph(j);
						table = range.getTable(par1);
						find = true;
						break;
					}
					j++;
				} if (find){
					double[] res1 = calcGGK(table);
					
					
					res[0] = "Средневзвешенная плотность цементного камня"+" "+res1[0];
					res[1] = "Средневзвешенный эксцентриситет"+" "+res1[1];
					return res;
				}
				else {return res;}
			}
			
		}
		return res;
	}
	
	private static double[] calcGGK(Table table){
		double[] ggk = {0.0, 0.0};
		//Создаем массив из данных таблицы
		//и убираем null
		String[] data = new String[table.numRows()-3];
		for (int y=0; y<data.length; y++){
			data[y]="";
		}
		double sumlen = 0;//суммарная длина интервалов
		double sumex = 0; //суммарный эксцентрисистет
		double sumpr = 0;//суммарное произведение
		for (int rowIdx=3; rowIdx<table.numRows(); rowIdx++){
			//Считываем таблицу построчно
			TableRow row = table.getRow(rowIdx);
			//Читаем строку по ячейкам
			for (int colIdx=0; colIdx<row.numCells(); colIdx++){
				TableCell cell = row.getCell(colIdx);
				//Сохраняем данные из строки таблицы в элементе массива
				data[rowIdx-3] = data[rowIdx-3]+cell.getParagraph(0).text().trim()+" ";
			}
			//Сохраняем содержимое строки в массиве, деля его по пробелам
			String oneline[] = data[rowIdx-3].split(" ");
			//сохраняем в переменной длину интервала
			try{
			double len = Double.parseDouble(oneline[2].replace(",", "."));
			//сохраняем в переменной плотность камня
			double ro = Double.parseDouble(oneline[3].replace(",", "."));
			//сохраняем в переменной эксцентриситет
			double exc = Double.parseDouble(oneline[5].replace(",", "."));
			//суммируем
			sumlen = sumlen + len;
			sumpr = sumpr + len*ro;
			sumex = sumex + exc*len;
			}catch(IllegalArgumentException e3){
				
			}catch (ArrayIndexOutOfBoundsException e){}
		}
		//Средневзвешенная плотность камня
		double weRo = (Math.round(sumpr/sumlen*1000))/1000.0;
		//Средневзвешенный эксцентриситет
		double weEx = (Math.round(sumex/sumlen*1000))/1000.0;
		ggk[0] = weRo;
		ggk[1] = weEx;
		
		return ggk;
	} 
	
	//Читаем содержимое документа и сохраняем в текстовом файле
	public static void saveText(HWPFDocument doc){
		JFileChooser filesave = new JFileChooser();
		FileWriter myFile = null;
		BufferedWriter buff = null;
		int ret = filesave.showSaveDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			// Создаём объект файла
			File fileToSave = filesave.getSelectedFile();
			try {
				// Объект, позволяющий осуществить запись в файл
				myFile = new FileWriter(fileToSave);
				// Буфер для записи
				buff = new BufferedWriter(myFile);
				//Считываем данные файла
				Range range = doc.getRange();
				Paragraph par1 = range.getParagraph(0);
				Table table1 = range.getTable(par1);
				if (TextHandle.isBov(table1)){
					JOptionPane.showMessageDialog(Window.panel, "Есть такая партия", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				//////////////////////
			//	for (int row = 0; row<table1.numRows(); row++){
			//		TableRow row1 = table1.getRow(row);
				//	buff.write(row1.text().trim());
				//	buff.newLine();
			//	}
				//for (int i=0; i<range.numParagraphs(); i++){
					//Paragraph par = range.getParagraph(i);
					//buff.write(par.text().trim());
					//buff.newLine();
				//}
				
			}catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					buff.flush();
					buff.close();
					myFile.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
