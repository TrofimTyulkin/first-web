package com.calc;

/**<b>Калькулятор (однозонный)</b>
 * @author Tyulkin Trofim
 * 
 */
public class Tarif1 extends Calc{
	
	//Константы
	//пояснение для нейминга констант: первая цифра после основного названия константы номер класса тарифа
	//вторая цифра номер переменной в самом классе
	//последня часть cheap принадлежность тарифа к сельской местности
	/**Дешевый тариф*/
	private static final double TARIF11cheap = 2.81;
	/**Дефолтный тариф*/
	private static final double TARIF11 = 4.01;
	/**Сумма*/
	private static double sum;
	/**Рассчет*/
	public double calcer(double ind, boolean hasGas, boolean fromCountry) {
		
		if (!hasGas ||fromCountry)  setBaseTarif(TARIF11cheap);
		else setBaseTarif(TARIF11);
		sum = calc(ind);
		//Double outputString = new Double(calc(ind));
		return sum;
	}
	@Override
	final public String toString() {
		return "Вы должны заплатить: " + String.format("%.2f",sum) +" руб";
	}
	/**Получение результата*/
	public static double getRes() {
		return sum;
	}
	
}
