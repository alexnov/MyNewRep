package ru.alexnov.cementingquality;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;

public class HandleButton {
	
	static HWPFDocument doc = null;
	
	//Читаем файл
	public static HWPFDocument readFile() {
		JFileChooser fileload = new JFileChooser();
		FileInputStream fis = null;
		int ret = fileload.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION){
			File fileToLoad = fileload.getSelectedFile();
			try {
				fis = new FileInputStream(fileToLoad.getAbsolutePath());
				//Создаем новый документ
				try{doc = new HWPFDocument(fis);
				
				
				//Handling.saveText(doc);
				//String[] str = Handling.ggK(doc);
				//field1.setText(str[0]);
				//field2.setText(str[1]);
				}catch(IllegalArgumentException e3){
					JOptionPane.showMessageDialog(Window.panel, "Неправильный тип файла", "Ошибка", JOptionPane.ERROR_MESSAGE);
				} 
				
			}catch(IOException e1) {e1.printStackTrace();
			}finally{
				try{
					fis.close();
				}catch(IOException e2) {e2.printStackTrace();}
			}
		}
		
		return doc;
	}

	//Сохраняем файл
	public static void saveFile(HWPFDocument doc){
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
				for (int i=0; i<range.numParagraphs(); i++){
					Paragraph par = range.getParagraph(i);
					buff.write(par.text().trim());
					buff.newLine();
				}
				
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

