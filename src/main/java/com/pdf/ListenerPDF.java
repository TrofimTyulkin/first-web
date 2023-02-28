package com.pdf;
/**<b>Вывод в Пдф</b>
 * @author Kolpashnikova Sofia
 * 
 */


import java.io.IOException;


import javax.swing.JTextField;

import com.calc.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.user.Person;

import create.CreatePDF;


import java.net.URL;

public class ListenerPDF {
	/**Для тестинга*/
	private static boolean isTest = false;
	/**Установка для тестинга*/
	public static void setIsTest(boolean val) {
		isTest = true;
	}
	/**Формирование ПДФ*/
	public static void createPDF(int tarif, String path, double[] inds, double[] out, boolean chipTarif) {
		
		String[][] NameCell = new String[3][6];;
		String[] Hat = new String[6];
		JTextField[] fields;
		String[] res = {"1","2","3","4","5","6"};
		double result = 0; 
		
		//
		
		if (tarif == 0) {
			if (chipTarif) {
				NameCell[0][4]="2.81 руб/КВт";
			}
			else {
				NameCell[0][4]="4.01 руб/КВт";
			}

			NameCell[0][0]="         1";
			NameCell[0][1]="ДЕНЬ(Т1)";
			NameCell[0][2]=String.valueOf(inds[0]);//prev
			NameCell[0][3]=String.valueOf(inds[1]);//present
			
			NameCell[0][5]=String.format("%.2f",out[0]);
			result = out[0];
		}
		if (tarif == 1) {
			
			if (chipTarif) {
				NameCell[0][4]="3.05 руб/КВт";
				NameCell[1][4]="2.25 руб/КВт";
			}
			else {
				NameCell[0][4]="4.35 руб/КВт";
				NameCell[1][4]="3.21 руб/КВт";
			}
			

			
			NameCell[0][0]="         1";
			NameCell[0][1]="ДЕНЬ(Т1)";
			NameCell[0][2]=String.valueOf(inds[0]);
			NameCell[0][3]=String.valueOf(inds[1]);
			
			NameCell[0][5]=String.format("%.2f",out[0]);
			
			NameCell[1][0]="         2";
			NameCell[1][1]="НОЧЬ(Т2)";
			NameCell[1][2]=String.valueOf(inds[2]);
			NameCell[1][3]=String.valueOf(inds[3]);
			
			NameCell[1][5]=String.format("%.2f",out[1]);
			result = out[0] + out[1];
					
		}
		if (tarif == 2) {
			
			if (chipTarif) {
				NameCell[0][4]="3.45 руб/КВт";
				NameCell[1][4]="2.81 руб/КВт";
				NameCell[2][4]="2.25 руб/КВт";
			}
			else {
				NameCell[0][4]="4.93 руб/КВт";
				NameCell[1][4]="4.01 руб/КВт";
				NameCell[2][4]="3.21 руб/КВт";
			}
			
			
			NameCell[0][0]="         1";
			NameCell[0][1]="ПИК(Т1)";
			NameCell[0][2]=String.valueOf(inds[0]);
			NameCell[0][3]=String.valueOf(inds[1]);
			
			NameCell[0][5]=String.format("%.2f",out[0]);
			
			NameCell[1][0]="         2";
			NameCell[1][1]="ПОЛУПИК(Т3)";
			NameCell[1][2]=String.valueOf(inds[4]);
			NameCell[1][3]=String.valueOf(inds[5]);
			
			NameCell[1][5]=String.format("%.2f",out[1]);
			
			NameCell[2][0]="         3";
			NameCell[2][1]="НОЧЬ(Т2)";
			NameCell[2][2]=String.valueOf(inds[2]);
			NameCell[2][3]=String.valueOf(inds[3]);
			
			NameCell[2][5]=String.format("%.2f",out[2]);
			result =out[0] + out[1] + out[2];
		}

		Hat[0]="Код платежа";
		Hat[1]="Тарифная зона";
		Hat[2]="Показания счетчика предыдущее";
		Hat[3]="Показания сетчика текущее";
		Hat[4]="Тариф";
		Hat[5]="Сумма к оплате (руб)";
		
		String Texthat = " Калькулятор расчета размеры платы за электроснабжение ";
		String Textgeneral = "Получатель платежа: ООО «Энергетическя сбытовая компания Башкортостана»: \n"
				+ "ИНН 0275038496 \n р/с 40702810200250303660 \n"
				 + "ф-л банк ГПБ (АО)в г. Уфе БИК 048073928"
				+ " КПП 027801001s \n к/с 30101810300000000928";
	
		String TextFirst;
		String TextSecond;
		String TextTable;
		/*if (!isTest) {
			System.out.println(" 21"+ fields[0].getText().equals(""));
		}
		
		if (!isTest) {
			TextFirst = "Номер лицевого счета: " + fields[0].getText();
			TextSecond = "Адрес: " + fields[1].getText();
			TextTable = "Ф.И.О.: " + fields[2].getText();
		}else {
			TextFirst = "Номер лицевого счета " + "12345673211";
			TextSecond = "Адрес: " + "Г.Уфа ул. есть д. нет";
			TextTable = "Ф.И.О.: " + "Иванов Иван Иванович";
		}*/
		TextFirst = "Номер лицевого счета " + Person.getBankAcc();
		TextSecond = "Адрес: " + Person.getAdress();
		TextTable = "Ф.И.О.: " + Person.getLastName() +" " + Person.getName() +" " + Person.getFathName();
		String Namefile = path + "mainAss.pdf";
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		URL image = ListenerPDF.class.getResource("/picture/code avengers.png");
		
		CreatePDF pdf = new CreatePDF(Namefile,times);
		Document document = pdf.getDocument();
		pdf.addText(document, Texthat, 20,true);
		pdf.addPicture(image, document, 725, 475);
		pdf.addText(document, Textgeneral, 14,true);
		pdf.addText(document, TextFirst, 14,true);
		pdf.addText(document, TextSecond, 14,true);
		pdf.addText(document, TextTable, 14, true);
		pdf.InitTableAndAddHat(document,Hat);
		pdf.addRowsInTable(pdf.getTable(), NameCell);
		pdf.addTable(document,pdf.getTable());
		//pdf.addText(document, TextNext, 14,true);
		//pdf.addPicture(Imagelink, document, 90, 400);
		pdf.addText(document, " ", 14, true);
		//pdf.addText(document, " Подпись абонента:", 14, true);
		pdf.addText(document, " Подпись абонента:                                                                                                                             Итого к оплате: " + String.format("%.2f",result), 14, true);
		pdf.getClose();
		
		
	}
}
