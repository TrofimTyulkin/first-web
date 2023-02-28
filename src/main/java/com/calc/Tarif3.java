package com.calc;

/**<b>Калькулятор (трехзонный)</b>
 * @author Tyulkin Trofim
 * 
 */
public class Tarif3 extends Calc {
	/**Сумма*/
	private static double[] sum = {0, 0, 0};
	//Константы
	//пояснение для нейминга констант: первая цифра после основного названия константы номер класса тарифа
	//вторая цифра номер переменной в самом классе
	//последня часть cheap принадлежность тарифа к сельской местности
	/**Дешевый тариф*/
	private static final double TARIF31cheap = 3.45;
	/**Дешевый тариф*/
	private static final double TARIF32cheap = 2.81;
	/**Дешевый тариф*/
	private static final double TARIF33cheap = 2.25;
	/**Дефолтный тариф*/
	private static final double TARIF31 = 4.93;
	/**Дефолтный тариф*/
	private static final double TARIF32 = 4.01;
	/**Дефолтный тариф*/
	private static final double TARIF33 = 3.21;
	/**Рассчет*/
	final public double[] calcer(double ind1, double ind2, double ind3, boolean hasGas, boolean fromCountry) {
		if (!hasGas ||fromCountry) {
			setBaseTarif(TARIF31cheap);
			sum[0] = calc(ind1);
			setBaseTarif(TARIF32cheap);
			sum[1] = calc(ind3);
			setBaseTarif(TARIF33cheap);
			sum[2] = calc(ind2);
		}
		else {
			setBaseTarif(TARIF31);
			sum[0] = calc(ind1);
			setBaseTarif(TARIF32);
			sum[1]= calc(ind3);
			setBaseTarif(TARIF33);
			sum[2] = calc(ind2);
		}
		return sum;
		
	}
	@Override
	final public String toString() {
		return "Вы должны заплатить за пик " + String.format("%.2f",sum[0]) +" руб" + 
				"<br> Вы должны заплатить за полупик " + String.format("%.2f",sum[1]) +" руб" + 
				"<br> Вы должны заплатить за ночь " + String.format("%.2f",sum[2]) +" руб";
	}
	/**Получение результата*/
	final public static double getRes() {
		return sum[0]+sum[1]+sum[2];
	}
	
}
