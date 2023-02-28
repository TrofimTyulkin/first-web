package com.calc;
/**<b>Абстракция калькулятора</b>
 * @author Tyulkin Trofim
 * 
 */
public abstract class Calc {
	/**Основа тарифа*/
	private double baseTarif = 5;
	/**Сумма*/
	private double sum = 0;
	/**Рассчет*/
	public double calc(double ind) {
		sum = baseTarif * ind;
		return sum;
	}
	/**Получение основы тарифа*/
	final public double getBaseTarif() {
		return baseTarif;	
	}
	/**Установление основы тарифа*/
	final public void setBaseTarif(double tarif) {
		this.baseTarif = tarif;
	}
	
	@Override
	public String toString() {
		return "You must pay ";
	}
}